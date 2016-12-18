package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.Iterator;
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
    int getNumberOvertaking(Set<Car> cars, long lengthLap, int numberLaps) {

        int count = 0;
        int iteration = 0;

        while (cars.size() > 0) {
            for (Car currentCar : cars) {
                count += move(currentCar, cars, lengthLap, iteration);
            }
            removeFinishedCars(cars, lengthLap, numberLaps, iteration);
            iteration++;
        }

        return count;

    }

    private int move(Car currentCar, Set<Car> cars, long lengthLap, int iteration) {
        int count = 0;
        for (Car anotherCar : cars) {
            if (currentCar.equals(anotherCar) || currentCar.getSpeed() < anotherCar.getSpeed()) continue;

            int car1 = iteration * currentCar.getSpeed() + currentCar.getStartPosition();

            int car2 = iteration * anotherCar.getSpeed() + anotherCar.getStartPosition();


            if ((car1 % lengthLap < car2 % lengthLap) &&
                    (currentCar.getSpeed() >= (car2 % lengthLap - car1 % lengthLap + anotherCar.getSpeed())))
                count++;

        }
        return count;
    }

    private void removeFinishedCars(Set<Car> cars, long lengthLap, int numberLaps, int iteration) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            int currentPosition = car.getSpeed() * (iteration + 1) + car.getStartPosition();
            long finish = lengthLap * numberLaps;
            if (currentPosition >= finish) {
                iterator.remove();
            }
        }
    }
}
