package com.epam.javacourses2016.task10;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class SolverTask10Test {

    @Test(dataProvider = "text2")
    public void testCountNumberWords(String fileName, HashMap<String, Integer> uniqueWords) throws Exception {
        SolverTask10 solver = new SolverTask10();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        Assert.assertEquals(solver.countNumberWords(file), uniqueWords);
    }

    @DataProvider(name = "text2")
    public Object[][] text() {
        return new Object[][]{
                {"com/epam/javacourses2016/task9/text1.txt", new HashMap<String, Integer>() {{
                    put("First", 1);
                    put("test", 2);
                    put("easy", 1);
                    put("one", 1);
                    put("One", 1);
                    put("problem", 1);
                    put("per", 1);
                }}}
        };
    }
}