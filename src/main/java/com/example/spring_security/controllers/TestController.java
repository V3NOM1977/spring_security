package com.example.spring_security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = { "/", "/index" })
    public String index() {
        return "Hello Wrld...!!";
    }
    

}
    