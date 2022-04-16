package com.example.ws.endpoint;

import com.example.ws.model.ObjectFactory;
import com.example.ws.model.Output;
import com.example.ws.model.SendEmailInput;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;

@Endpoint
public class MailSender {

    @ResponsePayload
    @PayloadRoot(namespace = "http://localhost:9091/types/SendEmailInput", localPart = "SendEmailInput")
    public Output sendMail(@RequestPayload SendEmailInput input) {
        Email from = new Email("b.bantsova@gmail.com");
        String subject = "Sending Note...";
        Email to = new Email(input.getRecipient());
        Content content = new Content("text/plain", input.getBody());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(response.getStatusCode());
        return output;

    }
}
