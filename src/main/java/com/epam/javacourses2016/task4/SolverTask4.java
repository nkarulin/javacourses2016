package com.epam.javacourses2016.task4;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/**
 * Интерфейс для юнит-тестирования задания №4.
 * Определить множество на основе множества целых чисел.
 * Создать методы для определения пересечения и объединения множеств.
 * Запрещена модификация исходных множеств.
 */
public class SolverTask4 {

    /**
     * Операция пересечения целочисленных множеств.
     * @param first Первое множество.
     * @param second Второе множество.
     * @return Результат пересечения множеств.
     */
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }

    /**
     * Операция объединения целочисленных множеств.
     * @param first Первое множество.
     * @param second Второе множество.
     * @return Результат объединения множеств.
     */
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> union = new HashSet<>();
        union.addAll(first);
        union.addAll(second);
        return union;
    }
}
