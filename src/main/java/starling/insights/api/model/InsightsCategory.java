package starling.insights.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.inject.Singleton;

@EqualsAndHashCode(callSuper = true)
@Singleton
@Data
public class InsightsCategory extends InsightsObject {

    private InsightsCategoryBreakdown[] breakdown;

    InsightsCategory() {
        super();
    }

    InsightsCategory(String period,
                     int totalSpent,
                     int totalReceived,
                     int netSpend,
                     int totalSpendNetOut,
                     int totalReceivedNetIn,
                     String currency,
                     String direction,
                     InsightsCategoryBreakdown[] breakdown
    ) {
        super(period, totalSpent, totalReceived, netSpend, totalSpendNetOut, totalReceivedNetIn, currency, direction);

        this.breakdown = breakdown;
    }
}
