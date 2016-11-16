package com.epam.javacourses2016.task6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.testng.Assert.*;

public class SolverTask6Test {

    @Test(dataProvider = "polynomials")
    public void testAddPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second,
                                   HashMap<Integer, Integer> result) throws Exception {

        SolverTask6 solver = new SolverTask6();
        Assert.assertEquals(solver.addPolynomials(first,second), result);
    }

    @DataProvider(name = "polynomials")
    public Object[][] polynomials() {
        return new Object[][]{
                {
                        new HashMap<Integer, Integer>() {{
                            put(1, 2);
                            put(2, 3);
                            put(3, 3);
                            put(4, 5);
                        }},
                        new HashMap<Integer, Integer>() {{
                            put(1, 4);
                            put(2, 5);
                            put(3, 6);
                            put(4, 1);
                        }},
                        new HashMap<Integer, Integer>() {{
                            put(1, 6);
                            put(2, 8);
                            put(3, 9);
                            put(4, 6);
                        }}
                },
                {
                        new HashMap<Integer, Integer>() {{
                            put(1, 2);
                            put(2, 3);
                            put(3, 3);
                            put(4, 5);
                        }},
                        new HashMap<Integer, Integer>() {{
                            put(5, 4);
                            put(6, 5);
                            put(7, 6);
                            put(8, 1);
                        }},
                        new HashMap<Integer, Integer>() {{
                            put(1, 2);
                            put(2, 3);
                            put(3, 3);
                            put(4, 5);
                            put(5, 4);
                            put(6, 5);
                            put(7, 6);
                            put(8, 1);
                        }}
                },
                {

                        new HashMap<Integer, Integer>() {{
                            put(1, 4);
                            put(2, 5);
                            put(3, 6);
                            put(4, 1);
                            put(5, 5);
                        }},
                        new HashMap<Integer, Integer>() {{
                            put(2, 3);
                            put(3, 3);
                            put(4, 5);
                        }},
                        new HashMap<Integer, Integer>() {{
                            put(1, 4);
                            put(2, 8);
                            put(3, 9);
                            put(4, 6);
                            put(5, 5);
                        }}
                }
        };
    }

}