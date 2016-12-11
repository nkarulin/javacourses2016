package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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
    int getNumberOvertaking1(Set<Car> cars, long lengthLap, int numberLaps) {
        int count = 0;
        for (Car firstCar : cars) {
            for (Car secondCar : cars) {
                count += getOvertake(firstCar, secondCar, lengthLap, numberLaps);
            }
        }
        return count;
    }

    private int getOvertake(Car firstCar, Car secondCar, long lengthLap, int numberLaps) {

        double numberOfOvertakes = 0;
        if (firstCar.getSpeed() <= secondCar.getSpeed()) {
            return (int) numberOfOvertakes;
        }
        double lengthFirstCar = lengthLap * numberLaps - firstCar.getStartPosition();
        double timeFirstCar = lengthFirstCar / firstCar.getSpeed();

        double lengthSecondCar = timeFirstCar * secondCar.getSpeed() + secondCar.getStartPosition();
        double lapsSecondCar = lengthSecondCar / lengthLap;

        numberOfOvertakes = numberLaps - lapsSecondCar;

        if (firstCar.getStartPosition() < secondCar.getStartPosition()) {
            numberOfOvertakes++;
        }
        return (int) numberOfOvertakes;
    }

    /**
     * @param cars       Расположенные на трассе машины.
     * @param lengthLap  Длина трассы.
     * @param numberLaps Количество кругов.
     * @return Количество осуществленных обгонов.
     */
    int getNumberOvertaking(Set<Car> cars, long lengthLap, int numberLaps) {
        Set<Car> sortedCars = new TreeSet<>(new CarCompatator());
        sortedCars.addAll(cars);
        int numberOfOvertakes = 0;
        while (!raceComplete(sortedCars, numberLaps)) {
            int i = 0;
            int timeDelta = 1;
            for (Car car : sortedCars) {
                car.setActualPosition(i++);
                calculateDistanceAndLapsForCar(car, timeDelta, lengthLap);
            }
            numberOfOvertakes += calculateTheOvertakingOfCar(sortedCars);
            sortedCars = calculateDistanceIfCarFinishedLap(sortedCars, numberLaps, lengthLap);
        }
        return numberOfOvertakes;
    }


    private boolean raceComplete(Set<Car> cars, long numberLaps) {
        for (Car car : cars) {
            if (car.getNumberOfFinishedLaps() <= numberLaps) {
                return false;
            }
        }
        return true;
    }

    private void calculateDistanceAndLapsForCar(Car car, int timeDelta, long lengthLap) {
        int newDistance = timeDelta * car.getSpeed();
        if (car.getDistanceCovered() + newDistance <= lengthLap) {
            car.setDistanceCovered(car.getDistanceCovered() + newDistance);
        } else {
            car.setDistanceCovered(car.getDistanceCovered() + newDistance);
            car.setNumberOfFinishedLaps(car.getNumberOfFinishedLaps() + 1);
        }
    }

    private Set<Car> calculateDistanceIfCarFinishedLap(Set<Car> cars, int numberLaps, long lengthLap) {
        Set<Car> sortedCars = new TreeSet<>(new CarCompatator());
        for (Car car : cars) {
            if (car.getNumberOfFinishedLaps() < numberLaps) {
                if (car.getDistanceCovered() >= lengthLap) {
                    car.setDistanceCovered(car.getDistanceCovered() - lengthLap);
                }
                sortedCars.add(car);
            }
        }
        return sortedCars;
    }

    private int calculateTheOvertakingOfCar(Set<Car> cars) {
        Set<Car> sortedCars = new TreeSet<>(new CarCompatator());
        sortedCars.addAll(cars);
        int i = 0;
        int numberOfOvertakes = 0;
        for (Car car : sortedCars) {
            if (i > car.getActualPosition()) {
                numberOfOvertakes = numberOfOvertakes + (i - car.getActualPosition());
            }
            i++;
        }
        return numberOfOvertakes;
    }

    private class CarCompatator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return Long.compare(o1.getDistanceCovered(), o2.getDistanceCovered());
        }
    }
}