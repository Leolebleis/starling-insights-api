package starling.insights.api.service;

import starling.insights.api.model.Date;

import java.util.ArrayList;
import java.util.HashMap;

public interface StarlingAccountService {

    HashMap<Integer, Month> months = new HashMap<>() {
        {
            put(1, Month.JANUARY);
            put(2, Month.FEBRUARY);
            put(3, Month.MARCH);
            put(4, Month.APRIL);
            put(5, Month.MAY);
            put(6, Month.JUNE);
            put(7, Month.JULY);
            put(8, Month.AUGUST);
            put(9, Month.SEPTEMBER);
            put(10, Month.OCTOBER);
            put(11, Month.NOVEMBER);
            put(12, Month.DECEMBER);
        }
    };

    Integer getMonthIndex(Month month);

    ArrayList<Date> getMonthsInBetween(Month startMonth, int startYear, Month endMonth, int endYear);

    enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

}
