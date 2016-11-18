package com.epam.javacourses2016.task7;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.*;

public class SolverTask7Test {
    @Test(dataProvider = "polynomials2")
    public void testMultiplyPolynomials(List<Integer> first, List<Integer> second,
                                        List<Integer> result) throws Exception {

        SolverTask7 solver = new SolverTask7();
        Assert.assertEquals(solver.multiplyPolynomials(first, second), result);
    }

    @DataProvider(name = "polynomials2")
    public Object[][] polynomials() {
        return new Object[][]{
                {
                        new ArrayList<Integer>() {{
                            add(0, 2);
                            add(1, 1);
                        }},
                        new ArrayList<Integer>() {{
                            add(0, 2);
                            add(1, 1);
                        }},
                        new ArrayList<Integer>() {{
                            add(0, 4);
                            add(1, 4);
                            add(2, 1);
                        }}
                },
                {
                        new ArrayList<Integer>() {{
                            add(0, 2);
                            add(1, 0);
                            add(2, 0);
                            add(3, 3);
                        }},
                        new ArrayList<Integer>() {{
                            add(0, 4);
                            add(1, 0);
                            add(2, 1);
                        }},
                        new ArrayList<Integer>() {{
                            add(0, 8);
                            add(1, 0);
                            add(2, 2);
                            add(3, 12);
                            add(4, 0);
                            add(5, 3);
                        }}
                }
        };
    }
}