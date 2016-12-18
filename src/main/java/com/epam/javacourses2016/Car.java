package com.epam.javacourses2016;

/**
 * Created by kodoo on 13.11.16.
 */
public class Car implements Comparable<Car> {

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

    @Override
    public int compareTo(Car o) {
        return o.getSpeed() - speed;
    }
}
