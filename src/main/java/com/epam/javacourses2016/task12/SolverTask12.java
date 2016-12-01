package com.epam.javacourses2016.task12;

import java.util.ArrayList;
import java.util.Comparator;
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
    static List<Integer> transform(List<Integer> integers, int value) {
        if (integers.contains(value)) {
            integers.sort(Comparator.naturalOrder());
        }
        return integers;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 5; i >= 0; i--) {
            list.add(i*i);
        }
        list.add(16);
        System.out.println(list);
        System.out.println(transform(list, 16));
    }
}
