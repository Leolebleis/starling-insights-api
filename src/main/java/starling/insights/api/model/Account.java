package starling.insights.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.inject.Singleton;
import java.util.LinkedHashMap;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Singleton
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends LinkedHashMap<String, String> {

    private UUID accountUid;
    private UUID defaultCategory;
    private String currency;
    private String createdAt;

}
