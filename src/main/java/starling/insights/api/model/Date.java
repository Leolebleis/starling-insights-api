package starling.insights.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import starling.insights.api.service.StarlingAccountService.Month;

import javax.inject.Singleton;

@Singleton
@Data
@AllArgsConstructor
public class Date {

    Month month;
    Integer year;

}
