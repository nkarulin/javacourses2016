package com.epam.javacourses2016.task8;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SolverTask8Test {

    @Test(enabled = false, dataProvider = "myString")
    public void testIsNormalBrackets(String string, boolean result) throws Exception {
        SolverTask8 solver = new SolverTask8();
        Assert.assertEquals(solver.isNormalBrackets(string), result);
    }

    @DataProvider(name = "myString")
    public Object[][] getMyString() {
        return new Object[][]{
                {"{Hello[]}()", true},
                {"[()}", false},
                {"}{[({)]}Vasya", false},
                {"Vasya{}", true},
                {"}{",false}
        };
    }
}