package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class RaceItem {
    private Car car;
    private int laps;
    private double prevPosition;
    private double position;
    private double length;
    private boolean justCrossed;
    private int numberLaps;
    private boolean stopped;
    private int number;

    public RaceItem(Car car, int number, int numberLaps, double raceLength) {
        this.car = car;
        this.number = number;
        this.length = raceLength;
        this.prevPosition = car.getStartPosition();
        this.position = car.getStartPosition();
        this.stopped = false;
        this.numberLaps = numberLaps;
    }

    public boolean isStopped() {
        return stopped;
    }

    public int getLaps() {
        return this.laps;
    }

    public double getPosition() {
        return this.position;
    }
    public double getPrevPosition() {
        return prevPosition;
    }

    public Car getCar() {
        return this.car;
    }

    public boolean isJustCrossed() {
        return justCrossed;
    }
    public boolean overlaps(RaceItem item) {

        if (!item.isJustCrossed() && !this.isJustCrossed() || item.isJustCrossed() && this.isJustCrossed()) {
            return (((this.getPosition() > item.getPosition() || item.getPosition() > item.getPosition() )  /*|| nextFirst > nextSecond) */
                    && item.getPrevPosition() == this.prevPosition)
                    || (item.getPrevPosition() > this.getPrevPosition() && item.getPosition() < this.position)
                    || (item.getPrevPosition() < this.getPrevPosition() && item.getPosition() > this.position));
        }

        if (this.justCrossed && !item.isJustCrossed()) {
            return this.prevPosition <= item.getPrevPosition();
        }
        if (item.isJustCrossed() && !this.isJustCrossed()) {
            return item.getPrevPosition() <= this.prevPosition;
        }


            return false;

  //      return this.getLaps() > item.getLaps() ? this.position > item.getPosition()  :
    //            this.position > item.getPosition() && item.getPrevPosition() >= this.prevPosition;
               // || (item.getPrevPosition() > this.prevPosition && item.getPosition() < this.position)
               // || (item.getPrevPosition() < this.prevPosition && item.getPosition() > this.position));
    }

    public void move() {
        this.prevPosition = this.position;
        this.position += car.getSpeed();
        System.out.println(String.format("%d: prev: %.3f next: %.3f", this.number, this.prevPosition, this.position));
        if (laps == numberLaps)
            stopped = true;
        if (this.position >= length) {
            this.position  %= length;
            laps++;
            justCrossed = true;
        } else justCrossed = false;
    }

    public int getNumber() {
        return this.number;
    }
}
