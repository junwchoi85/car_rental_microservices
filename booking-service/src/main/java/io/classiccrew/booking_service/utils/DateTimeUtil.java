package io.classiccrew.booking_service.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtil {
    public static LocalDateTime convertToDateTime(String date, String time) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);

        LocalDate localDate = LocalDate.parse(date, dateFormatter);
        LocalTime localTime = LocalTime.parse(time, timeFormatter);

        return LocalDateTime.of(localDate, localTime);
    }

    public static String convertToLocalDateString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDateTime.format(formatter);
    }

    public static String convertToLocalTimeString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
