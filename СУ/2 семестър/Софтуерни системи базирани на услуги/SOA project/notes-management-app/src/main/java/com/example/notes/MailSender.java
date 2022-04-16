package com.example.notes;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class MailSender {

  public static void sendEmail(String email, String noteId, String noteContent) throws IOException {
    Email from = new Email("b.bantsova@gmail.com");
    String subject = "Notes with id: " + noteId;
    Email to = new Email(email);
    Content content = new Content("text/plain", noteContent);
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid("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");
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
