package com.epam.javacourses2016.task7;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SolverTask7Test {
    @Test(enabled = true, dataProvider = "polynom")
    public void testMultiplyPolynomials(Integer[] first, Integer[] second, Integer[] result) throws Exception {
        SolverTask7 task7 = new SolverTask7();
        List<Integer> firstList= convertToList(first);
        List<Integer> secondList= convertToList(second);
        List<Integer> resultList= convertToList(result);
        Assert.assertEquals(task7.multiplyPolynomials(firstList,secondList),resultList);
    }

    public List<Integer> convertToList(Integer[] array) {
        return Arrays.asList(array);
    }
    @DataProvider(name = "polynom")
    private Object[][] polynom() {
        return new Object[][]{
                {new Integer[]{1, 5, 10},new Integer[]{1, 2, 4}, new Integer[]{1, 7, 24,40,40}},
                {new Integer[]{1, 2, 3},new Integer[]{0, 4, 1},new Integer[]{0, 4, 9, 14,3}}
        };
    }
}