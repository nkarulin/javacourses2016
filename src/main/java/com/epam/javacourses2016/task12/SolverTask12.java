package com.epam.javacourses2016.task12;

import java.util.ArrayList;
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
        for (int i = 0; i < integers.size(); ++i){
            if (integers.get(i) <= value) {
                for (int j = 0; j < integers.size(); ++j) {
                    if ((integers.get(j) > value) && ( j < i)) {
                        Integer a = new Integer(integers.get(i));
                        integers.set(i, integers.get(j));
                        integers.set(j, a);
                    }
                }
            }
        }
        return integers;
    }
}
