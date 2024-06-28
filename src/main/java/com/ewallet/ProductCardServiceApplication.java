package com.ewallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProductCardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCardServiceApplication.class, args);
    }


}
