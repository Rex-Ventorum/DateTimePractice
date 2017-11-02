/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdk8.api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 *
 * @author L117student
 */
public class NextFridayThirteenth {
    public static void main(String[] args) {
//        LocalDate nextFriday13 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
//        while(nextFriday13.getDayOfMonth() != 13){
//            nextFriday13 = nextFriday13.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
//        }
//        System.out.println(nextFriday13.format(DateTimeFormatter.ofPattern("MMMM/dd/yyyy")));   
//        
//        LocalDate today = LocalDate.now();
//        LocalDate date = LocalDate.of(2017, Month.NOVEMBER, 1);
//        System.out.println(today.equals(date));

          LocalDate christmas = LocalDate.of(2017, Month.DECEMBER, 25);
          System.out.println(christmas.getDayOfWeek());
    }
}
