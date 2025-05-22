package com.urfu.project.controller;


import com.urfu.project.annotation.ApiLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/limited")
    @ApiLimit
    public String limitedMethod() {
        return "Метод выполнен";
    }
}
