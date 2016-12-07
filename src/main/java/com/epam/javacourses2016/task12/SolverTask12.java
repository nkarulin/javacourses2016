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
       /*
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < integers.size() - 1; j++) {
                if (integers.get(j) > integers.get(j + 1)) {
                    if (integers.get(j) >= value) {
                        Collections.swap(integers, j, j + 1);
                        flag = true;
                    }
                }
            }
        }*/
        Collections.sort(integers);
        return integers;
    }
}