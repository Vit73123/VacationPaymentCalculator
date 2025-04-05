package com.example.validation;

import com.example.error.IllegalRequestDataException;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class ValidationUtil {

    public static void validatePeriod(Integer days, LocalDate startDate, LocalDate endDate) {
        if ((days == null && startDate == null && endDate == null) ||
                (days != null && (startDate != null || endDate != null))) {
            throw new IllegalRequestDataException("Must be one of parameter(s): `days`, or 'startDate' and 'endDate'.");
        }
        if ((days == null) && (startDate == null || endDate == null)) {
            throw new IllegalRequestDataException("Must be two parameters: startDate and endDate.");
        }
    }
}
