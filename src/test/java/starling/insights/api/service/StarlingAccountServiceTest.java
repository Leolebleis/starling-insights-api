package starling.insights.api.service;

import io.micronaut.test.annotation.MicronautTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import starling.insights.api.service.StarlingAccountService;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@MicronautTest
@Slf4j
public class StarlingAccountServiceTest {

    @Inject
    StarlingAccountService starlingAccountService;

    @ParameterizedTest
    @CsvSource({"1,2020,2,2020", "1,2020,1,2020", "1,2020,12,2020", "1,2020,1,2021"})
    void testGetMonthsInBetween_Parameterized(Integer firstMonth, Integer firstYear, Integer secondMonth, Integer secondYear) {

        log.info("TEST: Returning list of months between [ {} - {} and {} - {} ]", firstMonth, firstYear, secondMonth, secondYear);
        Month initialMonth = Month.of(firstMonth);
        Month endMonth = Month.of(secondMonth);

        final ArrayList<LocalDate> result = starlingAccountService.getMonthsInBetween(initialMonth, firstYear, endMonth, secondYear);

        log.info("RESULTS: [ {} ]", result);

        // Assertions
        assertNotEquals(0, result.size());

    }

    @Test
    void testGetMonthsInBetween_HappyPath() {
        final ArrayList<LocalDate> result = starlingAccountService.getMonthsInBetween(Month.of(1), 2020, Month.of(12), 2020);

        log.info("TEST: Returning list of months between [ {} - {} and {} - {} ]", Month.of(1), 2020, Month.of(12), 2020);

        log.info("RESULTS: [ {} ]", result);

        ArrayList<LocalDate> benchmark = new ArrayList<>() {{
            for (int i = 1; i <= 12; i++) {
                add(LocalDate.of(2020, Month.of(i), 1));
            }
        }};

        assertEquals(benchmark, result);
    }

    @Test
    void testGetMonthsInBetween_UnhappyPath() {
        final ArrayList<LocalDate> result = starlingAccountService.getMonthsInBetween(Month.of(1), 2020, Month.of(2), 2019);

        log.info("TEST: Returning list of months between [ {} - {} and {} - {} ]", Month.of(1), 2020, Month.of(2), 2019);

        log.info("RESULTS: [ {} ]", result);

        assertEquals(0, result.size());
    }

}
