package starling.insights.mail.controller;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import starling.insights.api.client.StarlingClient;
import starling.insights.api.service.StarlingAccountService;
import starling.insights.mail.GmailQuickstart;
import starling.insights.mail.service.EmailService;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Controller
@Slf4j
public class EmailController {

    private final EmailService emailService;

    @Inject
    public EmailController(final StarlingClient starlingClient,
                              final StarlingAccountService starlingAccountService,
                              final EmailService emailService) {

        this.emailService = emailService;
    }


    @Post(value = "/send-email", consumes = MediaType.TEXT_HTML)
    public Single<Message> postEmailTest(@Body String body, @Header String subject, @Header String recipient) throws GeneralSecurityException, IOException, MessagingException {

        Gmail service = new Gmail.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), GmailQuickstart.getCredentials(GoogleNetHttpTransport.newTrustedTransport()))
                .build();

        MimeMessage message = emailService.createEmail(recipient, "leo.lebleis@gmail.com", subject, body);

        return Single.just(emailService.sendMessage(service, "me", message));
    }

}
