package com.example.SBles1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise1 {
    @GetMapping("/exercise1")
    public String exercise(@RequestParam(defaultValue = " ") String name){
        return "Hello " + name;
    }
}
