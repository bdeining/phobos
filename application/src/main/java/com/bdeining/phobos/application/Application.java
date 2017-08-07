package com.bdeining.phobos.application;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bdeining.phobos.common.SensorReading;
import com.bdeining.phobos.react.ReactController;
import com.bdeining.phobos.rest.data.endpoint.DataController;

@EntityScan("com.bdeining.phobos.common")
@EnableJpaRepositories(basePackages = {"com.bdeining.phobos.sql.connector","com.bdeining.phobos.common"})
@SpringBootApplication
@ComponentScan
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Post initial data for development purposes
     *
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String uuid = UUID.randomUUID().toString();
            for (int i =0; i < 5; i++) {
                SensorReading sensorReading = new SensorReading(68, 12345, uuid);
                dataController().data(sensorReading);
            }
            LOGGER.info("Posting sensor data for UUID : {}", uuid);
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