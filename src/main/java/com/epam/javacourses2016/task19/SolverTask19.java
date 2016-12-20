package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.HashMap;
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
        int overtakes = 0;
        HashMap<Car, Integer> carsDistances = new HashMap<>();
        Car slowestCar = cars.stream().peek((c) -> carsDistances.put(c, c.getStartPosition())).min((c1, c2) -> {
            return Integer.compare(c1.getSpeed(), c2.getSpeed());
        }).get();
        while (carsDistances.get(slowestCar) < lengthLap * numberLaps){
            for (Car car1: carsDistances.keySet()) {
                if (carsDistances.get(car1) < lengthLap * numberLaps) {
                    for (Car car2 : carsDistances.keySet()) {
                        if (carsDistances.get(car2) < lengthLap * numberLaps) {
                            if (car1.getSpeed() > car2.getSpeed() && Math.abs(carsDistances.get(car1) % lengthLap - carsDistances.get(car2) % lengthLap) <= car1.getSpeed() - car2.getSpeed() && carsDistances.get(car1) % lengthLap < carsDistances.get(car2) % lengthLap) {
                                overtakes++;
                            }
                        }
                    }
                }
            }
            carsDistances.keySet().stream().forEach((c) -> {
                carsDistances.put(c, carsDistances.get(c) + c.getSpeed());
            });

        }
        return overtakes;
    }
}
