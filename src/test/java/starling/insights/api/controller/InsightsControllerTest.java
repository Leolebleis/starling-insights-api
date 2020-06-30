package starling.insights.api.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import starling.insights.api.client.StarlingClient;
import starling.insights.api.model.Account;
import starling.insights.api.service.StarlingAccountService;
import starling.insights.api.service.StarlingAccountServiceImpl;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.UUID;

import static org.mockito.Mockito.*;

@MicronautTest
@Slf4j
public class InsightsControllerTest {



//    @Test
//    void testGetAccounts() {
//        HashMap<String, Account[]> body = new HashMap<>() {{
//            put("accounts", new Account[]{
//                    new Account(UUID.randomUUID(), UUID.randomUUID(), "GBP", "2018-03-20T14:25:37.200Z"),
//                    new Account(UUID.randomUUID(), UUID.randomUUID(), "EUR", "2018-03-20T14:25:37.200Z")
//            });
//        }};
//
//    }

}
