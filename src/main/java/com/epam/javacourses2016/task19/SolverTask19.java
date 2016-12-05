package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.*;

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
    int getNumberOvertaking(Set<Car> cars, long lengthLap, int numberLaps) {
        //TODO
        long length = numberLaps * lengthLap;
        ArrayList<Car> sortedByPosition = new ArrayList<>(cars);
        int farAhead = 0;
        sortedByPosition.sort(Comparator.comparingInt(Car::getCurrentPosition));
        for (Car car : sortedByPosition) {
            car.setFarAhead(farAhead);
            farAhead++;
        }

        boolean endOfRace = false;
        while (!endOfRace) {
            endOfRace = true;
            for (Car car : sortedByPosition) {
                if (car.getCurrentPosition() + car.getSpeed() <= length) {
                    car.setCurrentPosition(car.getCurrentPosition() + car.getSpeed());
                    endOfRace = false;
                } else
                    car.setCurrentPosition((int)length);
            }
            sortedByPosition.sort(Comparator.comparingInt(Car::getCurrentPosition));
        }
        int count = 0;
        farAhead = 0;
        for (Car car : sortedByPosition) {
            if (farAhead > car.getFarAhead()) {
                count = count + (farAhead - car.getFarAhead());
            }
            farAhead++;
        }
        return count;
    }
}
