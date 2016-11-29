package com.epam.javacourses2016.task18;

import java.util.*;

public class Matrix implements SolverTask18.RectangularIntegerMatrix {

    private int[][] matrix;

    public Matrix(int[][] data) {
        this.matrix = data;
    }

    public int[][] getMatrix() {
        return matrix;
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

    @Override
    public Matrix getSubMatrix(int leftUpIndexRow, int leftUpIndexCol, int rightDownIndexRow, int rightDownIndexCol) throws NegativeArraySizeException {
        int[][] subMatrix = new int[rightDownIndexRow - leftUpIndexRow][rightDownIndexCol - leftUpIndexCol];
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                subMatrix[i][j] = getValue(leftUpIndexRow + i, leftUpIndexCol + j);
            }
        }
        return new Matrix(subMatrix);
    }

    @Override
    public Stack<Matrix> getStackSubMatrix() {
        Stack<Matrix> matrixStack = new Stack<>();
        for (int x = 0; x < getHeight(); x++) {
            for (int y = 0; y < getWidth(); y++) {
                for (int i = 0; i < getHeight(); i++) {
                    for (int j = 0; j < getWidth(); j++) {
                        Matrix subMatrix = null;
                        try {
                            subMatrix = this.getSubMatrix(x, y, i + 1, j + 1);
                            if (matrixStack.contains(subMatrix) || Arrays.deepEquals(getMatrix(), subMatrix.getMatrix()))
                                continue;
                            matrixStack.add(subMatrix);
                        } catch (NegativeArraySizeException e) {
                            continue;
                        }
                    }
                }
            }
        }
        return matrixStack;
    }

    @Override
    public int numberOfIdenticalValue() {
        Map<Integer, Integer> numberOfValuesMap = new HashMap<>();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (numberOfValuesMap.containsKey(getValue(i, j))) {
                    numberOfValuesMap.put(getValue(i, j), numberOfValuesMap.get(getValue(i, j)) + 1);
                    continue;
                }
                numberOfValuesMap.put(getValue(i, j), 1);
            }
        }
        Iterator<Integer> iterator = numberOfValuesMap.values().iterator();
        int maxNumber = 0;
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next > maxNumber) {
                maxNumber = next;
            }
        }
        return maxNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return Arrays.deepEquals(getMatrix(), ((Matrix) obj).getMatrix());
    }
}
