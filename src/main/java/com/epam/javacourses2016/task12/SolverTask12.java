package com.epam.javacourses2016.task12;

import java.util.ArrayList;
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
//        int smallerCount = 0;
//        for (Integer integer : integers) {
//            if (integer < value) {
//                smallerCount++;
//            }
//        }
//        for (int i = 0; i < integers.size(); i++) {
//            if (integers.get(i) >= value) {
//                for (int j = smallerCount; j < integers.size(); j++) {
//                    if (integers.get(j) < value) {
//                        Collections.swap(integers, i, j);
//                    }
//                }
//            }
//        }
        integers.sort((integer, o2) -> integer.compareTo(value));
        return integers;
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 5; i >= 0; i--) {
            integers.add(i*i);
        }
        System.out.println(integers);
        System.out.println(transform(integers, 25));
    }
}
