package com.epam.javacourses2016.task7;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SolverTask7Test {

    @Test(enabled = true, dataProvider = "polynomials2")
    public void testMultiplyPolynomials(int[] first, int[] second, int[] result) throws Exception {

        SolverTask7 solver = new SolverTask7();
        List<Integer> firstList = convertToList(first);
        List<Integer> secondList = convertToList(second);
        List<Integer> resultList = convertToList(result);

        Assert.assertEquals(solver.multiplyPolynomials(firstList, secondList), resultList);
    }

    public static List<Integer> convertToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int number : array) {
            list.add(number);
        }
        return list;
    }

    @DataProvider(name = "polynomials2")
    public Object[][] polynomials2() {
        return new Object[][]{
                {
                        new int[]{2, 1},
                        new int[]{2, 1},
                        new int[]{4, 4, 1}
                },
                {
                        new int[]{2, 0, 0, 3},
                        new int[]{4, 0, 1},
                        new int[]{8, 0, 2, 12, 0, 3}
                }

        };
    }
}