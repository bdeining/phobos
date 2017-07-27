package com.bdeining.phobos.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_reading")
public class SensorReading {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer temp;

    private Integer voltage;

    private Integer sensorUuid;

    public Long getId() {
        return id;
    }

    public Integer getTemp() {
        return temp;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public Integer getSensorUuid() {
        return sensorUuid;
    }

}
