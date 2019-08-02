package com.mancio.MyBank.controlles;

import com.mancio.MyBank.entities.User;
import com.mancio.MyBank.exception.ResourceNotFoundException;
import com.mancio.MyBank.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRep userep;

    @PostMapping(value = "/customers")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userep.save(user);
    }

    @GetMapping(value = "/customers")
    public Page<User> all (Pageable pageable){
        return userep.findAll(pageable);

    }

    @GetMapping(value = "/customers/{customerId}")
    public User findByCustomerId (@PathVariable Long customerId){
        return userep.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));
    }

    @DeleteMapping(value = "/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){

        return userep.findById(customerId).map(customer -> {
                    userep.delete(customer);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));

    }

    @PutMapping(value = "/customers/{customerId}")
    public ResponseEntity<User> updateCustomer(@PathVariable Long customerId, @RequestBody User newuser){

        return userep.findById(customerId).map(user -> {
            user.setName(newuser.getName());
            user.setBirth(newuser.getBirth());
            user.setMail(newuser.getMail());
            user.setPhone(newuser.getPhone());
            userep.save(user);
            return ResponseEntity.ok(user);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));

    }



}
