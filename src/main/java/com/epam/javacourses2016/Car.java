package com.epam.javacourses2016;

/**
 * Created by kodoo on 13.11.16.
 */
public class Car {

    private int startPosition;
    private int speed;
    private long currentPosition;
    private int farAhead;
    private int finishedLaps;

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

    public long getCurrentPosition() {
        return currentPosition;
    }

    public int getFarAhead() {
        return farAhead;
    }

    public void setFarAhead(int farAhead) {
        this.farAhead = farAhead;
    }

    public void setCurrentPosition(long currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getFinishedLaps() {
        return finishedLaps;
    }

    public void setFinishedLaps(int finishedLaps) {
        this.finishedLaps = finishedLaps;
    }
}
