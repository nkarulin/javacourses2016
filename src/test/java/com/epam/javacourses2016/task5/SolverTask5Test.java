package com.epam.javacourses2016.task5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class SolverTask5Test {

    @Test(enabled = true, dataProvider = "measurements")
    public void testCalcResistance(double[][] measurements, double result) throws Exception {
        SolverTask5 solver = new SolverTask5();
        List<Measurement> listMeasures = getMeasurements(measurements);
        Assert.assertEquals(solver.calcResistance(listMeasures), result);
    }

    @Test(enabled = true, dataProvider = "numbers")
    public void testCalcResistance_fromKA(List<Measurement> list,double res) throws Exception {
        SolverTask5 solverTask5 = new SolverTask5();
        Assert.assertEquals(solverTask5.calcResistance(list), res);
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

        List<Measurement> list3 = new ArrayList<>();
        list3.add(new Measurement(0,5.3));
        list3.add(new Measurement(0,6.3));
        list3.add(new Measurement(0,4.8));
        list3.add(new Measurement(0,3.8));
        list3.add(new Measurement(0,3.3));

        return new Object[][] {
                {list1, 0.165},
                {list2, -0.65},
                {new ArrayList<Measurement>(),0.0}, // если массив пуст, то пуская возвращает 0.0
                {list3,0.0}, // Если измерения проводились вокруг одной точки (либо сильно зашумлены), то пуская вернет 0.0, проверка деления на нуль
        };
    }
    public List<Measurement> getMeasurements(double[][] measurements) {
        List<Measurement> list = new ArrayList<>();

        for (double[] measure : measurements) {
            list.add(new Measurement(measure[0], measure[1]));
        }

        return list;
    }

    @DataProvider(name = "measurements")
    public Object[][] measurements() {
        return new Object[][]{
                {new double[][]{{1, 5}, {2, 10}, {3, 15}, {4, 20}}, 5}
        };
    }
}