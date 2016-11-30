package com.epam.javacourses2016.task18;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class Matrix implements SolverTask18.RectangularIntegerMatrix {

    private int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getWidth() {
        return matrix[0].length;
    }

    @Override
    public int getHeight() {
        return matrix.length;
    }

    @Override
    public int getValue(int indexWidth, int indexHeight) {
        return matrix[indexWidth][indexHeight];
    }
}
