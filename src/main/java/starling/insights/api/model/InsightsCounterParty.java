package starling.insights.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.inject.Singleton;

@EqualsAndHashCode(callSuper = true)
@Singleton
@Data
public class InsightsCounterParty extends InsightsObject {

    InsightsCounterPartyBreakdown[] breakdown;

    public InsightsCounterParty() {
    }

    public InsightsCounterParty(String period, int totalSpent, int totalReceived, int netSpend, int totalSpendNetOut, int totalReceivedNetIn, String currency, String direction, InsightsCounterPartyBreakdown[] breakdown) {
        super(period, totalSpent, totalReceived, netSpend, totalSpendNetOut, totalReceivedNetIn, currency, direction);
        this.breakdown = breakdown;
    }
}
