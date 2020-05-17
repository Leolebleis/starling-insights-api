package starling.insights.api.model;

import lombok.Data;

import javax.inject.Singleton;

@Data
@Singleton
public class InsightsCategory {

    private String period;
    private int totalSpent;
    private int totalReceived;
    private int netSpend;
    private int totalSpendNetOut;
    private int totalReceivedNetIn;
    private String currency;
    private String direction;
    private InsightsCategoryBreakdown[] breakdown;

}
