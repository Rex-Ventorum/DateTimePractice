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
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 *
 * @author L117student
 */
public class BMD_DateUtilites8 {
    
    private static final int BREAK_DOWN_UNITS = 6;
    public static final int YEARS_IN_ARRAY = 0;
    public static final int MONTHS_IN_ARRAY = 1;
    public static final int DAYS_IN_ARRAY = 2;
    public static final int HOURS_IN_ARRAY = 3;
    public static final int MINNUTES_IN_ARRAY = 4;
    public static final int SECONDS_IN_ARRAY = 5;
    
    public static final String SHORT_DATE_ONLY = "MM/dd/yyyy";
    public static final String LONG_DATE_ONLY = "MMMM dd, yyyy";
    public static final String SHORT_TIME_ONLY = "hh:mm a";
    public static final String LONG_TIME_ONLY = "HH:mm:ss:";
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
    
    public final long getTemporalUnitBetween(LocalDateTime date1, LocalDateTime date2, TemporalUnit unit)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException {
       if(date1 == null || date2 == null || unit == null) throw new IllegalArgumentException("Arguments May Not Be Null");
       if(date1.isAfter(date2)){LocalDateTime temp = date1;date1 = date2;date2 = temp;}//Swap Dates
       return date1.until(date2, unit);
     }
        
    public final long getYearsBetween(LocalDateTime date1, LocalDateTime date2)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException {
       return getTemporalUnitBetween(date1,date2,ChronoUnit.YEARS);
    }
    
    public final long getMonthsBetween(LocalDateTime date1, LocalDateTime date2)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException {
       return getTemporalUnitBetween(date1,date2,ChronoUnit.MONTHS);
    }
    
    public final long getDaysBetween(LocalDateTime date1, LocalDateTime date2)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException {
       return getTemporalUnitBetween(date1,date2,ChronoUnit.DAYS);
    }
    
    public final long getMinnutesBetween(LocalDateTime date1, LocalDateTime date2)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException {
       return getTemporalUnitBetween(date1,date2,ChronoUnit.MINUTES);
    }
    
    public final long getHoursBetween(LocalDateTime date1, LocalDateTime date2)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException {
       return getTemporalUnitBetween(date1,date2,ChronoUnit.HOURS);
    }
    
    public final long[] getChronoUnitBreakDownBetween(LocalDateTime date1, LocalDateTime date2)
            throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException,IllegalArgumentException{
       if(date1 == null || date2 == null) throw new IllegalArgumentException("Arguments May Not Be Null");
       if(date1.isAfter(date2)){LocalDateTime temp = date1;date1 = date2;date2 = temp;}//Swap Dates
       
       long[] breakDown = new long[BREAK_DOWN_UNITS];
       LocalDateTime temp = LocalDateTime.from(date1);
       
       breakDown[YEARS_IN_ARRAY] = date1.until(temp, ChronoUnit.YEARS);
       temp.plusYears(breakDown[YEARS_IN_ARRAY]);
       
       breakDown[MONTHS_IN_ARRAY] = date1.until(temp, ChronoUnit.MONTHS);
       temp.plusMonths(breakDown[MONTHS_IN_ARRAY]);
       
       breakDown[DAYS_IN_ARRAY] = date1.until(temp, ChronoUnit.DAYS);
       temp.plusDays(breakDown[DAYS_IN_ARRAY]);
       
       breakDown[HOURS_IN_ARRAY] = date1.until(temp, ChronoUnit.HOURS);
       temp.plusHours(breakDown[HOURS_IN_ARRAY]);
              
       breakDown[MINNUTES_IN_ARRAY] = date1.until(temp, ChronoUnit.MINUTES);
       temp.plusMinutes(breakDown[MINNUTES_IN_ARRAY]);
       
       breakDown[SECONDS_IN_ARRAY] = date1.until(temp, ChronoUnit.SECONDS);
       temp.plusSeconds(breakDown[SECONDS_IN_ARRAY]);
       
       return breakDown;
    }
    
    
    public final String getChronoUnitBreakDownToString(LocalDateTime date1, LocalDateTime date2) throws IllegalArgumentException{
        return getChronoUnitBreakDownToString(getChronoUnitBreakDownBetween(date1,date2));
    }
    public final String getChronoUnitBreakDownToString(long[] breakDown) throws IllegalArgumentException{
        if(breakDown == null) throw new IllegalArgumentException("Array May Not Be Null");
        if(breakDown.length != BREAK_DOWN_UNITS) throw new IllegalArgumentException("Array Must Have Length Of " + BREAK_DOWN_UNITS);
        return breakDown[YEARS_IN_ARRAY] + " years, " +
               breakDown[MONTHS_IN_ARRAY] + " months, " +
               breakDown[DAYS_IN_ARRAY] + " days, " +
               breakDown[HOURS_IN_ARRAY] + " hours, " +
               breakDown[MINNUTES_IN_ARRAY] + " minnutes, " +
               breakDown[SECONDS_IN_ARRAY] + " seconds";               
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
