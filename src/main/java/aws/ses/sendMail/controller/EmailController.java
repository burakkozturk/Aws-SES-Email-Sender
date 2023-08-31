package aws.ses.sendMail.controller;

import aws.ses.sendMail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public String sendEmail() {
        String recipient = "oztburak240@gmail.com";
        String subject = "Test Subject";
        String body = "This is a test email sent via AWS SES API.";

        emailService.sendEmail(recipient, subject, body);
        return "Email sent!";
    }
}
