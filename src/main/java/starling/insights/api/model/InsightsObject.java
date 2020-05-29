package starling.insights.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Singleton;

@Singleton
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsightsObject {

    private String period;
    private int totalSpent;
    private int totalReceived;
    private int netSpend;
    private int totalSpendNetOut;
    private int totalReceivedNetIn;
    private String currency;
    private String direction;

}
