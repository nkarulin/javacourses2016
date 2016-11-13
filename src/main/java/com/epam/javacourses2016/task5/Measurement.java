package com.epam.javacourses2016.task5;

/**
 * Created by kodoo on 13.11.16.
 */
public class Measurement {
    private double current;
    private double voltage;

    public Measurement(double current, double voltage) {
        this.current = current;
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public double getVoltage() {
        return voltage;
    }
}
