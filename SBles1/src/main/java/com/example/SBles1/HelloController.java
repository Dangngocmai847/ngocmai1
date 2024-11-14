package com.example.SBles1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/greeting")
    public String greeting() {
        return "Hello World";
    }
}
