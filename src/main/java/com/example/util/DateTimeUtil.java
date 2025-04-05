package com.example.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DateTimeUtil {

    public static final Map<DateTypes, Set<LocalDate>> checkedDays = new HashMap<>();

    public static final double DAYS_IN_MONTH = 29.3;

    static {
        checkedDays.put(DateTypes.HOLIDAY,
                new TreeSet<>(Set.of(
                        LocalDate.of(2025, 1, 1),
                        LocalDate.of(2025, 1, 2),
                        LocalDate.of(2025, 1, 3),
                        LocalDate.of(2025, 1, 6),
                        LocalDate.of(2025, 1, 7),
                        LocalDate.of(2025, 1, 8),
                        LocalDate.of(2025, 5, 1),
                        LocalDate.of(2025, 5, 2),
                        LocalDate.of(2025, 5, 8),
                        LocalDate.of(2025, 5, 9),
                        LocalDate.of(2025, 6, 12),
                        LocalDate.of(2025, 6, 13),
                        LocalDate.of(2025, 7, 3),
                        LocalDate.of(2025, 7, 4),
                        LocalDate.of(2025, 12, 31)
                )));
        checkedDays.put(DateTypes.WEEKEND_WORKING_DAY,
                new TreeSet<>(Set.of(
                        LocalDate.of(2025, 7, 11)
                )
                ));
    }

    public static boolean isWorkingDay(LocalDate date) {
        return !checkedDays.get(DateTypes.HOLIDAY).contains(date) &&
                (checkedDays.get(DateTypes.WEEKEND_WORKING_DAY).contains(date) ||
                        (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY));
    }
}
