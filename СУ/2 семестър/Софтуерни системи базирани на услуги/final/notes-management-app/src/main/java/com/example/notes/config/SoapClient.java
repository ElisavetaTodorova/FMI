package com.example.notes.config;


import com.example.notes.soap.mailSender.Output;
import com.example.notes.soap.mailSender.SendEmailInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Output sendNoteToMail(SendEmailInput request) {
        template = new WebServiceTemplate(marshaller);

        Output output = null;
        try {
            output = (Output) template.marshalSendAndReceive("http://localhost:9091/ws/sendMailDemo",
                request);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        return output;
    }

}