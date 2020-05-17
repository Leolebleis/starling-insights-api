package starling.insights.api.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import starling.insights.api.model.Account;
import starling.insights.api.model.InsightsCategory;
import starling.insights.api.model.InsightsCounterParty;

import java.util.HashMap;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

@Client("https://api.starlingbank.com/api/v2")
public interface StarlingClient {

    @Get("/accounts")
    HttpResponse<HashMap<String, Account[]>> getAccounts(@Header(AUTHORIZATION) String auth);

    @Get("/accounts/{accountID}/spending-insights/counter-party")
    HttpResponse<InsightsCounterParty> getInsightsCounterParty(@Header(AUTHORIZATION) String auth, @PathVariable("accountID") String accountID, @QueryValue("month") String month,
                                                               @QueryValue("year") String year);

    @Get("/accounts/{accountID}/spending-insights/spending-category")
    HttpResponse<InsightsCategory> getInsightsCategory(@Header(AUTHORIZATION) String auth, @PathVariable("accountID") String accountID, @QueryValue("month") String month,
                                                       @QueryValue("year") String year);

}
