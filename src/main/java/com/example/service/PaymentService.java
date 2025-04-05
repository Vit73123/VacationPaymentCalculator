package com.example.service;

import com.example.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class PaymentService {

    public double calculate(double salary, Integer days, LocalDate startDate, LocalDate endDate) {
        if (days != null) {
            return calculate(salary, days);
        } else {
            return calculate(salary, startDate, endDate);
        }
    }

    public double calculate(double salary, LocalDate startDate, LocalDate endDate) {
        int workingDays = (int) startDate.datesUntil(endDate)
                .filter(DateTimeUtil::isWorkingDay)
                .count();
        return calculate(salary, workingDays);
    }

    public double calculate(double salary, int days) {
        return getDailySalary(salary)
                .multiply(BigDecimal.valueOf(days))
                .doubleValue();
    }

    private BigDecimal getDailySalary(double salary) {
        return BigDecimal.valueOf(salary)
                .divide(BigDecimal.valueOf(DateTimeUtil.DAYS_IN_MONTH), 2, RoundingMode.DOWN);
    }
}
