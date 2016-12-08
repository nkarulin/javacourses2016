package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vasya on 08.12.2016.
 */
public class Race {
    private Map<Car, Integer> race;
    private int numberLaps;
    private int lapLength;
    private int timeofend;

    private int countTimeofend(Set<Car> cars) {
        int minSpeed = cars.iterator().next().getSpeed();
        for (Car car : cars) {
            if (car.getSpeed() < minSpeed)
                minSpeed = car.getSpeed();
        }

        return numberLaps * lapLength / minSpeed;
    }

    public Race(Set<Car> cars, int numberLaps, int lapLength) {
        this.race = new HashMap<Car, Integer>(cars.size());
        int distance = numberLaps * lapLength;
        for (Car car : cars) {
            this.race.put(car, distance);
        }
        this.numberLaps = numberLaps;
        this.lapLength = lapLength;
        this.timeofend = countTimeofend(cars);
    }

    public int numberOvertaking() {
        int time = 0;
        int result = 0;
        while (time != this.timeofend) {
            time++;
            for (Map.Entry<Car, Integer> entry : race.entrySet()) {
                if (entry.getValue() <= 0) race.remove(entry.getKey());
                entry.setValue(entry.getValue() - entry.getKey().getSpeed());
            }


        }
        return result;
    }


}
