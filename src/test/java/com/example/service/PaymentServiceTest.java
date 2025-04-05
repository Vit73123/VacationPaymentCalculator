package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService service;

    @Test
    void calculateBySalary() {

        assertEquals(
                PAYMENT, service.calculate(SALARY, DAYS));
    }

    @Test
    void calculateByDates() {
        assertEquals(
                PAYMENT, service.calculate(SALARY, START_DATE, END_DATE)
        );
    }
}