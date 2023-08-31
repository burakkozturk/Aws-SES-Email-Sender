package aws.ses.sendMail.core;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.mail.MailSender;

@Configuration
public class AwsConfig {

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;


//    @Bean
//    public MailSender mailSender (AmazonSimpleEmailService amazonSimpleEmailService) {
//        return new SimpleEmailServiceMailSender(amazonSimpleEmailService);
//
//    }
//
//
//    @Bean
//    public AmazonSimpleEmailService amazonSimpleEmailService() {
//        return AmazonSimpleEmailServiceClientBuilder.standard()
//                .withRegion(region) // İstediğiniz bölgeyi burada belirtin
//                .withCredentials(new AWSStaticCredentialsProvider(
//                        new BasicAWSCredentials(accessKey, secretKey)))
//                .build();
//    }


}


