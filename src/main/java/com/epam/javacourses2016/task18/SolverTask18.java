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
        int[][] arr = convertMatrixToArray(matrix);
        int element = mostMetElement(arr);
        TreeSet<Integer> cols = new TreeSet<>();
        TreeSet<Integer> rows = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == element) {
                    cols.add(j);
                    rows.add(i);
                }

            }
        }

        int[][] resultMatrix = new int[rows.size()][cols.size()];
        int i = 0;
        int j;
        for (int r : rows) {
            j = 0;
            for (int c : cols) {
                resultMatrix[i][j] = arr[r][c];
                j++;
            }
            i++;
        }
        return (new Matrix(resultMatrix));
    }

    private int[][] convertMatrixToArray(SolverTask18.RectangularIntegerMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int[][] arrayMatrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arrayMatrix[i][j] = matrix.getValue(i, j);
            }
        }

        return arrayMatrix;
    }

    private int mostMetElement(int[][] matrix) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int tmp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (hashMap.get(matrix[i][j]) != null) {
                    tmp = hashMap.get(matrix[i][j]);
                } else {
                    tmp = 0;
                }
                tmp++;
                hashMap.put(matrix[i][j], tmp);
            }
        }

        int uniqueElement = 0;
        int maxValueInMap = (Collections.max(hashMap.values()));
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                uniqueElement = entry.getKey();
            }
        }

        return uniqueElement;
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
