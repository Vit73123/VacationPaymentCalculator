package com.example.web;

import com.example.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaymentController {

    PaymentService service;

    @GetMapping("/calculate")
    public int calculate(@RequestParam int salary, @RequestParam int days) {
        return service.calculate(salary, days);
    }
}
