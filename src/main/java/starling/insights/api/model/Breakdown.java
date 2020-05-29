package starling.insights.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Singleton;

@Singleton
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Breakdown {

    int totalSpent;
    int totalReceived;
    int netSpend;
    String netDirection;
    String currency;
    int percentage;
    int transactionCount;

}
