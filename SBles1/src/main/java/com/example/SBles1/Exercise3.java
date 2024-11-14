package com.example.SBles1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Exercise3 {
    @GetMapping("/exercise3")
    public ResponseEntity<Map<String, Object>> exercise(
            @RequestParam(defaultValue = "") String number1,
            @RequestParam(defaultValue = "") String number2,
            @RequestParam(defaultValue = "") String operator) {

        if (number1.isEmpty() || number2.isEmpty() || operator.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Thiếu tham số đầu vào hoặc toán tử không hợp lệ!"));
        }

        double result = 0;
        String message = "";
        double a = Double.parseDouble(number1);
        double b = Double.parseDouble(number2);

        Map<String, Object> response = new HashMap<>();

        switch (operator) {
            case "+":
                result = a + b;
                message = "Kết quả phép cộng: " + result;
                break;
            case "-":
                result = a - b;
                message = "Kết quả phép trừ: " + result;
                break;
            case "*":
                result = a * b;
                message = "Kết quả phép nhân: " + result;
                break;
            case "/":
                if (b == 0) {
                    message = "Không thể chia cho 0!";
                    response.put("status", "error");
                    response.put("message", message);
                    return ResponseEntity.badRequest().body(response);
                }
                result = a / b;
                message = "Kết quả phép chia: " + result;
                break;
            default:
                message = "Toán tử không hợp lệ!";
                response.put("status", "error");
                response.put("message", message);
                return ResponseEntity.badRequest().body(response);
        }

        response.put("status", "success");
        response.put("result", result);
        response.put("message", message);
        return ResponseEntity.ok(response);
    }
}
