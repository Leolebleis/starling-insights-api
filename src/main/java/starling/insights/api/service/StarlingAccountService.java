package starling.insights.api.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public interface StarlingAccountService {

    /**
     * @param startMonth first month
     * @param startYear  first year
     * @param endMonth   second month
     * @param endYear    second year
     * @return a list of the months between the two dates given, in the format of [Month, Year]
     */
    ArrayList<LocalDate> getMonthsInBetween(Month startMonth, int startYear, Month endMonth, int endYear);

}
