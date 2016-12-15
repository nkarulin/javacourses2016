package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;

import java.util.ArrayList;
import java.util.HashMap;
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
        //TODO
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for (Car car : cars) {
            car.setDistance(car.getSpeed()*numberLaps+car.getStartPosition());
            car.setLaps((int) (car.getDistance()/lengthLap));
            arr.add(car.getLaps());
        }

        int overlaps=0;
        if ((arr.get(0)==0)||(arr.get(1)==0)){
            overlaps=0;
            return overlaps;
        }
        if (arr.get(0)>arr.get(1)){
            overlaps=(int)arr.get(0)/arr.get(1);
        }
        else{
            overlaps=(int)arr.get(1)/arr.get(0);
        }

        return overlaps;
    }
}
