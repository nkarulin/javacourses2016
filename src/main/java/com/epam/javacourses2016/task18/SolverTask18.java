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
        Stack<Matrix> matrixStack = matrix.getStackSubMatrix();
        Matrix maxSubMatrix = null;
        if (!matrixStack.empty()) {
            maxSubMatrix = matrixStack.peek();
            int maxNumberOfIdenticalValues = maxSubMatrix.numberOfIdenticalValue();
            for (Matrix subMatrix : matrixStack) {
                int numberOfIdenticalValues = subMatrix.numberOfIdenticalValue();
                if (numberOfIdenticalValues > maxNumberOfIdenticalValues) {
                    maxNumberOfIdenticalValues = numberOfIdenticalValues;
                    maxSubMatrix = subMatrix;
                }
            }
        }
        return maxSubMatrix;
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

        /**
         * @param leftUpIndexRow    Индекс строки левого, верхнего угла подматрицы.
         * @param leftUpIndexCol    Индекс столбца левого, верхнего угла подматрицы.
         * @param rightDownIndexRow Индекс строки правого, нижнего угла подматрицы.
         * @param rightDownIndexCol Индекс столбца правого, нижнего угла подматрицы.
         * @return Подматрицв в указанном области.
         */
        Matrix getSubMatrix(int leftUpIndexRow, int leftUpIndexCol, int rightDownIndexRow, int rightDownIndexCol);

        /**
         * @return Стэк уникальных подматриц из матрицы.
         */
        Stack<Matrix> getStackSubMatrix();

        /**
         * @return Максимальное количество уникальных значений в матрице.
         */
        int numberOfIdenticalValue();
    }
}




