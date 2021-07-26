package org.fuyi.bff.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bff")
public class TestServiceClient {

    private RestTemplate restTemplate;

    @Autowired
    public TestServiceClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test/name")
    public String getUserByName(String userName){
        ResponseEntity<String> restExchange = restTemplate.exchange("http://CORE-SERVER/core/test/fuyi", HttpMethod.GET, null, String.class);
        String result = restExchange.getBody();
        return result;
    }

}
