package com.bdeining.phobos.application;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bdeining.phobos.react.ReactController;
import com.bdeining.phobos.rest.data.endpoint.DataController;

@EntityScan("com.bdeining.phobos.common")
@EnableJpaRepositories(basePackages = {"com.bdeining.phobos.sql.connector","com.bdeining.phobos.common"})
@SpringBootApplication
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    @Bean
    public DataController dataController() {
        return new DataController();
    }

    @Bean
    public ReactController reactController() {
        return new ReactController();
    }


}