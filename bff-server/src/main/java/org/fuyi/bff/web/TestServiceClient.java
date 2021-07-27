package org.fuyi.bff.web;

import org.fuyi.common.exception.ServiceException;
import org.fuyi.coreapi.client.TestClient;
import org.fuyi.coreapi.dto.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bff")
public class TestServiceClient {

    private RestTemplate restTemplate;
    private TestClient testClient;

    @Autowired
    public TestServiceClient(RestTemplate restTemplate, TestClient testClient){
        this.restTemplate = restTemplate;
        this.testClient = testClient;
    }

    @GetMapping("/test/name")
    public String getUserByName(String userName){
        ResponseEntity<String> restExchange = restTemplate.exchange("http://core/core/test/fuyi", HttpMethod.GET, null, String.class);
        String result = restExchange.getBody();
        return result;
    }
    @GetMapping("/test/feign")
    public String getUserByNameByFeign(){
        TestResponse resp = null;
        try {
            resp = testClient.test("feign");
        }catch (Exception ex) {
            String errMsg = "fail to get user";
            throw new ServiceException(errMsg, ex);
        }
        if (!resp.isSuccess()) {
            throw new ServiceException(resp.getMessage());
        }
        return resp.getData();
    }
}
