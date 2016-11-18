package com.epam.javacourses2016.task19;

import com.epam.javacourses2016.Car;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask19Test {

    @Test(dataProvider = "cars")
    public void testGetNumberOvertaking(long lengthLap, long numberLaps, int overtake, Set<Car> cars) throws Exception {
        SolverTask19 solver = new SolverTask19();
        Assert.assertEquals(solver.getNumberOvertaking(cars,lengthLap,numberLaps), overtake);
    }

    @DataProvider(name = "cars")
    private Object[][] cars() {
        return new Object[][]{
                {100, 1, 2, new HashSet<Car>() {
                    {
                        add(new Car(1, 50));
                        add(new Car(2, 25));
                        add(new Car(3, 25));
                    }
                }},
                {100, 5, 6, new HashSet<Car>() {
                    {
                        add(new Car(1, 50));
                        add(new Car(2, 25));
                        add(new Car(3, 25));
                    }
                }},
                {100, 1, 0,new HashSet<Car>() {
                    {
                        add(new Car(1, 25));
                        add(new Car(2, 25));
                        add(new Car(3, 50));
                    }
                }},
                {100, 5, 4,new HashSet<Car>() {
                    {
                        add(new Car(1, 25));
                        add(new Car(2, 25));
                        add(new Car(3, 50));
                    }
                }},
        };
    }
}