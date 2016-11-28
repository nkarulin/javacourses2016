package com.epam.javacourses2016;

/**
 * Created by kodoo on 13.11.16.
 */
public class Car {

    private int startPosition;
    private int speed;

    public Car(int startPosition, int speed) {
        this.startPosition = startPosition;
        this.speed = speed;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getSpeed() {
        return speed;
    }
}
