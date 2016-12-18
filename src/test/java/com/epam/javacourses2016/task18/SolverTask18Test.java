package com.epam.javacourses2016.task18;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask18Test {

    @Test(enabled = true, dataProvider = "matrix")
    public void testGetMaxSubMatrix(int[][] data, int[][] result) throws Exception {
        SolverTask18 task18 = new SolverTask18();
        SolverTask18.RectangularIntegerMatrix matrix = task18.getMaxSubMatrix(convertToMatrix(data));
        SolverTask18.RectangularIntegerMatrix resultMatrix = convertToMatrix(result);
        Assert.assertEquals(matrix, resultMatrix);
    }

    @DataProvider(name = "matrix")
    public Object[][] matrix() {
        return new Object[][]{
                {new int[][]{{1, 1, 1, 2, 2}, {1, 1, 1, 3, 4}, {1, 6, 4, 2, 5}}, new int[][]{{1, 1, 1}, {1, 1, 1}}},
                {new int[][]{{1, 2, 1, 1}, {3, 4, 1, 1}, {2, 5, 3, 2}}, new int[][]{{1, 1}, {1, 1}}}
        };
    }

    private SolverTask18.RectangularIntegerMatrix convertToMatrix(int[][] arr) {
        return new Matrix(arr);
    }
}
