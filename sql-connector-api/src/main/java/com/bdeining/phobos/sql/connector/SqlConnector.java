package com.bdeining.phobos.sql.connector;

import com.bdeining.phobos.rest.data.endpoint.SensorReading;

public interface SqlConnector {

    boolean postData(String table, SensorReading sensorReading);

}
