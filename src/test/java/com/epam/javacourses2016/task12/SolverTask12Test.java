package com.epam.javacourses2016.task12;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SolverTask12Test {
    @Test(enabled = true, dataProvider = "integers")
    public void testTransform(Integer[] integers, int value) throws Exception {
        SolverTask12 task12 = new SolverTask12();
        List<Integer> resultList = task12.transform(convertToList(integers), value);
        Assert.assertFalse(!isSorted(resultList, value));
    }

    public List<Integer> convertToList(Integer[] array) {
        return Arrays.asList(array);
    }

    public boolean isSorted(List<Integer> integers, int value) {
        boolean isCorrect = true;
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i) >= value) {
                if (integers.get(i + 1) >= value) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                    break;
                }
            }
        }
        return isCorrect;
    }

    @DataProvider(name = "integers")
    public Object[][] integers() {
        return new Object[][]{
                {new Integer[]{6, 4, 3, 2, 1}, 5},
                {new Integer[]{1, 2, 3, 4, 5}, 7},
                {new Integer[]{6, 4, 5, 8, 1}, 5},
                {new Integer[]{5}, 5}
        };
    }

}