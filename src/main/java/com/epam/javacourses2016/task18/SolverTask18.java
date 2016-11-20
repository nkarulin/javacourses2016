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

    public static class Matrix implements RectangularIntegerMatrix {

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
}



