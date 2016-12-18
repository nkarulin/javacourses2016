package com.epam.javacourses2016.task18;

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
    RectangularIntegerMatrix getMaxSubMatrix(RectangularIntegerMatrix matrix) {
        Stack<Matrix> matrices = getStackMatrix(matrix);
        Matrix maxMatrix = null;
        int maxUniqueCount = 0;
        while (!matrices.empty()) {
            Matrix curMatrix = matrices.pop();
            int curCount = countEquals(curMatrix);
            if (curCount > maxUniqueCount) {
                maxMatrix = curMatrix;
                maxUniqueCount = curCount;
            }

        }
        return maxMatrix;
    }

    Stack<Matrix> getStackMatrix(RectangularIntegerMatrix matrix) {
        Stack<Matrix> stack = new Stack<>();
        for (int height = 1; height <= matrix.getHeight(); height++) {
            for (int width = 1; width <= matrix.getWidth(); width++) {
                for (int i = 0; i <= matrix.getHeight() - height; i++) {
                    for (int j = 0; j <= matrix.getWidth() - width; j++) {
                        Matrix curMatrix = getMatrix(matrix, j, i, width, height);
                        stack.add(curMatrix);
                    }
                }
            }
        }
        return stack;
    }

    Matrix getMatrix(RectangularIntegerMatrix matrix, int x, int y, int width, int height) {
        int[][] newMatrix = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newMatrix[j][i] = matrix.getValue(i + y, j + x);
            }
        }
        return new Matrix(newMatrix);
    }

    int countEquals(Matrix matrix) {
        int value = matrix.getValue(0, 0);
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                if (value != matrix.getValue(i, j)) return 1;
            }
        }
        return matrix.getHeight() * matrix.getWidth();
    }


    /**
     * Прямоугольная матрица целых чисел.
     */
    interface RectangularIntegerMatrix {

        /** @return Ширина матрицы. */
        int getWidth();

        /** @return Высота матрицы. */
        int getHeight();

        /**
         * @param indexWidth Индекс по ширине.
         * @param indexHeight Индекс по высоте.
         * @return Значение, располагающееся в указанной ячейке.
         */
        int getValue(int indexWidth, int indexHeight);
    }
}
