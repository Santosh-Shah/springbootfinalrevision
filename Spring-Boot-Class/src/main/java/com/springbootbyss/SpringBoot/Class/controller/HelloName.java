package com.springbootbyss.SpringBoot.Class.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloName {
    @GetMapping("/")
    public String printSantosh() {
        return "My Name is Santosh Shah \n What is you name?";
    }
}