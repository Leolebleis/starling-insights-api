package starling.insights.api.service;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;

public interface StarlingAccountService {

    HashMap<Month, Integer> getMonthsInBetween(Month startMonth, int startYear, Month endMonth, int endYear);

}
