package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

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
        List<Integer> arr = new ArrayList<>();

        List<Car> carsList = new LinkedList<>();
        carsList.addAll(cars);

        Collections.sort(carsList, (a, b) -> {
            Integer speedA=a.getSpeed();
            Integer speedB=b.getSpeed();
            return speedA.compareTo(speedB);
        });

        Collections.reverse(carsList); //first car with max speed
        int maxSpeed=carsList.get(0).getSpeed();
        int time= (int) (lengthLap*numberLaps/maxSpeed);

        for (Car car : carsList) {
            car.setDistance(car.getSpeed()*time+car.getStartPosition());
            arr.add(car.getDistance());
        }

        System.out.println("arr of distance:"+arr.toString());
        int overlaps=0;

        if ((arr.get(0)==0)||(arr.get(1)==0)){
            overlaps=0;
            return overlaps;
        }

        if (arr.get(0)>arr.get(1)){
            overlaps= (int) ((arr.get(0)-arr.get(1)) /lengthLap);
        }

        if ((carsList.get(0).getStartPosition()<carsList.get(1).getStartPosition())&&
                (carsList.get(0).getSpeed()>carsList.get(1).getSpeed())&&
                (carsList.get(0).getDistance()>carsList.get(1).getDistance())){
            overlaps++;
        }

        return overlaps;
    }
}
