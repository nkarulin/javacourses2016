package com.epam.javacourses2016.task18;

import java.util.Objects;
import java.util.Stack;

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
    public RectangularIntegerMatrix getMaxSubMatrix(RectangularIntegerMatrix matrix) {
        if (matrix.getWidth() == 1 && matrix.getHeight() == 1) {
            return new Matrix(new int[][]{{matrix.getValue(0, 0)}});
        }
        Stack<Matrix> matrixStack = getStackSubMatrix(matrix);
        Matrix maxSubMatrix = null;
        if (!matrixStack.empty()) {
            maxSubMatrix = matrixStack.peek();
            int maxNumberOfIdenticalValues = calculateNumberOfIdenticalValue(maxSubMatrix);
            for (Matrix subMatrix : matrixStack) {
                int numberOfIdenticalValues = calculateNumberOfIdenticalValue(subMatrix);
                if (numberOfIdenticalValues > maxNumberOfIdenticalValues) {
                    maxNumberOfIdenticalValues = numberOfIdenticalValues;
                    maxSubMatrix = subMatrix;
                }
            }
        }
        return maxSubMatrix;
    }

    private Stack<Matrix> getStackSubMatrix(RectangularIntegerMatrix matrix) {
        Stack<Matrix> matrixStack = new Stack<>();
        for (int startRow = 0; startRow < matrix.getHeight(); startRow++) {
            for (int startCol = 0; startCol < matrix.getWidth(); startCol++) {
                for (int endRow = startRow; endRow < matrix.getHeight(); endRow++) {
                    for (int endCol = startCol; endCol < matrix.getWidth(); endCol++) {
                        Matrix subMatrix = this.getSubMatrix(matrix, startRow, startCol, endRow + 1, endCol + 1);
                        if (!matrixStack.contains(subMatrix) || !Objects.deepEquals(matrix, subMatrix)) {
                            matrixStack.add(subMatrix);
                        }
                    }
                }
            }
        }
        return matrixStack;
    }

    private Matrix getSubMatrix(RectangularIntegerMatrix matrix, int startRow, int startCol, int endRow, int endCol) {
        int[][] subMatrix = new int[endRow - startRow][endCol - startCol];
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[0].length; j++) {
                subMatrix[i][j] = matrix.getValue(startCol + j, startRow + i);
            }
        }
        return new Matrix(subMatrix);
    }

    private int calculateNumberOfIdenticalValue(Matrix matrix) {
        int value = matrix.getValue(0, 0);
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                if (matrix.getValue(j, i) != value) {
                    return 1;
                }
            }
        }
        return matrix.getHeight() * matrix.getWidth();
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




