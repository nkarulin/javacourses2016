package com.epam.javacourses2016.task12;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SolverTask12Test {
    @Test(dataProvider = "nums")
    public void testTransform(List<Integer> list, int value) throws Exception {
        SolverTask12 solver = new SolverTask12();

        list = solver.transform(list, value);
        int elementIndex = list.indexOf(value);

        boolean elementsBeforeSmaller = true;
        for (int i = 0; i < elementIndex; i++) {
            if (list.get(i) > value) {
                elementsBeforeSmaller = false;
                break;
            }
        }

        boolean elemetsAfterGreater = true;
        for (int i = elementIndex; i < list.size(); i++) {
            if (list.get(i) < value) {
                elemetsAfterGreater = false;
                break;
            }
        }

        if (!elemetsAfterGreater || !elementsBeforeSmaller) {
            String error = "";
            if (!elemetsAfterGreater) {
                error += "\nElements after value smaller!";
            }
            if (!elementsBeforeSmaller) {
                error += "\nElements before value greater!";
            }
            Assert.fail(error);
        }
    }

    @DataProvider(name = "nums")
    public Object[][] nums() {
        return new Object[][]{
                {new ArrayList<Integer>() {{
                    add(5);
                    add(4);
                    add(3);
                    add(2);
                    add(1);
                }}, 5},
                {new ArrayList<Integer>() {{
                    add(1);
                    add(2);
                    add(3);
                    add(4);
                    add(5);
                }}, 5},
                {new ArrayList<Integer>() {{
                    add(6);
                    add(4);
                    add(5);
                    add(8);
                    add(1);
                }}, 5},
                {new ArrayList<Integer>() {{
                    add(5);
                }}, 5}
        };
    }

}