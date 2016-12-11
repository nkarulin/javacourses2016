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
        //TODO
        Deque<Matrix> matrices = getAllSubMatrix(matrix);
        Matrix maxMatrix = null;
        if (!matrices.isEmpty()) {
            maxMatrix = matrices.peekFirst();
            int maxNumberOfEquals = numberOfEquals(maxMatrix);
            for (Matrix subMatrix : matrices) {
                int numberOfEquals = numberOfEquals(subMatrix);
                if (numberOfEquals > maxNumberOfEquals) {
                    maxNumberOfEquals = numberOfEquals;
                    maxMatrix = subMatrix;
                }
            }
        }
        return maxMatrix;
    }

    public Integer numberOfEquals(Matrix matrix) {
        Map<Integer, Integer> rowsAndCols = new HashMap<>();
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                int value = matrix.getValue(i, j);
                if (rowsAndCols.containsKey(value)) {
                    rowsAndCols.put(value, rowsAndCols.get(value) + 1);
                } else {
                    rowsAndCols.put(value, 1);
                }
            }
        }
        return Collections.max(rowsAndCols.values());
    }

    Deque<Matrix> getAllSubMatrix(RectangularIntegerMatrix matrix) {
        Deque<Matrix> matrices = new LinkedList<>();
        for (int x = 0; x < matrix.getHeight(); x++) {
            for (int y = 0; y < matrix.getWidth(); y++) {
                for (int i = x; i < matrix.getHeight(); i++) {
                    for (int j = y; j < matrix.getWidth(); j++) {
                        Matrix subMatrix = getSubMatrix(matrix, x, y, i + 1, j + 1);
                        if (subMatrix == null || matrices.contains(subMatrix)) {
                            continue;
                        }
                        matrices.addFirst(subMatrix);
                    }
                }
            }
        }
        return matrices;
    }

    public Matrix getSubMatrix(RectangularIntegerMatrix matrix, int x, int y, int rows, int columns) {
        int[][] newData = new int[rows - x][columns - y];
        for (int i = 0; i < newData.length; i++) {
            for (int j = 0; j < newData[i].length; j++) {
                newData[i][j] = matrix.getValue(i, j);
            }
        }
        return new Matrix(newData);
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
