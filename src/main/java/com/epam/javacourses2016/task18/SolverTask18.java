package com.epam.javacourses2016.task18;

import java.util.Arrays;

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
        int[][] arr = new int[1][1];
        arr[0][0] = matrix.getValue(0, 0);
        Matrix max = new Matrix(arr);
        Matrix temp;
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                temp = (Matrix) maxSubMatrixFromThisPosition(matrix, i, j);
                if (temp.getWidth() * temp.getHeight() > max.getHeight() * max.getWidth())
                    max = temp;
            }
        }
        return max;
    }

    private RectangularIntegerMatrix maxSubMatrixFromThisPosition(RectangularIntegerMatrix matrix, int row, int col) {
        int[] numbersConcurrency = new int[matrix.getHeight()];
        int i = row;
        int elem = matrix.getValue(row, col);
        int j = col;
        while (i < matrix.getHeight() && elem == matrix.getValue(i, j)) {

            while (j < matrix.getWidth() && elem == matrix.getValue(i, j)) {
                numbersConcurrency[i] += 1;
                j++;
            }
            j = col;
            i++;
        }
        return maxMatrix(matrix, row, col, numbersConcurrency);
    }

    private RectangularIntegerMatrix maxMatrix(RectangularIntegerMatrix matrix, int row, int col, int[] numbersConcurrency) {
        int max = numbersConcurrency[row];
        int min = numbersConcurrency[row];
        int[][] result = new int[1][max];
        int elem = matrix.getValue(row, col);
        for (int j = 0; j < max; j++) {
            result[0][j] = elem;
        }
        for (int i = row+1; i < numbersConcurrency.length; i++) {
            if (numbersConcurrency[i] > max) {
                max = numbersConcurrency[i];
                result = new int[1][max];
                elem = matrix.getValue(row, col);
                for (int j = 0; j < max; j++) {
                    result[0][j] = elem;
                }
            }
            if (numbersConcurrency[i] < min) min = numbersConcurrency[i];
            if (min * (i + 1 - row) >= max) {
                result = new int[i+1][min];
                elem = matrix.getValue(row, col);
                for (int k = 0; k <=i; k++) {
                    for (int j = 0; j < min; j++) {
                        result[k][j] = elem;
                    }
                }
                max=min * (i + 1 - row);
            }
        }
        return new Matrix(result);
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