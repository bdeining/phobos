package com.bdeining.phobos.sql.connector;

import org.springframework.stereotype.Component;

import com.bdeining.phobos.rest.data.endpoint.SensorReading;

@Component
public class SqlConnectorImpl implements SqlConnector {

    @Override
    public boolean postData(String table, SensorReading sensorReading) {
        return false;
    }
}
