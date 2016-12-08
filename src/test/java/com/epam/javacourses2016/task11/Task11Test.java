package com.epam.javacourses2016.task11;

import com.epam.javacourses2016.task1.SolverTask1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class Task11Test {
    private List<String> createList(int length) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            list.add(String.valueOf(i + 1));
        }
        return list;
    }
    @Test(enabled = true, dataProvider = "arraylists")
    public void testEmulate(int listLength, int result) throws Exception {
        SolverTask11 solver = new SolverTask11();
        String name = solver.emulate(new ArrayList<String>(createList(listLength)));
        Assert.assertEquals(name, String.valueOf(result));
    }

    @Test(enabled = false, dataProvider = "arraylists")
    public void testBoth(int listLength, int result) {
        SolverTask11 solverTask11 = new SolverTask11();
        List<String> list = createList(listLength);
        String first = solverTask11.emulate(new ArrayList<String>(list));
        String second = solverTask11.emulate(new LinkedList<String>(list));
        Assert.assertEquals(first, second);
    }
    @Test(enabled = false, dataProvider = "arraylists")
    public void testEmulate1(int listLength, int result) throws Exception {
        SolverTask11 solver = new SolverTask11();
        String name = solver.emulate(new LinkedList<String>(createList(listLength)));
        Assert.assertEquals(name, String.valueOf(result));
    }

    @DataProvider(name = "arraylists")
    public Object[][] arrayLists() {
        return new Object[][]{
                {
                        50, 36
                },
                {
                        20, 8
                },
                {
                        13,10
                },
                {
                        7, 6
                },
                {
                        8, 8
                },
                {
                        4,4
                },
                {
                        3,2
                },
                {
                        1,1
                },

        };
    }

}