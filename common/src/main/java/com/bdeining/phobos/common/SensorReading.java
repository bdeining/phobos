package com.bdeining.phobos.common;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class SensorReading {

    @Id
    private Integer id;

    private Integer temp;

    private Integer voltage;

    public Integer getId() {
        return id;
    }

    public Integer getTemp() {
        return temp;
    }

    public Integer getVoltage() {
        return voltage;
    }

}
