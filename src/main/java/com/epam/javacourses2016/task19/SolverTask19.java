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
        int result = 0;
        while (!cars.isEmpty()) {

            Iterator<Car> iterator = cars.iterator();
            Car car1 = iterator.next();
            iterator.remove();
            while (iterator.hasNext()) {
                Car car2 = iterator.next();
                double time1 = lengthLap * numberLaps / car1.getSpeed();
                double time2 = lengthLap * numberLaps / car2.getSpeed();
                if (time1 < time2) {
                    int leftLap = (int) (numberLaps - (double) car2.getSpeed() * time1 / lengthLap);
                    result += car1.getStartPosition() < car2.getStartPosition() ? leftLap + 1 : leftLap;
                } else {
                    int leftLap = (int) (numberLaps - (double) car1.getSpeed() * time2 / lengthLap);
                    result += car2.getStartPosition() < car1.getStartPosition() ? leftLap + 1 : leftLap;
                }
            }
        }
        return result;
    }
}
