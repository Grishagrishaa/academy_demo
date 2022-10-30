package com.example.it_academy_users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableJpaAuditing
@EnableTransactionManagement
@SpringBootApplication
public class ItAcademyUsersApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ItAcademyUsersApplication.class, args);
    }

}
