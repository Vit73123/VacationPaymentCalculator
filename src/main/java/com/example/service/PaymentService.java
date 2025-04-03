package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public int calculate(int salary, int days) {
        return days * salary;
    }
}
