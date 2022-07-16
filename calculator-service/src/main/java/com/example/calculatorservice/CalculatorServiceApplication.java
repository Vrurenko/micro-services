package com.example.calculatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class CalculatorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorServiceApplication.class, args);
    }
}