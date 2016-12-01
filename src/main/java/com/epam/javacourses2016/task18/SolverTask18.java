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
    private int matrixRowSize;
    private int matrixColSize;
    private int rowCount = 0;
    private int colCount = 0;
    private int startRow = 0;
    private int startCol = 0;
    private int cellValue = 0;
    List<RectangularIntegerMatrix> listOfMatrix = new ArrayList<>();

    RectangularIntegerMatrix getMaxSubMatrix(RectangularIntegerMatrix matrix) {
        myArrayMatrix = toArrayMatrix(matrix);
        matrixRowSize = myArrayMatrix.length;
        matrixColSize = myArrayMatrix[0].length;

        for (int i = 0; i < myArrayMatrix.length; i++) {
            for (int j = 0; j < myArrayMatrix[i].length - 1; j++) {
                if (myArrayMatrix[i][j] == myArrayMatrix[i][j + 1]) {
                    colCount++;
                    startRow = i;
                    startCol = j;
                    cellValue = myArrayMatrix[i][j];
                    checkCloseCells(i, j, myArrayMatrix[i][j]);
                }
            }
        }

        return null;
    }

    private void checkCloseCells(int row, int col, int value) {
        boolean haveBotRow = true;
        boolean haveRightCol = true;

        haveBotRow = checkBotRow();
        haveRightCol = checkRightCol();

        if (haveBotRow && haveRightCol && rowCount < matrixRowSize && colCount < matrixColSize) {
            checkCloseCells(rowCount, colCount, value);
        }

        if (!haveBotRow && haveRightCol) {
            while (haveRightCol) {
                haveRightCol = checkRightCol();
            }
        }

        if (!haveRightCol && haveBotRow) {
            while (haveBotRow) {
                haveBotRow = checkBotRow();
            }
        }

        if (colCount != 0 && rowCount != 0) {
            MyMatrix myMatrix = new MyMatrix(startRow, startCol, rowCount, colCount, cellValue);
            listOfMatrix.add(myMatrix);
        }

        startRow = 0;
        startCol = 0;
        rowCount = 0;
        colCount = 0;
        cellValue = 0;
    }

    private boolean checkBotRow() {
        if (rowCount > matrixRowSize - 2) {
            return false;
        }

        boolean haveBotRow = true;
        for (int i = startCol; i < colCount; i++) {
            if (myArrayMatrix[rowCount + 1][i] != cellValue) {
                haveBotRow = false;
            }
        }

        if (rowCount > matrixRowSize - 1) {
            haveBotRow = false;
        } else {
            rowCount++;
        }

        return haveBotRow;
    }

    private boolean checkRightCol() {
        if (colCount > matrixColSize - 2) {
            return false;
        }

        boolean haveRightCol = true;
        for (int i = startRow; i < rowCount; i++) {
            if (myArrayMatrix[i][colCount + 1] != cellValue) {
                haveRightCol = false;
            }
        }


        if (colCount > matrixColSize - 1) {
            haveRightCol = false;
        } else {
            colCount++;
        }

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
        int startX;
        int startY;
        int rowSize;
        int colSize;
        int value;

        public MyMatrix() {

        }

        public MyMatrix(int startX, int startY, int row, int col, int value) {
            this.startX = startX;
            this.startY = startY;
            this.rowSize = row;
            this.colSize = col;
            this.value = value;
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
