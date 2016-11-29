package com.epam.javacourses2016.task7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.*;

public class SolverTask7Test {
    @Test(enabled = false, dataProvider = "polynoms")
    public void testMultiplyPolynomials(List<Integer> polynom1,List<Integer> polynom2) throws Exception {
        //TODO
    }

    @DataProvider(name = "polynoms")
    public Object[][] polynoms() {
        List<Integer> map1 = new ArrayList<>();
        map1.add(0);
        map1.add(1);
        map1.add(2);
        List<Integer> map2 = new ArrayList<>();
        map2.add(2);
        map2.add(3);
        map2.add(4);
        List<Integer> res = new ArrayList<>();
        return new Object[][] {
                {map1,map2,res},
        };
    }

}