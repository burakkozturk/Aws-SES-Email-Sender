package aws.ses.sendMail.service;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${aws.region}")
    private String region;

    private final String ACCESS_KEY = "*";
    private final String SECRET_KEY = "*";



    public void sendEmail(String to, String subject, String body) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AmazonSimpleEmailService sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(region) // SES bölgesi
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        SendEmailRequest emailRequest = new SendEmailRequest()
                .withSource("oztburak240@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content().withData(subject))
                        .withBody(new Body().withText(new Content().withData(body))));

        sesClient.sendEmail(emailRequest);
    }
}
