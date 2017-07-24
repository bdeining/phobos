package com.bdeining.phobos.rest.data.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdeining.phobos.common.SensorReading;
import com.bdeining.phobos.sql.connector.SqlConnector;

@RestController
public class DataController {

    private SqlConnector sqlConnector;

    public DataController(SqlConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    @RequestMapping("/data")
    public HttpStatus data(@RequestBody SensorReading sensorReading) {
        LOGGER.info("Received data reading for : {}", sensorReading.getId());

        sqlConnector.postData("data", sensorReading);

        return HttpStatus.OK;
    }
}