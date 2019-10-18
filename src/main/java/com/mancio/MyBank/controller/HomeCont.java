package com.mancio.MyBank.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeCont {

    @RequestMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login page";
    }
}
