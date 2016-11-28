package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class SolverTask19Test {

    @Test(enabled = false, dataProvider = "cars")
    public void testGetNumberOvertaking(long lengthLap, int numberLaps, int overtake, int[][] cars) throws Exception {
        SolverTask19 solver = new SolverTask19();
        Set<Car> carSet = createCars(cars);
        Assert.assertEquals(solver.getNumberOvertaking(carSet, lengthLap, numberLaps), overtake);
    }

    public static Set<Car> createCars(int[][] carArray) {
        Set<Car> cars = new HashSet<>();

        for (int[] car : carArray) {
            cars.add(new Car(car[0], car[1]));
        }

        return cars;
    }

    @DataProvider(name = "cars")
    private Object[][] cars() {
        //lap length, number of laps, overtakeCount(result), array of cars(position, speed)
        return new Object[][]{
                {100, 1, 1, new int[][]{{1, 50}, {2, 25}}},
                {100, 1, 0, new int[][]{{1, 25}, {2, 25}}},
                {100, 1, 0, new int[][]{{1, 25}, {2, 50}}},
                {100, 1, 0, new int[][]{{1, 35}, {90, 25}}},
                {100, 10, 3, new int[][]{{1, 50}, {2, 35}}},
                {100, 10, 3, new int[][]{{1, 35}, {2, 50}}},
        };
    }
}