package org.fuyi.coreserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CoreServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreServerApplication.class, args);
    }
}
