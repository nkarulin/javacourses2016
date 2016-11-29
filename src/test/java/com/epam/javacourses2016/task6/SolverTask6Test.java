package com.epam.javacourses2016.task6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SolverTask6Test {

    @Test(enabled = true, dataProvider = "polynomials")
    public void testAddPolynomials(Integer[][] first, Integer[][] second, Integer[][] result) throws Exception {

        SolverTask6 solver = new SolverTask6();
        HashMap<Integer, Integer> firstMap = convertToMap(first);
        HashMap<Integer, Integer> secondMap = convertToMap(second);
        HashMap<Integer, Integer> resultMap = convertToMap(result);

        Assert.assertEquals(solver.addPolynomials(firstMap, secondMap), resultMap);
    }

    public static HashMap<Integer, Integer> convertToMap(Integer[][] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer[] row : array) {
            map.put(row[0], row[1]);
        }
        return map;
    }

    @DataProvider(name = "polynomials")
    public Object[][] polynomials() {
        return new Object[][]{
                {
                        new Integer[][]{{1, 2}, {2, 3}, {3, 3}, {4, 5}},
                        new Integer[][]{{1, 4}, {2, 5}, {3, 6}, {4, 1}},
                        new Integer[][]{{1, 6}, {2, 8}, {3, 9}, {4, 6}}
                },
                {
                        new Integer[][]{{1, 2}, {2, 3}, {3, 3}, {4, 5}},
                        new Integer[][]{{5, 4}, {6, 5}, {7, 6}, {8, 1}},
                        new Integer[][]{{1, 2}, {2, 3}, {3, 3}, {4, 5}, {5, 4}, {6, 5}, {7, 6}, {8, 1}}
                },
                {
                        new Integer[][]{{1, 4}, {2, 5}, {3, 6}, {4, 1}, {5, 5}},
                        new Integer[][]{{2, 3}, {3, 3}, {4, 5}},
                        new Integer[][]{{1, 4}, {2, 8}, {3, 9}, {4, 6}, {5, 5}}
                }
        };
    }
}