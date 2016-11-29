package com.epam.javacourses2016.task5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class SolverTask5Test {
    @Test(enabled = true, dataProvider = "numbers")
    public void testCalcResistance_fromKA(List<Measurement> list,double res) throws Exception {
        SolverTask5 solverTask5 = new SolverTask5();
        Assert.assertEquals(solverTask5.calcResistance(list),res);
    }

    @DataProvider(name = "numbers")
    private Object[][] numbers() {
        List<Measurement> list1 = new ArrayList<>();
        list1.add(new Measurement(0, 2.1));
        list1.add(new Measurement(1, 2.4));
        list1.add(new Measurement(2, 2.6));
        list1.add(new Measurement(4, 2.8));
        list1.add(new Measurement(5, 3.0));

        List<Measurement> list2 = new ArrayList<>();
        list2.add(new Measurement(1,5.3));
        list2.add(new Measurement(2,6.3));
        list2.add(new Measurement(3,4.8));
        list2.add(new Measurement(4,3.8));
        list2.add(new Measurement(5,3.3));

        return new Object[][] {
                {list1, 0.165},
                {list2, -0.65}
        };
    }
}