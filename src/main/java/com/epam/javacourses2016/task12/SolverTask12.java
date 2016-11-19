package com.epam.javacourses2016.task12;

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

        for (int i = 0; i < integers.size(); i++) {
            for (int j = 0; j < integers.size() - i - 1; j++) {
                if (integers.get(j) > integers.get(j + 1)) {
                    /*
                    int x = integers.get(j);
                    int y = integers.get(j + 1);
                    x = x - y;
                    y = y + x;
                    x = y - x;
                    integers.set(j, x);
                    integers.set(j + 1, y);
                    */
                    integers.set(j, integers.get(j) - integers.get(j + 1));
                    integers.set(j + 1, integers.get(j + 1) + integers.get(j));
                    integers.set(j, integers.get(j + 1) - integers.get(j));
                }
            }
        }

        return integers;
    }
}
