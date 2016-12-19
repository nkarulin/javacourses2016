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
        final int[] overtakes = {0};
        HashMap<Car, Integer> carDistance = new HashMap<>();
        Car slowestCar = cars.stream().peek((c) -> {
            carDistance.put(c, c.getStartPosition() - c.getSpeed());
        }).min((c1, c2) -> Integer.compare(c1.getSpeed(), c2.getSpeed())).get();
        int t = -1;
        while (t * slowestCar.getSpeed() + slowestCar.getStartPosition() <= lengthLap * numberLaps) {
            t++;
            carDistance.keySet().stream().forEach((c1) -> {
                carDistance.put(c1, carDistance.get(c1) + c1.getSpeed());
                if (carDistance.get(c1) < lengthLap * numberLaps) {
                    carDistance.keySet().stream().forEach((c2) -> {
                        if (c1.getSpeed() > c2.getSpeed() && carDistance.get(c1)%lengthLap >= carDistance.get(c2) % lengthLap && carDistance.get(c1)%lengthLap - c1.getSpeed() < carDistance.get(c2) % lengthLap) overtakes[0]++;
                    });
                }
            });
        }
        return overtakes[0];
    }
}
