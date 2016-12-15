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
        int maxUniqueCount = 0;
        int currUniqueCount = 0;
        //Stack<int[][]> matrixStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int[][] arr = convertMatrixToArray(matrix);
        int tmp;

        //by cols
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (stack.empty()) {
                    stack.push(arr[i][j]);
                    currUniqueCount=1;
                } else
                {
                    tmp=stack.pop();
                    if (tmp==arr[i][j]){
                        currUniqueCount++;
                    }
                    else
                    {
                        stack.clear();
                        stack.push(arr[i][j]);
                        if (currUniqueCount>maxUniqueCount){
                            maxUniqueCount=currUniqueCount;
                        }
                    }
                }

            }
        }
        return null;
    }

    private int[][] convertMatrixToArray(SolverTask18.RectangularIntegerMatrix matrix) {
        int[][] arrayMatrix = new int[matrix.getWidth()][matrix.getHeight()];
        for (int i = 0; i < arrayMatrix.length; i++) {
            for (int j = 0; j < arrayMatrix[i].length; j++) {
                arrayMatrix[i][j] = matrix.getValue(i, j);
            }
        }
        return arrayMatrix;
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
