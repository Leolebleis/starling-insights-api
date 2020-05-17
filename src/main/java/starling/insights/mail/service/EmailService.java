package starling.insights.mail.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

public interface EmailService {
    public MimeMessage createEmail(String to,
                                   String from,
                                   String subject,
                                   String bodyText)
            throws MessagingException;

    public Message createMessageWithEmail(MimeMessage emailContent)
            throws MessagingException, IOException;

    public Message sendMessage(Gmail service,
                               String userId,
                               MimeMessage emailContent)
            throws MessagingException, IOException;

}
