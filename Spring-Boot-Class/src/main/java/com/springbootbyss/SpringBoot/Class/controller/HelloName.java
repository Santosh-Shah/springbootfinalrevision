package com.springbootbyss.SpringBoot.Class.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloName {
//    @GetMapping("/")
//    public String printSantosh() {
//        return "My Name is Ram Shah \n What is your name?";
//    }

    @Value("${welcome.message}")
    private String helloMessage;

    @GetMapping("/")
    public String msgMethod() {
        return helloMessage;
    }
}