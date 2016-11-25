package com.epam.javacourses2016.task12;

import java.util.Collections;
import java.util.List;

/**
 * Задан список целых чисел и число X.
 * Не используя вспомогательных объектов и не изменяя размера списка,
 * переставить элементы списка так, чтобы сначала шли числа, не превосходящие X, а затем числа, большие X.
 */
public class SolverTask12 {

    /**
     * Преобразует целочисленный список таким образом, чтобы сначала шли числа меньшие value, затем большие.
     *
     * @param integers Целочисленный список.
     * @param value    Разделительное значение.
     * @return Преобразованный список.
     */
    List<Integer> transform(List<Integer> integers, int value) {
        int indexStart = integers.size() - 1;

        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > value) {
                for (int j = indexStart; j >= i; j--) {
                    if (integers.get(j) <= value) {
                        indexStart--;
                        Collections.swap(integers, i, j);
                        break;
                    }
                }
            }
        }

        //Bubble Sort could solve this problem, so here we go!
        /*
        for (int i = 0; i < integers.size(); i++) {
            for (int j = 0; j < integers.size() - i - 1; j++) {
                if (integers.get(j) > integers.get(j + 1)) {
                    Collections.swap(integers, j+1,j);
                }
            }
        }*/

        return integers;
    }
}
