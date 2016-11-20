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
        // first sort by current position
        return 0;
    }

    class CompareCar implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return Integer.compare(o1.getStartPosition(), o2.getStartPosition());
        }
    }

}
