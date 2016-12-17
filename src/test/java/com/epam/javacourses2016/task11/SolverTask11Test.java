package com.epam.javacourses2016.task11;

import com.epam.javacourses2016.task8.SolverTask8;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

public class SolverTask11Test {
    @Test(enabled = true, dataProvider = "people")
    public void testEmulate(String[] arr, String result) throws Exception {
        SolverTask11 task11 = new SolverTask11();
        Assert.assertEquals(task11.emulate(convertToArrayList(arr)), result);
    }

    @Test(enabled = true, dataProvider = "people")
    public void testEmulate1(String[] arr, String result) throws Exception {
        SolverTask11 task11 = new SolverTask11();
        Assert.assertEquals(task11.emulate(convertToLinkedList(arr)), result);
    }

    public ArrayList<String> convertToArrayList(String[] arr) {

        return new ArrayList<String>(Arrays.asList(arr));
    }

    public LinkedList<String> convertToLinkedList(String[] arr) {

        return new LinkedList<String>(Arrays.asList(arr));
    }

    @DataProvider(name = "people")
    private Object[][] peoples() {
        return new Object[][]{
                {new String[]{"Vanya", "Nikita", "Pasha", "Alex", "Maxim", "Anton", "Petya", "Dima"}, "Dima"},
                {new String[]{"Anton", "Petya", "Dima", "Vanya", "Nikita"}, "Petya"}
        };
    }
}