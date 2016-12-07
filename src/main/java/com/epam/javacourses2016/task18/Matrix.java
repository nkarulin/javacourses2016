package com.epam.javacourses2016.task18;

import java.util.*;

/**
 * Created by Ivan on 01/12/2016.
 */
public class Matrix implements SolverTask18.RectangularIntegerMatrix {

    private int[][] matrix;

    public Matrix(int[][] data) {
        this.matrix = data;
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
        return matrix[indexHeight][indexWidth];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()){
            throw new ClassCastException();
        }
        Matrix matrix1 = (Matrix) o;
        return Arrays.deepEquals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }
}
