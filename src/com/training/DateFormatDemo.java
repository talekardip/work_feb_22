package com.training;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {
    public static void main(String[] args){
        Locale loc = new Locale("fr", "FR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        DateFormat dateFormat1 = DateFormat.getTimeInstance(DateFormat.DEFAULT, loc);
        String date = dateFormat.format(new Date());
        String date1 = dateFormat1.format(new Date());
        System.out.println(date);
        System.out.println(date1);

        String pattern = "dd-MMM-YYYY";
        SimpleDateFormat datePattern = new SimpleDateFormat(pattern);
        String date2 = datePattern.format(new Date());
        System.out.println(date2);

        //converting string to date format so parse in proper format
        LocalDate date3 = LocalDate.parse("2024-02-23");
        System.out.println(date3);

    }
}