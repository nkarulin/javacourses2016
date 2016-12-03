package com.epam.javacourses2016.task18;

import com.epam.javacourses2016.task17.SolverTask17;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask18Test {

    @Test(enabled = true, dataProvider = "matrixData")
    public void testGetMaxSubMatrix(int[][] matrixData) throws Exception {
        SolverTask18 solver = new SolverTask18();
        TestMatrix testMatrix = new TestMatrix(matrixData);
        SolverTask18.RectangularIntegerMatrix matrix = solver.getMaxSubMatrix(testMatrix);
        int x =5;
    }

    @DataProvider(name = "matrixData")
    public Object[][] matrixData () {
        return new Object[][] {
                {new int[][]{{1,2,3},{2,1,1},{3,1,1}}},
                {new int [][] {{1,1,1}, {1,1,1}, {1,1,1}}}
        };
    }

    class TestMatrix implements SolverTask18.RectangularIntegerMatrix {
        int[][] matrix;

        public TestMatrix(int[][] matrix) {
            this.matrix = matrix;
        }
        @Override
        public int getWidth() {
            return matrix.length;
        }

        @Override
        public int getHeight() {
            return matrix[0].length;
        }

        @Override
        public int getValue(int indexWidth, int indexHeight) {
            return matrix[indexWidth][indexHeight];
        }
    }
}
