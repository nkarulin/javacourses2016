package com.epam.javacourses2016.task4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;


public class Task4Test {

    @Test(enabled = true, dataProvider = "intesection")
    public void testIntersection(Set<Integer> first, Set<Integer> second, Set<Integer> result) throws Exception {
        SolverTask4 task4 = new SolverTask4();
        Assert.assertEquals(task4.intersection(first, second), result);

    }

    @Test(enabled = true, dataProvider = "union")
    public void testUnion(Set<Integer> first, Set<Integer> second, Set<Integer> result) throws Exception {
        SolverTask4 task4 = new SolverTask4();
        Assert.assertEquals(task4.union(first, second), result);
    }

    @DataProvider(name = "intesection")
    private Object[][] poems() {
        return new Object[][]{
                {new HashSet<Integer>() {
                    {
                        add(1);
                        add(5);
                        add(10);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(2);
                        add(4);
                        add(10);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(10);
                    }
                }},
                {new HashSet<Integer>() {
                    {
                        add(12);
                        add(2);
                        add(10);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(2);
                        add(5);
                        add(12);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(2);
                        add(12);
                    }
                }},
        };
    }

    @DataProvider(name = "union")
    private Object[][] poems1() {
        return new Object[][]{
                {new HashSet<Integer>() {
                    {
                        add(1);
                        add(5);
                        add(10);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(2);
                        add(4);
                        add(10);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(1);
                        add(2);
                        add(4);
                        add(5);
                        add(10);
                    }
                }},
                {new HashSet<Integer>() {
                    {
                        add(12);
                        add(2);
                        add(10);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(2);
                        add(5);
                        add(12);
                    }
                }, new HashSet<Integer>() {
                    {
                        add(2);
                        add(5);
                        add(10);
                        add(12);
                    }
                }},
        };
    }
}