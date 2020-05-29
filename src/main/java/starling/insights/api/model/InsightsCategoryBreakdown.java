package starling.insights.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.inject.Singleton;

@EqualsAndHashCode(callSuper = true)
@Data
@Singleton
public class InsightsCategoryBreakdown extends Breakdown {

    private String spendingCategory;

    InsightsCategoryBreakdown() {
        super();
    }

    public InsightsCategoryBreakdown(String spendingCategory,
                                     int totalSpent,
                                     int totalReceived,
                                     int netSpend,
                                     String netDirection,
                                     String currency,
                                     int percentage,
                                     int transactionCount) {
        super(totalSpent, totalReceived, netSpend, netDirection, currency, percentage, transactionCount);
        this.spendingCategory = spendingCategory;
    }


}
