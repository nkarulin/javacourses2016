package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.Set;

/**
 * На кольцевой гоночной трассе стоит N автомобилей.
 * Для каждого из них известны начальное положение и скорость.
 * Определить, сколько произойдет обгонов за указанное количество кругов.
 */
public class SolverTask19 {

    /**
     * @param cars       Расположенные на трассе машины.
     * @param lengthLap  Длина трассы.
     * @param numberLaps Количество кругов.
     * @return Количество осуществленных обгонов.
     */
    int getNumberOvertaking(Set<Car> cars, long lengthLap, long numberLaps) {
        int count = 0;
        for (Car car1 : cars) {
            for (Car car2 : cars) {
                count += getOvertake(car1, car2, lengthLap, numberLaps);
            }
        }

        return count;
    }

    private long getOvertake(Car car1, Car car2, long lengthLap, long numberOfLap) {

        if (car1.getSpeed() <= car2.getSpeed()) {
            return 0;
        }

        double firstLapTime = (double) (lengthLap - car1.getStartPosition()) / car1.getSpeed();
        double otherLapsTime = (double) (lengthLap * (numberOfLap - 1)) / car1.getSpeed();
        double globalTime = firstLapTime + otherLapsTime;

        //It's car position after globalTime.
        //First car will be at the end of route(because it's hit finish line) - lapLength*laps.
        //Second car will be at the time*speed + startPosition.

        double car2Position = globalTime * car2.getSpeed() + car2.getStartPosition();
        double distanceLeft = lengthLap * numberOfLap - car2Position;

        double lapsOvertake = distanceLeft / lengthLap;

        //This could happen if first car start far behind
        //And second car have speed enough to end round before first one can do overtake
        if (lapsOvertake <= 0) {
            lapsOvertake = 0;
        } else {
            if (car1.getStartPosition() < car2.getStartPosition()) {
                lapsOvertake++;
            }
        }

        //Round laps
        return (int) lapsOvertake;
    }
}
