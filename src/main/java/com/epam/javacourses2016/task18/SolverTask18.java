package com.epam.javacourses2016.task18;

import java.util.ArrayList;
import java.util.List;

/**
 * Дана матрица из целых чисел.
 * Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов.
 * Использовать стек.
 */
public class SolverTask18 {
    /**
     * @param myArrayMatrix Анализируемая матрица.
     * @return Подматрица, состоящая из максимального количества одинаковых элементов.
     */
    private int myArrayMatrix[][];
    private int rowCount = 1;
    private int colCount = 1;
    private int startRow = 0;
    private int startCol = 0;
    List<RectangularIntegerMatrix> listOfMatrix = new ArrayList<>();

    RectangularIntegerMatrix getMaxSubMatrix(RectangularIntegerMatrix matrix) {
        myArrayMatrix = toArrayMatrix(matrix);
        for (int i = 0; i < myArrayMatrix.length; i++) {
            for (int j = 0; j < myArrayMatrix[i].length - 1; j++) {
                if (myArrayMatrix[i][j] == myArrayMatrix[i][j + 1]) {
                    rowCount++;
                    startRow = i;
                    startCol = j;
                    checkCloseCells(i, j, myArrayMatrix[i][j]);
                }
            }
        }

        return null;
    }

    private void checkCloseCells(int row, int col, int value) {
        boolean haveBotRow = true;
        boolean haveRightCol = true;

        haveBotRow = checkBotRow(row, col, value);
        haveRightCol = checkRightCol(row, col, value);

        if (haveBotRow && haveRightCol) {
            checkCloseCells(row + 1, col + 1, value);
        }

        if (!haveBotRow && haveRightCol) {
            while (haveRightCol) {
                haveRightCol = checkRightCol(row, col, value);
            }
        }

        if (!haveRightCol && haveBotRow) {
            while (haveBotRow) {
                haveBotRow = checkBotRow(row, col, value);
            }
        }

        MyMatrix myMatrix = new MyMatrix(startRow, startCol, rowCount, colCount, value);
        listOfMatrix.add(myMatrix);
    }

    private boolean checkBotRow(int row, int col, int value) {
        if (row + 1 >= myArrayMatrix.length - 1) {
            return false;
        }
        
        boolean haveBotRow = true;
        for (int i = 0; i < colCount; i++) {
            if (myArrayMatrix[row + 1][col + i] != value) {
                haveBotRow = false;
            }
        }

        rowCount++;
        return haveBotRow;
    }

    private boolean checkRightCol(int row, int col, int value) {
        if (col + 1 > myArrayMatrix[0].length - 1) {
            return false;
        }

        boolean haveRightCol = true;
        for (int i = 0; i < rowCount; i++) {
            if (myArrayMatrix[row + i][col + 1] != value) {
                haveRightCol = false;
            }
        }

        colCount++;
        return haveRightCol;
    }

    private int[][] toArrayMatrix(RectangularIntegerMatrix matrix) {
        int[][] arrayMatrix = new int[matrix.getHeight()][matrix.getWidth()];

        for (int i = 0; i < arrayMatrix.length; i++) {
            for (int j = 0; j < arrayMatrix[0].length; j++) {
                arrayMatrix[i][j] = matrix.getValue(i, j);
            }
        }

        return arrayMatrix;
    }

    class MyMatrix implements RectangularIntegerMatrix {

        public MyMatrix() {

        }

        public MyMatrix(int startX, int startY, int row, int col, int value) {

        }

        @Override
        public int getWidth() {
            return 0;
        }

        @Override
        public int getHeight() {
            return 0;
        }

        @Override
        public int getValue(int indexWidth, int indexHeight) {
            return 0;
        }
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
