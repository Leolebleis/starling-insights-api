package starling.insights.api.model;

import lombok.Data;

import javax.inject.Singleton;

@Data
@Singleton
public class InsightsCategoryBreakdown implements Breakdown {

    private String spendingCategory;
    private int totalSpent;
    private int totalReceived;
    private int netSpend;
    private String netDirection;
    private String currency;
    private int percentage;
    private int transactionCount;

}
