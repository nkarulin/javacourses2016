package com.epam.javacourses2016.task18;

import javafx.util.Pair;

import java.util.*;

/**
 * Дана матрица из целых чисел.
 * Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов.
 * Использовать стек.
 */
public class SolverTask18 {


    private class Element {
        private int i;
        private int j;
        private int value;

        public Element(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
        public int getI() {
            return this.i;
        }
        public int getJ() {
            return this.j;
        }
        public int getValue() {
            return this.value;
        }
    }
    private boolean checkIndeces(RectangularIntegerMatrix matrix, int i, int j) {
        return i < 0 || i >= matrix.getWidth() || j < 0 || j >= matrix.getHeight();
    }
    private Boolean checkNeighbour(RectangularIntegerMatrix matrix, int i, int j, int ni, int nj) {

        if (checkIndeces(matrix, ni,nj))
            return null;
        return matrix.getValue(i,j) == matrix.getValue(ni, nj);
    }

    private int getWeight(RectangularIntegerMatrix matrix, int i, int j) {
        int weight = 0;
        int prevLine = i - 1;
        int nextLine = i + 1;
        for(int k = i - 1; k <= i + 1; k++) {
            Boolean checkFirst = checkNeighbour(matrix, i, j, prevLine, k);
            Boolean checkSecond = checkNeighbour(matrix, i, j, nextLine, k);
            if (checkFirst != null && checkFirst)
                weight++;
            if (checkSecond != null && checkSecond)
                weight++;
        }

        Boolean checkLeft = checkNeighbour(matrix, i, j, i, j - 1);
        Boolean checkRight = checkNeighbour(matrix, i, j, i, j + 1);

        if (checkLeft != null && checkLeft)
            weight++;
        if (checkRight != null && checkRight)
            weight++;
        return weight;

    }

    /**
     * @param matrix Анализируемая матрица.
     * @return Подматрица, состоящая из максимального количества одинаковых элементов.
     */
    RectangularIntegerMatrix getMaxSubMatrix(RectangularIntegerMatrix matrix) {
        boolean[][] visited = new boolean[matrix.getWidth()][matrix.getHeight()];

        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Stack<Element>> elements = new HashMap<>();

        for(int i = 0; i < matrix.getHeight(); i++) {
            for(int j = 0; j < matrix.getWidth(); j++) {
                int val = matrix.getValue(i, j);
                if (!counts.containsKey(val)) {
                    counts.put(val, 1);
                    Stack<Element> s = new Stack<>();
                    s.push(new Element(i,j,val));
                    elements.put(val, s);
                } else {
                    Integer count = counts.get(val);
                    count++;
                    Stack<Element> list = elements.get(val);
                    list.push(new Element(i,j,val));
                    counts.put(val, count);
                }
            }
        }
        int maxCount = 0;
        int value = 0;

        for(Integer val : counts.keySet()) {
            if (counts.get(val) > maxCount){
                maxCount = counts.get(val);
                value = val;
            }
        }

        int iBegin = matrix.getHeight();
        int jBegin = matrix.getWidth();
        int iEnd = -1;
        int jEnd = -1;

        for(Element e : elements.get(value)) {

            if (e.getI() > iEnd)
                iEnd = e.getI();

            if (e.getJ() > jEnd)
                jEnd = e.getJ();

            if (e.getI() < iBegin)
                iBegin = e.getI();

            if (e.getJ() < jBegin)
                jBegin = e.getJ();

        }

        int[][] subMatrix = new int[iEnd - iBegin + 1][jEnd - jBegin + 1];
        for(int i = iBegin; i <= iEnd; i++) {
            for(int j = jBegin; j <= jEnd; j++) {
                subMatrix[i - iBegin][j - jBegin] = matrix.getValue(i,j);
            }
        }
        return new Matrix(subMatrix);
       /* for(int i = 0; i < matrix.getWidth(); i++) {
            double value = matrix.getValue(i,0);
            Element<Double> element = new Element<Double>(i,0, value);
            for(int j = 1; j < matrix.getHeight(); j++) {
                double curValue = matrix.getValue(i, j);
                if (curValue != value) {
                    int count;
                    for()
                /*    element.setILowRight(i);
                    element.setJLowRight(j);
                    matrices.push(element);
                    element = new Element<Double>(i, j, curValue);
                    value = curValue; */
               // }
           // }

      //  }

    }

    /**
     * Прямоугольная матрица целых чисел.
     */
    interface RectangularIntegerMatrix {

        /** @return Ширина матрицы. */
        int getWidth();

        /** @return Высота матрицы. */
        int getHeight();

        /**
         * @param indexWidth Индекс по ширине.
         * @param indexHeight Индекс по высоте.
         * @return Значение, располагающееся в указанной ячейке.
         */
        int getValue(int indexWidth, int indexHeight);
    }
}
