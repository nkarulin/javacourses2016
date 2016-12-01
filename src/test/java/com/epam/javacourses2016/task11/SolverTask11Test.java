package com.epam.javacourses2016.task11;

import com.epam.javacourses2016.task8.SolverTask8;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class SolverTask11Test {
    @Test(enabled = true, dataProvider = "names")
    public void testEmulate(String names, int result) throws Exception {
        SolverTask11 solver = new SolverTask11();
        ArrayList<String> people = new ArrayList<>();
        String[] words = names.split("\\s");
        for (String s : words) {
            people.add(s);
        }
        String res=people.get(result);
        Assert.assertEquals(solver.emulate(people), res);
    }

    @Test
    public void testEmulate1(String names, int result) throws Exception {
        SolverTask11 solver = new SolverTask11();
        LinkedList<String> people = new LinkedList<>();
        String[] words = names.split("\\s");
        int i=0;
        String res="";
        for (String s : words) {
            if (i==result){
                res=s;
            }
            people.add(s);
        }
        Assert.assertEquals(solver.emulate(people), res);
    }

    @DataProvider(name = "names")
    public Object[][] getNames() {
        return new Object[][]{
                {"Vasya Petya Grisha Sasha Olya", 1},
        };
    }
}