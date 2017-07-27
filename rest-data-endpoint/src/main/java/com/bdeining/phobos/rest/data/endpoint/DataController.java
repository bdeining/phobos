package com.bdeining.phobos.rest.data.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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
        LOGGER.info("Received data reading for : {}, sensorUuid : {}, temp : {}, voltage : {}", sensorReading.getId(), sensorReading.getSensorUuid(), sensorReading.getTemp(), sensorReading.getVoltage());
        sensorReadingRepository.save(sensorReading);
        return HttpStatus.OK;
    }

    @RequestMapping("/data/{sensorUuid}")
    public List<SensorReading> getDataById(@PathVariable("sensorUuid") String sensorUuid) {
        LOGGER.info("Received sensor requests for {}", sensorUuid);
        try {
            Integer integerSensorUuid = Integer.parseInt(sensorUuid);


            Iterable<SensorReading> sensorReadings = sensorReadingRepository.findAll();
            List<SensorReading> sensorReadingList = new ArrayList<>();
            for (SensorReading sensorReading : sensorReadings) {
                if (sensorReading.getSensorUuid().equals(integerSensorUuid)) {
                        sensorReadingList.add(sensorReading);
                }
            }

            if (CollectionUtils.isEmpty(sensorReadingList)) {
                LOGGER.info("No results found for {}", integerSensorUuid);
                return null;
            }

            return sensorReadingList;
        } catch (NumberFormatException e) {
            LOGGER.warn("Unable to parse id {}", sensorUuid);
        }
        return null;
    }
}