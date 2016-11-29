package com.epam.javacourses2016.task6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

public class SolverTask6Test {

    @Test(enabled = true, dataProvider = "polynoms")
    public void testAddPolynomials(HashMap<Integer,Integer> map1, HashMap<Integer,Integer> map2, HashMap<Integer,Integer> res) throws Exception {
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

}