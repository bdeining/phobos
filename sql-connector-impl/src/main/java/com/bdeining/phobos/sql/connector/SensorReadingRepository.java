package com.bdeining.phobos.sql.connector;

import org.springframework.data.repository.CrudRepository;

import com.bdeining.phobos.common.SensorReading;

public interface SensorReadingRepository extends CrudRepository<SensorReading, Long> {

}
