package com.epam.javacourses2016.task8;

import com.epam.javacourses2016.task4.SolverTask4;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;

import static org.testng.Assert.*;

public class SolverTask8Test {
    @Test(enabled = true, dataProvider = "brackets")
    public void testIsNormalBrackets(String string, boolean result) throws Exception {
        SolverTask8 task8 = new SolverTask8();
        Assert.assertEquals(task8.isNormalBrackets(string), result);
    }
    @DataProvider(name = "brackets")
    private Object[][] brackets() {
        return new Object[][]{
                {"[][{}{",false},
                {")(x+y)",false},
                {"(x*2){[x-y]+2}",true}
        };
    }
}