package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;
import com.sun.rowset.CachedRowSetImpl;

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
        int count = 0;
        for (Car firstCar : cars) {
            for (Car secondCar : cars) {
                count += getOvertake(firstCar, secondCar, lengthLap, numberLaps);
            }
        }
        return count;
    }

    private int getOvertake(Car firstCar, Car secondCar, long lengthLap, int numberLaps) {
        int count = 0;
        if (firstCar.getSpeed() <= secondCar.getSpeed()) {
            return count;
        }

        double lengthFirstCar = lengthLap * numberLaps - firstCar.getStartPosition();
        double timeFirstCar = lengthFirstCar / firstCar.getSpeed();
        double lapsFirstCar = lengthFirstCar / lengthLap;
        double lengthSecondCar = timeFirstCar * secondCar.getSpeed() + secondCar.getStartPosition();
        double lapsSecondCar = lengthSecondCar / lengthLap;

        count = (int) (lapsSecondCar / (lapsFirstCar / lapsSecondCar));
        if (firstCar.getStartPosition() < secondCar.getStartPosition()) {
            double timeBeforeOvertake = (secondCar.getStartPosition()-firstCar.getStartPosition()) / (firstCar.getSpeed() - secondCar.getSpeed());
            if (timeBeforeOvertake <= timeFirstCar) {
                count++;
            }
        }
        return count;
    }


}
