package com.example.additionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

    @GetMapping("/add")
    public Number add(@RequestParam double a, @RequestParam double b) {
        System.out.println("Adding");
        return a + b;
    }
}
