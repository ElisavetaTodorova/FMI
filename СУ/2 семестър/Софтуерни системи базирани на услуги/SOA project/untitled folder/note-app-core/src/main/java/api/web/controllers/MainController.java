package api.web.controllers;

import api.models.LoginData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Controller
@RequestMapping(value = "/")
public class MainController {


  @RequestMapping(value = "/autenticate",  method = {RequestMethod.GET, RequestMethod.POST})
  public String searchLogsGet(@ModelAttribute("loginData") LoginData loginData, Model model) throws Exception {

    HttpHeaders headers = new HttpHeaders();
    String basicAuthorization = loginData.uid + ":" + loginData.password;
    String base64Authorization = new String(Base64.getEncoder().encode(basicAuthorization.getBytes()));
    headers.add(AUTHORIZATION, "Basic " + base64Authorization);
    HttpEntity<?> requestEntity = new HttpEntity<Object>("", headers);
    
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<String> exchange = null;
    try {
      exchange = restTemplate.exchange("http://localhost:8081", HttpMethod.GET, requestEntity, String.class);
    }catch (Exception e) {
      return "login";
    }
    
    return "index.html";
  }
}
