package com.mancio.MyBank.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

public class HomeCont {

    @RequestMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login page";
    }

    @RequestMapping("/signup")
    public String signup(){
        return "signup page";
    }

    @RequestMapping(value = "/privatearea", method = RequestMethod.GET)
    public String privatepage(Model model, Principal principal){
        
    }
}
