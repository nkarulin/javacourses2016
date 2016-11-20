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
        long count = 0;

        if (car1.getSpeed() <= car2.getSpeed()) {
            return count;
        }

        double firstLapTime = (double) (lengthLap - car1.getStartPosition()) / car1.getSpeed();
        double otherLapsTime = (double) (lengthLap * (numberOfLap - 1) / car1.getSpeed());
        double time = firstLapTime + otherLapsTime;

        double lengthCar2 = time * car2.getSpeed() + car2.getStartPosition();
        long lapsCar2 = (long) (lengthCar2 / lengthLap);

        count = lapsCar2;
        if (car1.getStartPosition() < car2.getStartPosition()) {
            count++;
        }

        return count;
    }
}
