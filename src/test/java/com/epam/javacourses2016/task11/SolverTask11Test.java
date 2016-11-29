package com.epam.javacourses2016.task11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class SolverTask11Test {

    @Test(enabled = false, dataProvider = "peoples")
    public void testEmulate(String[] peoples, String survived) throws Exception {
        ArrayList<String> array = new ArrayList<>();

        for (String someone : peoples) {
            array.add(someone);
        }

        SolverTask11 solver = new SolverTask11();
        Assert.assertEquals(solver.emulate(array), survived);
    }

    @Test(enabled = false, dataProvider = "peoples")
    public void testEmulate1(String[] peoples, String survived) throws Exception {
        LinkedList<String> array = new LinkedList<>();

        for (String someone : peoples) {
            array.add(someone);
        }

        SolverTask11 solver = new SolverTask11();
        Assert.assertEquals(solver.emulate(array), survived);
    }

    @DataProvider(name = "peoples")
    public Object[][] peoples() {
        return new Object[][]{
                {new String[]{"Vasya", "Petya", "Dima"}, "Dima"},
                {new String[]{"Vasya", "Petya", "Dima", "Alex"}, "Vasya"}
        };
    }
}