package ru.itis.my_reminder.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Utils {
    public static boolean isSameDay(Instant instant1, Instant instant2) {
        LocalDate ld1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault()).toLocalDate();
        LocalDate ld2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalDate();
        return ld1.equals(ld2);
    }
}
