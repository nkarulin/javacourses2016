package com.epam.javacourses2016.task18;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask18Test {

    @Test(enabled = true, dataProvider = "matrix")
    public void testGetMaxSubMatrix(int[][] data, int[][] result) throws Exception {
        SolverTask18 task18 = new SolverTask18();
        SolverTask18.RectangularIntegerMatrix matrix = convertToMatrix(data);
        SolverTask18.RectangularIntegerMatrix resultMatrix = convertToMatrix(result);
        Assert.assertEquals(task18.getMaxSubMatrix(matrix), resultMatrix);
    }


    public SolverTask18.RectangularIntegerMatrix convertToMatrix(int[][] arr) {
        return new SolverTask18.Matrix(arr);
    }
    @DataProvider(name = "matrix")
    public Object[][] matrix() {
        return new Object[][]{
                {new int[][]{{1, 1, 1, 2, 2},{1, 2, 1, 3, 4},{1, 6, 4, 2, 5}},new int[][]{{1,1,1},{1,2,1},{1,6,4}}},
                {new int[][]{{1, 2, 1, 1},{3, 4, 1, 1},{2, 5, 3, 2}},new int[][]{{1,2,1,1},{3,4,1,1}}}
        };
    }

}
