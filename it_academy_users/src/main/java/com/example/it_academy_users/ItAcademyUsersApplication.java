package com.example.it_academy_users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@EnableTransactionManagement
@SpringBootApplication
public class ItAcademyUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItAcademyUsersApplication.class, args);
    }

}
