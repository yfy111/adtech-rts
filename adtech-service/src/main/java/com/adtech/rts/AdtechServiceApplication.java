package com.adtech.rts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdtechServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdtechServiceApplication.class, args);
    }

}
