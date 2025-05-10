package com.toda.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TodoMgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoMgtApplication.class, args);
    }

}
