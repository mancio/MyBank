package com.mancio.MyBank.controlles;

import com.mancio.MyBank.entities.BkAccount;
import com.mancio.MyBank.exception.ResourceNotFoundException;
import com.mancio.MyBank.repositories.BkRep;
import com.mancio.MyBank.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            return userep.save(user);

        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));

    }

    @GetMapping(value = "/customers/{customerId}/accounts")
    public Page<Account> all (@PathVariable Integer customerId,Pageable pageable){
        return bkrep.findByCustomerCustomerId(customerId, pageable);
    }

    @DeleteMapping(value = "/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer customerId,@PathVariable Integer accountId){

        if (!userep.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found");
        }

        return bkrep.findById(accountId).map(account ->{
            bkrep.delete(account);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Account [accountId="+accountId+"] can't be found"));

    }

    @PutMapping(value = "/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer customerId,@PathVariable Integer accountId,@RequestBody Account newAccount){

        Customer customer = userep.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));

        return bkrep.findById(accountId).map(account ->{
            newAccount.setCustomer(customer);
            bkrep.save(newAccount);
            return ResponseEntity.ok(newAccount);
        }).orElseThrow(() -> new ResourceNotFoundException("Account [accountId="+accountId+"] can't be found"));


    }