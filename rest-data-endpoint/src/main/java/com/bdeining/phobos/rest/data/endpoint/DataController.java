package com.bdeining.phobos.rest.data.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdeining.phobos.common.SensorReading;
import com.bdeining.phobos.sql.connector.SensorReadingRepository;

@RestController
public class DataController {

    @Autowired
    private SensorReadingRepository sensorReadingRepository;

    public DataController() {

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    @RequestMapping("/data")
    public HttpStatus data(@RequestBody SensorReading sensorReading) {
        LOGGER.info("Received data reading for : {}, temp : {}, voltage : {}", sensorReading.getId(), sensorReading.getTemp(), sensorReading.getVoltage());
        sensorReadingRepository.save(sensorReading);
        return HttpStatus.OK;
    }
}