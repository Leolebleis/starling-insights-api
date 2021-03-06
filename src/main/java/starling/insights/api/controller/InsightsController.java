package starling.insights.api.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import starling.insights.api.client.StarlingClient;
import starling.insights.api.model.Account;
import starling.insights.api.model.InsightsCategory;
import starling.insights.api.model.InsightsCounterParty;
import starling.insights.api.service.StarlingAccountService;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

@Controller
@Slf4j
public class InsightsController {

    private final StarlingClient starlingClient;
    private final StarlingAccountService starlingAccountService;

    @Inject
    public InsightsController(final StarlingClient starlingClient,
                              final StarlingAccountService starlingAccountService) {

        this.starlingAccountService = starlingAccountService;
        this.starlingClient = starlingClient;
    }

    @Get("/accounts")
    public HttpResponse<Account[]> getAccounts(@Header(AUTHORIZATION) String auth) {
        return HttpResponse.ok(starlingClient.getAccounts(auth).getBody().get().get("accounts"));
    }

    @Get("/accounts/{accountID}/spending-insights/counter-party")
    public HttpResponse<InsightsCounterParty> getInsightsCounterParty(@Header(AUTHORIZATION) String auth,
                                                                      @QueryValue("month") String month, @QueryValue("year") String year,
                                                                      @PathVariable("accountID") String accountID) {

        return starlingClient.getInsightsCounterParty(auth, accountID, month.toUpperCase(), year.toUpperCase());

    }

    @Get("/accounts/{accountID}/spending-insights/spending-category")
    public HttpResponse<InsightsCategory> getInsightsCategory(@Header(AUTHORIZATION) String auth,
                                                              @QueryValue("month") String month, @QueryValue("year") String year,
                                                              @PathVariable("accountID") String accountID) {
        return starlingClient.getInsightsCategory(auth, accountID, month.toUpperCase(), year.toUpperCase());
    }

    @Get("/accounts/{accountID}/spending-insights/counter-party/between-two-dates")
    public HttpResponse<Single<ArrayList<InsightsCounterParty>>> getInsightsCounterPartyBetweenTwoDates(@Header(AUTHORIZATION) String auth,
                                                                                                        @QueryValue("firstMonth") String firstMonth,
                                                                                                        @QueryValue("firstYear") String firstYear,
                                                                                                        @QueryValue("secondMonth") String secondMonth,
                                                                                                        @QueryValue("secondYear") String secondYear,
                                                                                                        @PathVariable("accountID") String accountID) {

        ArrayList<LocalDate> listOfDates = starlingAccountService.getMonthsInBetween(Month.valueOf(firstMonth.toUpperCase()),
                Integer.parseInt(firstYear), Month.valueOf(secondMonth.toUpperCase()), Integer.parseInt(secondYear));

        ArrayList<InsightsCounterParty> insightsCounterParties = new ArrayList<>() {
            {
                listOfDates.forEach((date) -> {
                    InsightsCounterParty monthlyInsight = starlingClient.getInsightsCounterParty(auth, accountID,
                            date.getMonth().toString(), Integer.toString(date.getYear())).getBody().get();
                    add(monthlyInsight);
                });
            }
        };

        return HttpResponse.ok(Single.just(insightsCounterParties));
    }

    @Get("/accounts/{accountID}/spending-insights/spending-category/between-two-dates")
    public HttpResponse<Single<ArrayList<InsightsCategory>>> getInsightsCategoryBetweenTwoDates(@Header(AUTHORIZATION) String auth,
                                                                                                @QueryValue("firstMonth") String firstMonth,
                                                                                                @QueryValue("firstYear") String firstYear,
                                                                                                @QueryValue("secondMonth") String secondMonth,
                                                                                                @QueryValue("secondYear") String secondYear,
                                                                                                @PathVariable("accountID") String accountID) {

        ArrayList<LocalDate> listOfDates = starlingAccountService.getMonthsInBetween(Month.valueOf(firstMonth.toUpperCase()),
                Integer.parseInt(firstYear), Month.valueOf(secondMonth.toUpperCase()), Integer.parseInt(secondYear));

        ArrayList<InsightsCategory> insightsCategories = new ArrayList<>() {
            {
                listOfDates.forEach((date) -> {
                    InsightsCategory monthlyInsight = starlingClient.getInsightsCategory(auth, accountID,
                            date.getMonth().toString(), Integer.toString(date.getYear())).getBody().get();
                    add(monthlyInsight);
                });
            }
        };

        return HttpResponse.ok(Single.just(insightsCategories));
    }

}
