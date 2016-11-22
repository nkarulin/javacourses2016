package com.epam.javacourses2016.task18;

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
        /*
        int[][] matrix = new int[5][5];
        Stack<Integer> uniqueMatrix = new Stack<>();
        boolean matrixFound = false;
        int rowSize = 1;
        int colSize = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                if (matrix[row][col] == matrix[row][col + 1]) {
                    //checkNextRow();
                }
            }
        }
        return null;
        */
        return null;
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
