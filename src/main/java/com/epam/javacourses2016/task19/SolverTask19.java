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
    int getNumberOvertaking(Set<Car> cars, long lengthLap, int numberLaps) {
        int overtakesCount = 0;
        for (Car car1: cars) {
            for (Car car2 : cars) {
                int temp = getNumberOvertaking(car1, car2, lengthLap, numberLaps);
                overtakesCount += temp;
            }
        }
        return overtakesCount;
    }

    private int getNumberOvertaking(Car car1, Car car2, long lengthLap, int numberLaps) {

        if (car1.getSpeed() <= car2.getSpeed()) {
            return 0;
        }

        double car1ElapsedTime = (double) (lengthLap - car1.getStartPosition()) / car1.getSpeed() + ((lengthLap) / car1.getSpeed() )* (numberLaps - 1);
        double car2DistanceForCar1Time = car1ElapsedTime * car2.getSpeed() + car2.getStartPosition();
        double car2DistanceLeft = lengthLap * numberLaps - car2DistanceForCar1Time;
        double lapsOvertake = car2DistanceLeft / lengthLap;

        if (lapsOvertake <= 0) {
            lapsOvertake = 0;
        } else {
            if (car2.getStartPosition() > car1.getStartPosition()) {
                lapsOvertake++;
            }
        }

        return (int) lapsOvertake;
    }
}
