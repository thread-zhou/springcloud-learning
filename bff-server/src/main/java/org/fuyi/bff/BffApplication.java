package org.fuyi.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"org.fuyi.coreapi"})
public class BffApplication {

    @Bean
    @LoadBalanced
    public RestTemplate getResultTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(BffApplication.class, args);
    }
}
