package starling.insights.api.service;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.HashMap;

@Singleton
public class StarlingAccountServiceImpl implements StarlingAccountService {

    @Override
    public HashMap<Month, Integer> getMonthsInBetween(Month startMonth, int startYear, Month endMonth, int endYear) {

        HashMap<Month, Integer> listOfMonths = new HashMap<>();

        LocalDate startDate = LocalDate.of(startYear, startMonth, 1);

        // We do +1 so that the period includes endMonth
        LocalDate endDate = LocalDate.of(endYear, endMonth.plus(1), 1);

        Period lengthBetweenDates = Period.between(startDate, endDate);

        for (int i = 0; i < lengthBetweenDates.getMonths(); i++) {
            listOfMonths.put(startDate.getMonth(), startDate.getYear());
            startDate = startDate.plusMonths(1);
            startDate = (i == 12) ? startDate.plusYears(1) : startDate;
        }

        return listOfMonths;
    }

}
