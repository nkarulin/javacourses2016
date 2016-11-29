package com.epam.javacourses2016.task4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;


public class Task4Test {
    @Test(enabled = true, dataProvider = "numbers")
    public void testIntersection(Set<Integer> set1, Set<Integer> set2,Set<Integer> res1, Set<Integer> res2) throws Exception {
        SolverTask4 solverTask4 = new SolverTask4();
        Set<Integer> result = solverTask4.intersection(set1,set2);
        Assert.assertEquals(result,res2);
    }

    @Test(enabled = true, dataProvider = "numbers")
    public void testUnion(Set<Integer> set1, Set<Integer> set2,Set<Integer> res1, Set<Integer> res2) throws Exception {
        SolverTask4 solverTask4 = new SolverTask4();
        Set<Integer> result = solverTask4.union(set1,set2);
        Assert.assertEquals(result,res1);
    }

    @DataProvider(name = "numbers")
    private Object[][] numbers() {
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
             //   {set2_1,set2_2,res2_1,res2_2}
        };
    }

}