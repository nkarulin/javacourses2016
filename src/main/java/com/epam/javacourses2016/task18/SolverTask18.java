package com.epam.javacourses2016.task18;

import java.util.ArrayList;

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
    static RectangularIntegerMatrix getMaxSubMatrix(RectangularIntegerMatrix matrix) {
        ArrayList<ArrayList<Pair>> pairsMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.getHeight(); i++) {
            ArrayList<Pair> pairsRow = new ArrayList<>();
            for (int j = 0; j < matrix.getWidth(); j++) {
                pairsRow.add(j, new Pair(0, 0));
            }
            pairsMatrix.add(i, pairsRow);
        }
        pairsMatrix.get(matrix.getHeight() - 1).set(matrix.getWidth() - 1, new Pair(1, 1));
        for (int i = matrix.getWidth() - 2; i >= 0; i--) {
            if (matrix.getValue(matrix.getHeight() - 1, i) == matrix.getValue(0, i + 1)) {
                Pair temp = new Pair(1, pairsMatrix.get(matrix.getHeight() - 1).get(i + 1).getWidth() + 1);
                pairsMatrix.get(matrix.getHeight() - 1).set(i, temp);
            } else {
                pairsMatrix.get(matrix.getHeight() - 1).set(i, new Pair(1, 1));
            }
        }
        for (int i = matrix.getHeight() - 2; i >= 0; i--) {
            if (matrix.getValue(i,matrix.getWidth() - 1) == matrix.getValue(i+1, matrix.getWidth() - 1)) {
                Pair temp = new Pair(pairsMatrix.get(i+1).get(matrix.getWidth() - 1).getHeight()+1, 1);
                pairsMatrix.get(i).set(matrix.getWidth() - 1, temp);
            } else {
                pairsMatrix.get(i).set(matrix.getWidth() - 1, new Pair(1,1));
            }
        }
        int maxS = 1;
        int maxI = 0;
        int maxJ = 0;
        for (int i = matrix.getHeight() - 2; i >= 0; i--) {
            for (int j = matrix.getWidth() - 2; j >= 0; j--) {
                if (matrix.getValue(i, j) == matrix.getValue(i, j + 1) && matrix.getValue(i, j) != matrix.getValue(i + 1, j)) {
                    Pair temp = new Pair(1, pairsMatrix.get(i+1).get(j).getWidth() + 1);
                    if (temp.getWidth() * temp.getHeight() >= maxS) {
                        maxS = temp.getWidth() * temp.getHeight();
                        maxI = i;
                        maxJ = j;
                    }
                    pairsMatrix.get(i).set(j, temp);
                } else if (matrix.getValue(i, j) != matrix.getValue(i, j + 1) && matrix.getValue(i, j) == matrix.getValue(i + 1, j)) {
                    Pair temp = new Pair(pairsMatrix.get(i).get(j+1).getHeight() + 1, 1);
                    pairsMatrix.get(i).set(j, temp);
                    if (temp.getWidth() * temp.getHeight() >= maxS) {
                        maxS = temp.getWidth() * temp.getHeight();
                        maxI = i;
                        maxJ = j;
                    }
                } else if (matrix.getValue(i, j) == matrix.getValue(i, j + 1) && matrix.getValue(i, j) == matrix.getValue(i + 1, j)) {
                    Pair temp = new Pair(pairsMatrix.get(i+1).get(j).getHeight() + 1, pairsMatrix.get(i).get(j+1).getWidth() + 1);
                    Pair temp1 = new Pair(Math.min(pairsMatrix.get(i).get(j+1).getHeight() + 1, pairsMatrix.get(i+1).get(j).getHeight()),
                            Math.min(pairsMatrix.get(i+1).get(j).getWidth(), pairsMatrix.get(i).get(j+1).getWidth()));
                   if (temp.getHeight() * temp.getWidth() > temp1.getHeight() * temp1.getWidth()) {
                       pairsMatrix.get(i).set(j, temp);
                   } else {
                       pairsMatrix.get(i).set(j, temp1);
                   }
                    if (temp.getWidth() * temp.getHeight() >= maxS) {
                        maxS = temp.getWidth() * temp.getHeight();
                        maxI = i;
                        maxJ = j;
                    }
                } else {
                    pairsMatrix.get(i).set(j, new Pair(1,1));
                }
            }
        }
        int resMatrixHeight = pairsMatrix.get(maxI).get(maxJ).getHeight();
        int resMatrixWidth = pairsMatrix.get(maxI).get(maxJ).getWidth();
        int[][] resM = new int[resMatrixHeight][resMatrixWidth];
        for (int i = maxI; i < maxI + resMatrixHeight; i++) {
            for (int j = maxJ; j < maxJ + resMatrixWidth; j++) {
                        resM[i - maxI][j - maxJ] = matrix.getValue(i,j);
            }
        }
        return new Matrix(resM);
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
