package com.mancio.MyBank.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private BkController bkController;

    @Autowired
    private UserController usercontroller;

    

}
