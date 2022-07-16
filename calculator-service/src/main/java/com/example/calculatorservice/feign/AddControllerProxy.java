package com.example.calculatorservice.feign;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "addition-service")
@RibbonClient(name = "addition-service")
public interface AddControllerProxy {
    @GetMapping("/add")
    Number add(@RequestParam double a, @RequestParam double b);
}
