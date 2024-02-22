package com.training;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TimeTemporalDemo {
    public static void main(String... args){
        LocalDate date = LocalDate.now();
        System.out.println("Todays date "+date);

        LocalDate nextMonday = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Next monday "+nextMonday);

    }
}
