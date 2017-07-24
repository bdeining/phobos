package com.bdeining.phobos.sql.connector;

import com.bdeining.phobos.common.SensorReading;

public interface SqlConnector {

    boolean postData(String table, SensorReading sensorReading);

}
