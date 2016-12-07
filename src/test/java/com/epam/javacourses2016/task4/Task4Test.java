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

    @Test(enabled = true, dataProvider = "nums")
    public void testIntersection_fromKA(Set<Integer> set1, Set<Integer> set2,Set<Integer> res1, Set<Integer> res2) throws Exception {
        SolverTask4 solverTask4 = new SolverTask4();
        Set<Integer> result = solverTask4.intersection(set1,set2);
        Assert.assertEquals(result,res2);
    }

    @Test(enabled = true, dataProvider = "nums")
    public void testUnion_fromKA(Set<Integer> set1, Set<Integer> set2,Set<Integer> res1, Set<Integer> res2) throws Exception {
        SolverTask4 solverTask4 = new SolverTask4();
        Set<Integer> result = solverTask4.union(set1,set2);
        Assert.assertEquals(result,res1);
    }

    @DataProvider(name = "nums")
    private Object[][] nums() {
        Set<Integer> set1_1 = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4}));
        Set<Integer> set2_1 = new HashSet<>(Arrays.asList(new Integer[]{3,4,5,6}));
        Set<Integer> res1_1 = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4,5,6}));
        Set<Integer> res2_1 = new HashSet<>(Arrays.asList(new Integer[]{3,4}));
        Set<Integer> set1_2 = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4}));
        Set<Integer> set2_2 = new HashSet<>(Arrays.asList(new Integer[]{5,6,7,8}));
        Set<Integer> res1_2 = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8}));
        Set<Integer> res2_2 = new HashSet<>();
        return new Object[][] {
                {set1_1,set2_1,res1_1,res2_1},
                {set1_2,set2_2,res1_2,res2_2}
        };
    }
}