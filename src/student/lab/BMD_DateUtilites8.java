/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 *
 * @author L117student
 */
public class BMD_DateUtilites8 {
    
    
    public final int getTemporalFieldBetween(LocalDateTime date1, LocalDateTime date2, ChronoField unit)
                throws DateTimeException,UnsupportedTemporalTypeException,ArithmeticException {
       if(date1.isAfter(date2)){LocalDateTime temp = date1;date1 = date2;date2 = temp;}//Swap Dates
       return date1.get(unit) - date2.get(unit); 
    }
}
