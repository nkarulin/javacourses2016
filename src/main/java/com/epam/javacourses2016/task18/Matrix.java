package com.epam.javacourses2016.task18;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Matrix implements SolverTask18.RectangularIntegerMatrix {

    private int data[][];
    Deque<int[][]> deque = new ArrayDeque<>();
    private int maxUniqNumberCount = 0;

    public Matrix(int[][] matrix) {
        this.data = matrix;
    }

    public Matrix(SolverTask18.RectangularIntegerMatrix matrix) {
        this.data = getIntegersFromMatrix(matrix);
    }


    public Matrix findMaxMatrixWithUniqs() {
        findMaxSubMatrix(data);
        return new Matrix(deque.peek());
    }

    private int[][] getIntegersFromMatrix(SolverTask18.RectangularIntegerMatrix matrix) {
        int[][] integerMatrix = new int[matrix.getWidth()][matrix.getHeight()];
        for (int i = 0; i < integerMatrix.length; i++) {
            for (int j = 0; j < integerMatrix[i].length; j++) {
                integerMatrix[i][j] = matrix.getValue(i, j);
            }
        }
        return integerMatrix;
    }

    @Override
    public int getWidth() {
        return data.length;
    }

    @Override
    public int getHeight() {
        return data[0].length;
    }

    @Override
    public int getValue(int indexWidth, int indexHeight) {
        return data[indexWidth][indexHeight];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        return Arrays.deepEquals(data, matrix1.data);

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }

    private void findMaxSubMatrix(int[][] maxSubMatrix) {
        int uniqueValues = findCountUniqueValues(maxSubMatrix);
        int matrixSize = (maxSubMatrix.length * maxSubMatrix[0].length);
        if (uniqueValues == matrixSize && uniqueValues > 1 && uniqueValues > maxUniqNumberCount) {
            deque.clear();
            deque.push(maxSubMatrix);
            maxUniqNumberCount = uniqueValues;
        }
        findUniqueSubMatrix(maxSubMatrix);
    }

    private void findUniqueSubMatrix(int[][] topMatrix) {
        int rows = topMatrix.length;
        int cols = topMatrix[0].length;
        if (rows > 1) {
            int[][] subMatrixInTop = getSubMatrix(1, 0, rows, cols, topMatrix);
            findMaxSubMatrix(subMatrixInTop);
            int[][] subMatrixInBottom = getSubMatrix(0, 0, rows - 1, cols, topMatrix);
            findMaxSubMatrix(subMatrixInBottom);
        }
        if (cols > 1) {
            int[][] subMatrixInLeft = getSubMatrix(0, 1, rows, cols, topMatrix);
            findMaxSubMatrix(subMatrixInLeft);
            int[][] subMatrixInRight = getSubMatrix(0, 0, rows, cols - 1, topMatrix);
            findMaxSubMatrix(subMatrixInRight);
        }
    }

    private int[][] getSubMatrix(int firstRow, int firstCol, int lastRow, int lastCol, int[][] topMatrix) {
        int[][] subMatrix = new int[lastRow - firstRow][lastCol - firstCol];
        int rowIndex = 0;
        for (int i = firstRow; i < lastRow; i++) {
            int colIndex = 0;
            for (int j = firstCol; j < lastCol; j++) {
                subMatrix[rowIndex][colIndex] = topMatrix[i][j];
                colIndex++;
            }
            rowIndex++;
        }
        return subMatrix;
    }

    private int findCountUniqueValues(int[][] matrix) {
        int count = matrix[0][0];
        for (int[] aCheckMatrix : matrix) {
            for (int anACheckMatrix : aCheckMatrix) {
                if (anACheckMatrix != count) {
                    return 1;
                }
            }
        }
        return matrix.length * matrix[0].length;
    }

}
