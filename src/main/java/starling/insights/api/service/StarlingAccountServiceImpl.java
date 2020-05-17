package starling.insights.api.service;

import starling.insights.api.model.Date;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;

@Singleton
public class StarlingAccountServiceImpl implements StarlingAccountService {

    @Override
    public Integer getMonthIndex(Month month) {
        for (HashMap.Entry<Integer, Month> entry : months.entrySet()) {
            if (month.equals(entry.getValue())) {
                return entry.getKey();
            }
        }

        return -1;
    }

    @Override
    public ArrayList<Date> getMonthsInBetween(Month startMonth, int startYear, Month endMonth, int endYear) {
        ArrayList<Date> result = new ArrayList<>();

        int numberOfMonths = (endYear - startYear) * 12 + (getMonthIndex(endMonth) - getMonthIndex(startMonth));

        int year = startYear;
        Month month = startMonth;

        for (int i = 0; i <= numberOfMonths; i++) {

            Date date = new Date(month, year);

            result.add(date);

            month = months.get((getMonthIndex(month) % 12) + 1);

            if (date.getMonth() == Month.DECEMBER) {
                year++;
            }

        }

        return result;
    }

}
