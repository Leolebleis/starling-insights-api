package starling.insights.api.model;

import lombok.Data;

import javax.inject.Singleton;

@Data
@Singleton
public class InsightsCounterPartyBreakdown implements Breakdown {

    private String counterPartyUid;
    private String counterPartyType;
    private String counterPartyName;
    private int totalSpent;
    private int totalReceived;
    private int netSpend;
    private String netDirection;
    private String currency;
    private int percentage;
    private String transactionCount;

}
