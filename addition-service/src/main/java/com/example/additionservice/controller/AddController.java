package com.example.additionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class AddController {
    private static final Logger LOG = Logger.getLogger("AddController");

    @GetMapping("/add")
    public Number add(@RequestParam double a, @RequestParam double b) {
        LOG.warning("I am adding numbers " + a + " and " + b);
        return a + b;
    }
}
