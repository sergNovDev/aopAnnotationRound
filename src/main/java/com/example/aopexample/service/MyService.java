package com.example.aopexample.service;

import com.example.aopexample.annotation.LogTransformation;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @LogTransformation
    public String test(String param1, Integer param2){
        return "Hello Aspect "+ param1 + " " + param2;
    }
}
