package com.epam.javacourses2016.task11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class SolverTask11Test {
    @Test()
    public void testEmulate() throws Exception {
        //TODO: with mocked list
    }

    @Test
    public void testEmulate1() throws Exception {
        //TODO: with mocked list
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