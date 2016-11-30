package com.epam.javacourses2016.task12;

import java.util.Comparator;
import java.util.List;

/**
 * Задан список целых чисел и число X.
 * Не используя вспомогательных объектов и не изменяя размера списка,
 *    переставить элементы списка так, чтобы сначала шли числа, не превосходящие X, а затем числа, большие X.
 */
public class SolverTask12 {

    /**
     * Преобразует целочисленный список таким образом, чтобы сначала шли числа меньшие value, затем большие.
     * @param integers Целочисленный список.
     * @param value Разделительное значение.
     * @return Преобразованный список.
     */
    List<Integer> transform(List<Integer> integers, int value) {
        final int val = value;
        integers.stream().sorted((item1, item2) -> item1  < val && item2 < val ? 0 :
                                                    item1 < val && item2 > val ? -1:
                                                        1);
        return integers;
    }
}
