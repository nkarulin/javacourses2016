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
        ArrayList<Car> sortedByPosition = new ArrayList<>(cars);
        sortedByPosition.sort(Comparator.comparingLong(Car::getCurrentPosition));
        int overtakes = 0;
        while (!endOfRace(sortedByPosition, numberLaps)) {
            int farAhead = 0;
            for (Car car : sortedByPosition) {
                car.setFarAhead(farAhead++);
                currentPositionAndLaps(car, lengthLap);
            }
            overtakes += checkOvertakes(sortedByPosition);
            sortedByPosition = setCurrentPositionOnTheLap(sortedByPosition, lengthLap, numberLaps);
            sortedByPosition.sort(Comparator.comparingLong(Car::getCurrentPosition));
        }
        return overtakes;
    }

    private boolean endOfRace(ArrayList<Car> cars, long numberLaps) {
        for (Car car : cars) {
            if (car.getFinishedLaps() <= numberLaps) {
                return false;
            }
        }
        return true;
    }

    private void currentPositionAndLaps(Car car, long lengthLap) {
        if (car.getCurrentPosition() + car.getSpeed() <= lengthLap) {
            car.setCurrentPosition(car.getCurrentPosition() + car.getSpeed());
        } else {
            car.setCurrentPosition(car.getCurrentPosition() + car.getSpeed());
            car.setFinishedLaps(car.getFinishedLaps() + 1);
        }
    }

    private int checkOvertakes(ArrayList<Car> cars) {
        cars.sort(Comparator.comparingLong(Car::getCurrentPosition));
        int count = 0;
        int farAhead = 0;
        for (Car car : cars) {
            if (farAhead > car.getFarAhead()) {
                count = count + (farAhead - car.getFarAhead());
            }
            farAhead++;
        }
        return count;
    }

    private ArrayList<Car> setCurrentPositionOnTheLap(ArrayList<Car> cars, long lengthLap, int numberLaps) {
        ArrayList<Car> sortedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getFinishedLaps() < numberLaps) {
                if (car.getCurrentPosition() >= lengthLap) {
                    car.setCurrentPosition(car.getCurrentPosition() - lengthLap);
                }
                sortedCars.add(car);
            }
        }
        sortedCars.sort(Comparator.comparingLong(Car ::getCurrentPosition));
        return sortedCars;
    }
}
