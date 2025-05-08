package com.toda.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserMgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMgtApplication.class, args);
    }

}
