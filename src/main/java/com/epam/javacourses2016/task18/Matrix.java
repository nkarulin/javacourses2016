package com.epam.javacourses2016.task18;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ivan on 01/12/2016.
 */
public class Matrix implements SolverTask18.RectangularIntegerMatrix {

    int matrix[][];
    int maxUniqueCount = 0;
    Stack<int[][]> matrixStack = new Stack<>();

    public Matrix() {

    }

    public Matrix(SolverTask18.RectangularIntegerMatrix matrix) {
        this.matrix = convertMatrixToArray(matrix);
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix getMaxMatrixWithUniqueElements() {
        getGreatestSubMatrix(matrix);
        return new Matrix(matrixStack.peek());
    }

    private int[][] convertMatrixToArray(SolverTask18.RectangularIntegerMatrix matrix) {
        int[][] arrayMatrix = new int[matrix.getWidth()][matrix.getHeight()];
        for (int i = 0; i < arrayMatrix.length; i++) {
            for (int j = 0; j < arrayMatrix[i].length; j++) {
                arrayMatrix[i][j] = matrix.getValue(i, j);
            }
        }
        return arrayMatrix;
    }

    private void getGreatestSubMatrix(int[][] greatestSubMatrix) {
        int uniqueValues = checkMatrixForUniqueValues(greatestSubMatrix);
        int matrixSize = (greatestSubMatrix.length * greatestSubMatrix[0].length);

        if (uniqueValues == matrixSize && uniqueValues > 1 && uniqueValues > maxUniqueCount) {
            matrixStack.clear();
            matrixStack.push(greatestSubMatrix);
            maxUniqueCount = uniqueValues;
        }

        getGreaterSubMatrices(greatestSubMatrix);
    }

    private void getGreaterSubMatrices(int[][] parent) {
        int rowCount = parent.length;
        int colCount = parent[0].length;

        if (rowCount > 1) {
            int[][] subTop = getSubMatrix(1, 0, rowCount, colCount, parent);
            getGreatestSubMatrix(subTop);

            int[][] subBot = getSubMatrix(0, 0, rowCount - 1, colCount, parent);
            getGreatestSubMatrix(subBot);
        }

        if (colCount > 1) {
            int[][] subLeft = getSubMatrix(0, 1, rowCount, colCount, parent);
            getGreatestSubMatrix(subLeft);

            int[][] subRight = getSubMatrix(0, 0, rowCount, colCount - 1, parent);
            getGreatestSubMatrix(subRight);
        }
    }

    private int[][] getSubMatrix(int startRow, int startCol, int endRow, int endCol, int[][] parent) {

        int[][] subMatrix = new int[endRow - startRow][endCol - startCol];
        int rowIndex = 0;

        for (int i = startRow; i < endRow; i++) {
            int colIndex = 0;
            for (int j = startCol; j < endCol; j++) {
                subMatrix[rowIndex][colIndex] = parent[i][j];
                colIndex++;
            }
            rowIndex++;
        }

        return subMatrix;
    }

    private int checkMatrixForUniqueValues(int[][] checkMatrix) {
        int checkValue = checkMatrix[0][0];

        for (int i = 0; i < checkMatrix.length; i++) {
            for (int j = 0; j < checkMatrix[i].length; j++) {
                if (checkMatrix[i][j] != checkValue) {
                    return 1;
                }
            }
        }

        //Return unique elements count, if all elements same.
        return checkMatrix.length * checkMatrix[0].length;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        return Arrays.deepEquals(matrix, matrix1.matrix);

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }
}
