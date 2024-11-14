package com.example.SBles1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class Exercise2 {
    @GetMapping("/exercise2/{word}")
    public ResponseEntity<Map<String, Object>> translate(@PathVariable String word){
        Map<String, Object> response = new HashMap<>();
        String convertWord = word.toLowerCase().replaceAll("\\s+", " ");
        if(word.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Khong duoc de trong"));
        }
        String result;
            switch (convertWord) {
                case "hello":
                    result = "xin chào";
                    break;
                case "black":
                    result = "màu đen";
                    break;
                case "environment":
                    result = "môi trường";
                    break;
                case "community":
                    result = "cộng đồng";
                    break;
                default:
                    result = "Khong co trong tu dien!";

        }
        response.put("status", HttpStatus.OK);
        response.put("result", result);
        return ResponseEntity.ok(response);

        }

    }


