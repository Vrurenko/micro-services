package com.example.calculatorservice.controller;

import com.example.calculatorservice.feign.AddControllerProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RefreshScope
public class CalculatorController {
    private static final Logger LOG = Logger.getLogger("CalculatorController");

    private final AddControllerProxy addControllerProxy;

    @Value("${driver}")
    String value;

    @Autowired
    public CalculatorController(AddControllerProxy addControllerProxy) {
        this.addControllerProxy = addControllerProxy;
    }

    @GetMapping("/add")
    @HystrixCommand(fallbackMethod = "defaultValue")
    public Number add(@RequestParam double a, @RequestParam double b) {
        LOG.info("I am adding numbers " + a + " and " + b);
        return addControllerProxy.add(a, b);
    }

    private Number defaultValue(double a, double b) {
        LOG.info("I am actually adding numbers " + a + " and " + b);
        return 0;
    }
}
