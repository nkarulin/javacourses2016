package com.epam.javacourses2016.task12;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
        LinkedList<Integer> sortedList = new LinkedList<>();
        for (Integer listValue : integers) {
            if (listValue > value) {
                sortedList.addLast(listValue);
            } else {
                sortedList.addFirst(listValue);
            }
        }
        return sortedList;
    }
}
