package com.epam.javacourses2016.task6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashMap;

import static org.testng.Assert.*;

public class SolverTask6Test {

    @Test(enabled = true, dataProvider = "polynomials")
    public void testAddPolynomials(Integer[][] first, Integer[][] second, Integer[][] result) throws Exception {

        SolverTask6 solver = new SolverTask6();
        HashMap<Integer, Integer> firstMap = convertToMap(first);
        HashMap<Integer, Integer> secondMap = convertToMap(second);
        HashMap<Integer, Integer> resultMap = convertToMap(result);

        Assert.assertEquals(solver.addPolynomials(firstMap, secondMap), resultMap);
    }

    @Test(enabled = true, dataProvider = "polynoms")
    public void testAddPolynomials_fromKA(HashMap<Integer,Integer> map1, HashMap<Integer,Integer> map2, HashMap<Integer,Integer> res) throws Exception {
        SolverTask6 solverTask6 = new SolverTask6();
        Assert.assertEquals(solverTask6.addPolynomials(map1,map2),res);
    }

    @DataProvider(name = "polynoms")
    public Object[][] polynoms() {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        map1.put(0,2);
        map1.put(1,4);
        map1.put(2,8);
        map1.put(3,10);
        map1.put(4,12);
        HashMap<Integer,Integer> map2 = new HashMap<>();
        map2.put(3,1);
        map2.put(4,2);
        map2.put(5,3);
        map2.put(6,4);
        map2.put(7,5);
        HashMap<Integer,Integer> res = new HashMap<>();
        res.put(0,2);
        res.put(1,4);
        res.put(2,8);
        res.put(3,11);
        res.put(4,14);
        res.put(5,3);
        res.put(6,4);
        res.put(7,5);
        return new Object[][] {
                {map1,map2,res},
        };
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