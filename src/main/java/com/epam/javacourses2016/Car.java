package com.epam.javacourses2016;

/**
 * Created by kodoo on 13.11.16.
 */
public class Car {

    private int startPosition;
    private int speed;
    private int currentPosition;
    private int farAhead;

    public Car(int startPosition, int speed) {
        this.startPosition = startPosition;
        this.speed = speed;
        this.currentPosition = startPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getFarAhead() {
        return farAhead;
    }

    public void setFarAhead(int farAhead) {
        this.farAhead = farAhead;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
