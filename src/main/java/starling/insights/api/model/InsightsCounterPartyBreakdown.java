package starling.insights.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.inject.Singleton;

@EqualsAndHashCode(callSuper = true)
@Data
@Singleton
public class InsightsCounterPartyBreakdown extends Breakdown {

    private String counterPartyUid;
    private String counterPartyType;
    private String counterPartyName;

    InsightsCounterPartyBreakdown() {
        super();
    }

    public InsightsCounterPartyBreakdown(String counterPartyUid,
                                         String counterPartyType,
                                         String counterPartyName,
                                         int totalSpent,
                                         int totalReceived,
                                         int netSpend,
                                         String netDirection,
                                         String currency,
                                         int percentage,
                                         int transactionCount) {
        super(totalSpent, totalReceived, netSpend, netDirection, currency, percentage, transactionCount);
        this.counterPartyUid = counterPartyUid;
        this.counterPartyType = counterPartyType;
        this.counterPartyName = counterPartyName;
    }
}
