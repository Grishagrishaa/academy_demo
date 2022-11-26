package com.example.consumers_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableJpaAuditing
@EnableTransactionManagement
@SpringBootApplication
public class ConsumersDemoApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ConsumersDemoApplication.class, args);
    }

}
