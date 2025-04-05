package com.example.web;

import com.example.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.example.validation.ValidationUtil.validatePeriod;

@RestController
@AllArgsConstructor
public class PaymentController {

    PaymentService service;

    @GetMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Calculate vacation payment by days, or by dates of the vacation",
            description = "Days should be a number. Dates must be in format 'YYYY-MM-DD'.")
    public double calculate(@RequestParam double salary,
                            @RequestParam @Nullable Integer days,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Nullable LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Nullable LocalDate endDate) {
        validatePeriod(days, startDate, endDate);
        return service.calculate(salary, days, startDate, endDate);
    }
}
