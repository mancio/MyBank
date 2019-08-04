package com.mancio.MyBank.controlles;

import com.mancio.MyBank.entities.BkAccount;
import com.mancio.MyBank.entities.User;
import com.mancio.MyBank.exception.ResourceNotFoundException;
import com.mancio.MyBank.repositories.BkRep;
import com.mancio.MyBank.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BkController {

    @Autowired
    private UserRep userep;

    @Autowired
    private BkRep bkrep;

    @PostMapping(value = "/customers/{customerId}/accounts")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BkAccount save(@PathVariable Long customerId, @RequestBody BkAccount bk) {
        return userep.findById(customerId).map(user -> {
            bk.setUser(user);
            return bkrep.save(bk);

        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));

    }

    @GetMapping(value = "/customers/{customerId}/accounts")
    public Page<BkAccount> all (@PathVariable Long customerId, Pageable pageable){
        return bkrep.findByCustomerId(customerId, pageable);
    }

    @DeleteMapping(value = "/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long customerId, @PathVariable Long accountId){

        if (!userep.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found");
        }

        return bkrep.findById(accountId).map(account ->{
            bkrep.delete(account);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Account [accountId="+accountId+"] can't be found"));

    }

    @PutMapping(value = "/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<BkAccount> updateAccount(@PathVariable Long customerId,@PathVariable Long accountId,@RequestBody BkAccount newAccount){

        User user = userep.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));

        return bkrep.findById(accountId).map(account ->{
            newAccount.setUser(user);
            bkrep.save(newAccount);
            return ResponseEntity.ok(newAccount);
        }).orElseThrow(() -> new ResourceNotFoundException("Account [accountId="+accountId+"] can't be found"));


    }}