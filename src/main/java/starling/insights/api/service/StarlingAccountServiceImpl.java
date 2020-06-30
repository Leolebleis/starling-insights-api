package starling.insights.api.service;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

@Singleton
@Slf4j
public class StarlingAccountServiceImpl implements StarlingAccountService {

    @Override
    public ArrayList<LocalDate> getMonthsInBetween(Month startMonth,
                                                   int startYear,
                                                   Month endMonth,
                                                   int endYear) {

        ArrayList<LocalDate> listOfDates = new ArrayList<>();

        LocalDate startDate = LocalDate.of(startYear, startMonth, 1);

        // We do +1 so that the period includes endMonth
        LocalDate endDate = endMonth.equals(Month.of(12)) ?
                LocalDate.of(endYear + 1, 1, 1) :
                LocalDate.of(endYear, endMonth.plus(1), 1);

        Period lengthBetweenDates = Period.between(startDate, endDate);

        int numberOfMonths = lengthBetweenDates.getYears() * 12 + lengthBetweenDates.getMonths();

        for (int i = 0; i < numberOfMonths; i++) {
            listOfDates.add(startDate);

            startDate = startDate.getMonth().getValue() == 12 ?
                    LocalDate.of(startDate.getYear() + 1, 1, 1) :
                    LocalDate.of(startDate.getYear(), startDate.getMonthValue() + 1, 1);
        }

        return listOfDates;
    }

}
