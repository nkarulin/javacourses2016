package com.epam.javacourses2016.task18;

import java.util.*;

/**
 * Дана матрица из целых чисел.
 * Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов.
 * Использовать стек.
 */
public class SolverTask18 {
    /**
     * @param matrix Анализируемая матрица.
     * @return Подматрица, состоящая из максимального количества одинаковых элементов.
     */
    RectangularIntegerMatrix getMaxSubMatrix(RectangularIntegerMatrix matrix) {
        Stack<Matrix> matrixStack = getStackSubMatrix(matrix);
        Matrix maxSubMatrix = null;
        if (!matrixStack.empty()) {
            maxSubMatrix = matrixStack.peek();
            int maxNumberOfIdenticalValues = numberOfIdenticalValue(maxSubMatrix);
            for (Matrix subMatrix : matrixStack) {
                int numberOfIdenticalValues = numberOfIdenticalValue(subMatrix);
                if (numberOfIdenticalValues > maxNumberOfIdenticalValues) {
                    maxNumberOfIdenticalValues = numberOfIdenticalValues;
                    maxSubMatrix = subMatrix;
                }
            }
        }
        return maxSubMatrix;
    }

    public Matrix getSubMatrix(RectangularIntegerMatrix matrix, int leftUpIndexRow, int leftUpIndexCol, int rightDownIndexRow, int rightDownIndexCol) throws NegativeArraySizeException {
        int[][] subMatrix = new int[rightDownIndexRow - leftUpIndexRow][rightDownIndexCol - leftUpIndexCol];
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                subMatrix[i][j] = matrix.getValue(leftUpIndexRow + i, leftUpIndexCol + j);
            }
        }
        return new Matrix(subMatrix);
    }

    public Stack<Matrix> getStackSubMatrix(RectangularIntegerMatrix matrix) {
        Stack<Matrix> matrixStack = new Stack<>();
        for (int x = 0; x < matrix.getHeight(); x++) {
            for (int y = 0; y < matrix.getWidth(); y++) {
                for (int i = 0; i < matrix.getHeight(); i++) {
                    for (int j = 0; j < matrix.getWidth(); j++) {
                        Matrix subMatrix = null;
                        try {
                            subMatrix = this.getSubMatrix(matrix,x, y, i + 1, j + 1);
                            if (matrixStack.contains(subMatrix) || Objects.deepEquals(matrix, subMatrix))
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

    public int numberOfIdenticalValue(Matrix matrix) {
        Map<Integer, Integer> numberOfValuesMap = new HashMap<>();
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                if (numberOfValuesMap.containsKey(matrix.getValue(i, j))) {
                    numberOfValuesMap.put(matrix.getValue(i, j), numberOfValuesMap.get(matrix.getValue(i, j)) + 1);
                    continue;
                }
                numberOfValuesMap.put(matrix.getValue(i, j), 1);
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



    /**
     * Прямоугольная матрица целых чисел.
     */
    interface RectangularIntegerMatrix {

        /**
         * @return Ширина матрицы.
         */
        int getWidth();

        /**
         * @return Высота матрицы.
         */
        int getHeight();

        /**
         * @param indexWidth  Индекс по ширине.
         * @param indexHeight Индекс по высоте.
         * @return Значение, располагающееся в указанной ячейке.
         */
        int getValue(int indexWidth, int indexHeight);

    }
}




