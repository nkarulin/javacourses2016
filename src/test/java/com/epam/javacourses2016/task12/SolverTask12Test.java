package com.epam.javacourses2016.task12;

import com.epam.javacourses2016.task7.SolverTask7Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SolverTask12Test {

    @Test(enabled = false, dataProvider = "numbers")
    public void testTransform(int[] array, int value) throws Exception {
        SolverTask12 solver = new SolverTask12();

        List<Integer> list = SolverTask7Test.convertToList(array);
        list = solver.transform(list, value);

        boolean wrongSort = false;
        boolean previousGreater = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= value) {
                previousGreater = true;
            }
            if (list.get(i) < value && previousGreater) {
                wrongSort = true;
                break;
            }
        }

        if (wrongSort) {
            Assert.fail("Wrong sort!");
        }
    }

    @DataProvider(name = "numbers")
    public Object[][] numbers() {
        return new Object[][]{
                {new int[]{5, 4, 3, 2, 1}, 5},
                {new int[]{1, 2, 3, 4, 5}, 5},
                {new int[]{6, 4, 5, 8, 1}, 5},
                {new int[]{5}, 5}
        };
    }
}