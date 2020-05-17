package starling.insights.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.inject.Singleton;
import java.util.LinkedHashMap;

@EqualsAndHashCode(callSuper = true)
@Singleton
@Data
public class Account extends LinkedHashMap<String, String> {

    private String accountUid;
    private String defaultCategory;
    private String currency;
    private String createdAt;

}
