package com.epam.javacourses2016.task12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
        int count = 0;
        for (Integer n : integers) {
            if (n < value) {
                count++;
            }
        }
        for (int j = 0; j < integers.size(); j ++) {
            if (integers.get(j) < value && j >= count-1) {
                for (int i = 0; i < count; i++) {
                    if (integers.get(i) > value) {
                        Collections.swap(integers, j, i);
                        break;
                    }
                }
            }
            else if (integers.get(j) >= value && j <= count-1) {
                for (int i = count; i < integers.size(); i++) {
                    if (integers.get(i) < value) {
                        Collections.swap(integers, j, i);
                        break;
                    }
                }
            }
        }
        return integers;
    }
}
