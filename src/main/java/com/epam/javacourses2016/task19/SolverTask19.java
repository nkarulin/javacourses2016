package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<Car> carList  = new ArrayList<>();
        carList.addAll(cars);
        Collections.sort(carList);
        Car[] carArray = new Car[carList.size()];
        carList.toArray(carArray);
        int result = 0;
        for(int i = 0; i < carArray.length-1; i++) {
            for(int j = i+1; j < carArray.length; j++) {
                double maintime = (double) (lengthLap - carArray[i].getStartPosition()) / carArray[i].getSpeed()
                        + (double) (lengthLap * (numberLaps - 1)) / carArray[i].getSpeed();
                double endPositionCar2 = maintime * carArray[j].getSpeed() + carArray[j].getStartPosition();
                double difference = lengthLap * numberLaps - endPositionCar2;

                double overtakeLaps = difference / lengthLap;
                if (overtakeLaps > 0) {
                    if (carArray[i].getStartPosition() < carArray[j].getStartPosition()) {
                        overtakeLaps++;
                    }
                    result += (int)overtakeLaps;
                }
            }
        }
        return result;
    }

}
