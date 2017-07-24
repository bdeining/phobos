package com.bdeining.phobos.sql.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bdeining.phobos.common.SensorReading;

@Component
public class SqlConnectorImpl implements SqlConnector {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlConnectorImpl.class);

    @Override
    public boolean postData(String table, SensorReading sensorReading) {
        LOGGER.info("Post Data {} {}", table, sensorReading);
        return false;
    }
}
