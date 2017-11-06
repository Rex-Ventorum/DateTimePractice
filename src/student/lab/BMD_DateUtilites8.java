/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 *
 * @author L117student
 */
public class BMD_DateUtilites8 {
    
    public static final String SHORT_DATE_ONLY = "MM/dd/yyyy";
    public static final String LONG_DATE_ONLY = "MMMM dd, yyyy";
    public static final String SHORT_TIME_ONLY = "hh:mm a";
    public static final String LONG_TIME_ONLY = "HH:mm:ss:nn";
    public static final String SHORT_DATE_TIME = SHORT_DATE_ONLY + " " + SHORT_TIME_ONLY;
    public static final String LONG_DATE_TIME = LONG_DATE_ONLY + " " + LONG_TIME_ONLY;
    
    
    private String defaultPattern;
    
    public BMD_DateUtilites8(){
        defaultPattern = SHORT_DATE_TIME;
    }
    
    public final int getTemporalFieldBetween(LocalDateTime date1, LocalDateTime date2, TemporalField unit)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException {
       if(date1 == null || date2 == null || unit == null) throw new IllegalArgumentException("Arguments May Not Be Null");
       if(date1.isAfter(date2)){LocalDateTime temp = date1;date1 = date2;date2 = temp;}//Swap Dates
       return date1.get(unit) - date2.get(unit); 
    }
    
    public final LocalDateTime findNextDayOfWeekWithDateOfMonth(DayOfWeek dow, int dom) throws IllegalArgumentException{
       return findNextDayOfWeekWithDateOfMonth(LocalDateTime.now(),dow,dom);
    }
    
    public final LocalDateTime findNextDayOfWeekWithDateOfMonth(LocalDateTime date,DayOfWeek dow, int dom) throws IllegalArgumentException{
        if(date == null) throw new IllegalArgumentException("Date May Not Be Null");
        if(dow == null) throw new IllegalArgumentException("Day Of Week May Not Be Null");
        if(dom > 31 || dom < 1) throw new IllegalArgumentException("Day Of Month Must Be Between 1-31 inclusive");
        do{
            date = date.with(TemporalAdjusters.next(dow));
        }while(date.getDayOfMonth() != dom);
        return date;
    }

    public final String formatLocalDateTimeToString(LocalDateTime date)throws IllegalArgumentException{
        return formatLocalDateTimeToString(date,defaultPattern);
    }
    
    public final String formatLocalDateTimeToString(LocalDateTime date, String pattern) throws IllegalArgumentException{
        if(date == null || pattern == null || pattern.isEmpty()) throw new IllegalArgumentException("Arguments May Not Be Null Or Empty String");
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }
    
    public final LocalDateTime getLocalDateTimeFromString(String dateString) throws IllegalArgumentException{
        return getLocalDateTimeFromString(dateString,defaultPattern);
    }
    
    public final LocalDateTime getLocalDateTimeFromString(String dateString, String pattern)throws IllegalArgumentException{
        if(dateString == null || dateString.isEmpty() || pattern == null || pattern.isEmpty()) throw new IllegalArgumentException("Arguments May Not Be Null Or Empty");
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    }    
    
    public final void setDefaultFormatPattern(String pattern) throws IllegalArgumentException{
        if(pattern == null || pattern.isEmpty()) throw new IllegalArgumentException("Pattern May Not Be Null Or Empty");
        defaultPattern = pattern;
    }
    
    public final String getDefaultFormatPattern(){
        return defaultPattern;
    }
}
