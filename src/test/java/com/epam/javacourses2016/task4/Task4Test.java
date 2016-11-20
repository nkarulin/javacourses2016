package com.epam.javacourses2016.task4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;


public class Task4Test {

    @Test(enabled = true, dataProvider = "intesection")
    public void testIntersection(Integer[] first, Integer[] second, Integer[] result) throws Exception {
        SolverTask4 task4 = new SolverTask4();
        Set<Integer> firstSet = convertToSet(first);
        Set<Integer> secondSet = convertToSet(second);
        Set<Integer> resultSet = convertToSet(result);
        Assert.assertEquals(task4.intersection(firstSet, secondSet), resultSet);

    }

    @Test(enabled = true, dataProvider = "union")
    public void testUnion(Integer[] first, Integer[] second, Integer[] result) throws Exception {
        SolverTask4 task4 = new SolverTask4();
        Set<Integer> firstSet = convertToSet(first);
        Set<Integer> secondSet = convertToSet(second);
        Set<Integer> resultSet = convertToSet(result);
        Assert.assertEquals(task4.union(firstSet, secondSet), resultSet);
    }


    public Set<Integer> convertToSet(Integer[] array) {
        return new HashSet<>(Arrays.asList(array));
    }

    @DataProvider(name = "intesection")
    private Object[][] intesection() {
        return new Object[][]{
                {new Integer[]{1, 5, 10},new Integer[]{2, 4, 10},new Integer[]{10}},
                {new Integer[]{2, 1},new Integer[]{3, 5, 2, 1},new Integer[]{2,1}}
        };
    }

    @DataProvider(name = "union")
    private Object[][] union() {
        return new Object[][]{
                {new Integer[]{1, 2, 5, 10},new Integer[]{2, 4, 10},new Integer[]{1,2,4,5,10}},
                {new Integer[]{1, 1},new Integer[]{1, 1},new Integer[]{1,1}}
        };
    }
}