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
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

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
    public Account[] getAccounts(@Header(AUTHORIZATION) String auth) {
        return starlingClient.getAccounts(auth).getBody().get().get("accounts");
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
    public Single<ArrayList<InsightsCounterParty>> getInsightsCounterPartyBetweenTwoDates(@Header(AUTHORIZATION) String auth,
                                                                                          @QueryValue("firstMonth") String firstMonth,
                                                                                          @QueryValue("firstYear") String firstYear,
                                                                                          @QueryValue("secondMonth") String secondMonth,
                                                                                          @QueryValue("secondYear") String secondYear,
                                                                                          @PathVariable("accountID") String accountID) {

        HashMap<Month, Integer> listOfDates = starlingAccountService.getMonthsInBetween(Month.valueOf(firstMonth.toUpperCase()),
                Integer.parseInt(firstYear), Month.valueOf(secondMonth.toUpperCase()), Integer.parseInt(secondYear));

        ArrayList<InsightsCounterParty> insightsCounterParties = new ArrayList<>() {
            {
                listOfDates.forEach((month, year) -> {
                    InsightsCounterParty monthlyInsight = starlingClient.getInsightsCounterParty(auth, accountID, month.toString(), year.toString()).getBody().get();
                    add(monthlyInsight);
                });
            }
        };

        return Single.just(insightsCounterParties);
    }

    @Get("/accounts/{accountID}/spending-insights/spending-category/between-two-dates")
    public Single<ArrayList<InsightsCategory>> getInsightsCategoryBetweenTwoDates(@Header(AUTHORIZATION) String auth,
                                                                                  @QueryValue("firstMonth") String firstMonth,
                                                                                  @QueryValue("firstYear") String firstYear,
                                                                                  @QueryValue("secondMonth") String secondMonth,
                                                                                  @QueryValue("secondYear") String secondYear,
                                                                                  @PathVariable("accountID") String accountID) {

        HashMap<Month, Integer> listOfDates = starlingAccountService.getMonthsInBetween(Month.valueOf(firstMonth.toUpperCase()),
                Integer.parseInt(firstYear), Month.valueOf(secondMonth.toUpperCase()), Integer.parseInt(secondYear));

        ArrayList<InsightsCategory> insightsCategories = new ArrayList<>() {
            {
                listOfDates.forEach((month, year) -> {
                    InsightsCategory monthlyInsight = starlingClient.getInsightsCategory(auth, accountID, month.toString(), year.toString()).getBody().get();
                    add(monthlyInsight);
                });
            }
        };

        return Single.just(insightsCategories);
    }

}
