package com.epam.javacourses2016.task12;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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

        LinkedList<Integer> sortedList = new LinkedList<>();

        ListIterator<Integer> iterator = integers.listIterator();
        while (iterator.hasNext()) {
            int listValue = iterator.next();

            if (listValue > value) {
                sortedList.addLast(listValue);
            } else {
                sortedList.addFirst(listValue);
            }
        }

        //Collection sort could solve this problem, so here we go!
        //Collections.sort(integers);
        return sortedList;
    }
}
