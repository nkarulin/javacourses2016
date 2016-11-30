package com.epam.javacourses2016;

/**
 * Created by kodoo on 13.11.16.
 */
public class Car {

    private int startPosition;
    private int actualPosition;
    private int speed;
    private int numberOfFinishedLaps;
    private long distanceCovered;

    public Car(int startPosition, int speed) {
        this.startPosition = startPosition;
        this.speed = speed;
        distanceCovered = startPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public int getNumberOfFinishedLaps() {
        return numberOfFinishedLaps;
    }

    public void setNumberOfFinishedLaps(int numberOfFinishedLaps) {
        this.numberOfFinishedLaps = numberOfFinishedLaps;
    }

    public long getDistanceCovered() {
        return distanceCovered;
    }
    public void setDistanceCovered(long distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

}
