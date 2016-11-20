package com.epam.javacourses2016.task6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class SolverTask6Test {
    @Test(enabled = true, dataProvider = "polynom")
    public void testAddPolynomials(Integer[][] first, Integer[][] second,Integer[][] result) throws Exception {
        SolverTask6 task6 = new SolverTask6();
        HashMap<Integer, Integer> firstSet = convertToMap(first);
        HashMap<Integer, Integer> secondSet = convertToMap(second);
        HashMap<Integer, Integer> resultSet = convertToMap(result);
        Assert.assertEquals(task6.addPolynomials(firstSet,secondSet),resultSet);
    }

    public HashMap<Integer,Integer> convertToMap(Integer[][] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(array[0][i],array[1][i]);
        }
        return map;
    }

    @DataProvider(name = "polynom")
    private Object[][] polynom() {
        return new Object[][]{
                {new Integer[][]{{1, 5, 10},{2, 4, 5}},new Integer[][]{{1, 5, 10},{1, 2, 4}}, new Integer[][]{{1, 5, 10},{3, 6, 14}}},
                {new Integer[][]{{1, 2, 3},{4, 4, 4}},new Integer[][]{{1, 2, 4},{0, 4, 1}},new Integer[][]{{1, 2, 3, 4},{4, 8, 4, 1}}}
        };
    }

}