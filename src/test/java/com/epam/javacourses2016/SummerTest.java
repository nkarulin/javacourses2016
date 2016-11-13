package com.epam.javacourses2016;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SummerTest {

    @Test
    public void testShouldSumCorrectly() {
        Assert.assertEquals(Summer.sum(2, 3), 5);
    }
}