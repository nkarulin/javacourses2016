package com.epam.javacourses2016.task4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task4Test {

    @Test(enabled = true, dataProvider = "params")
    public void testIntersection(Integer[] first, Integer[] second) throws Exception {
        SolverTask4 solver = new SolverTask4();

        Set<Integer> firstSet = new HashSet<>(Arrays.asList(first));
        Set<Integer> secondSet = new HashSet<>(Arrays.asList(second));

        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(firstSet);
        numbers.retainAll(secondSet);

        Assert.assertEquals(solver.intersection(firstSet, secondSet), numbers);
    }

    @Test(enabled = true, dataProvider = "params")
    public void testUnion(Integer[] first, Integer[] second) throws Exception {
        SolverTask4 solver = new SolverTask4();

        Set<Integer> firstSet = new HashSet<>(Arrays.asList(first));
        Set<Integer> secondSet = new HashSet<>(Arrays.asList(second));

        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(firstSet);
        numbers.addAll(secondSet);

        Assert.assertEquals(solver.union(firstSet, secondSet), numbers);
    }

    @DataProvider(name = "params")
    private Object[][] numbers() {
        return new Object[][]{
                {new Integer[]{1, 2, 3, 4, 5}, new Integer[]{4, 5, 6, 7, 8}},
                {new Integer[]{1, 2, 3, 4, 5}, new Integer[]{1, 2, 3, 4, 5}},
                {new Integer[]{1, 2, 3, 4, 5}, new Integer[]{6, 7, 8, 9, 10}},
        };
    }
}
