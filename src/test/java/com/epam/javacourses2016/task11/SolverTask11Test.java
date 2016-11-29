package com.epam.javacourses2016.task11;

import com.epam.javacourses2016.task1.SolverTask1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class SolverTask11Test {
    @Test(enabled = true, dataProvider = "arraylists")
    public void testEmulate(ArrayList<String> list, String result) throws Exception {
        SolverTask11 solver = new SolverTask11();
        String name = solver.emulate(list);
        Assert.assertEquals(name, result);
    }

    @Test(enabled = true, dataProvider = "linkedlists")
    public void testEmulate1(LinkedList<String> list, String result) throws Exception {
       SolverTask11 solver = new SolverTask11();
       String name = solver.emulate(list);
        Assert.assertEquals(name, result);
    }

    @DataProvider(name = "arraylists")
    public Object[][] arrayLists() {
        return new Object[][]{
                {
                    new ArrayList<String>() {{
                        this.add("First");
                        this.add("Second");
                        this.add("Third");
                        this.add("Fourth");
                    }},
                    "Fourth"
                },
                {
                        new ArrayList<String>() {{
                            this.add("First");
                            this.add("Second");
                            this.add("Third");
                        }},
                        "Third"
                },
                {
                        new ArrayList<String>() {{
                            this.add("First");
                        }},
                        "First"
                },

        };
    }

    @DataProvider(name = "linkedlists")
    public Object[][] linkedLists() {
        return new Object[][]{
                {
                        new LinkedList() {{
                            this.add("First");
                            this.add("Second");
                            this.add("Third");
                            this.add("Fourth");
                        }},
                        "Fourth"
                },
                {
                        new LinkedList() {{
                            this.add("First");
                            this.add("Second");
                            this.add("Third");
                        }},
                        "Third"
                },
                {
                        new LinkedList() {{
                            this.add("First");
                        }},
                        "First"
                },

        };
    }

}