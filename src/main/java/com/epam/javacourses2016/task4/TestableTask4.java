package com.epam.javacourses2016.task4;

import java.util.Set;

/**
 * Интерфейс для юнит-тестирования задания №4.
 * Определить множество на основе множества целых чисел.
 * Создать методы для определения пересечения и объединения множеств.
 * Запрещена модификация исходных множеств.
 */
public interface TestableTask4 {

    /**
     * Операция пересечения целочисленных множеств.
     * @param first Первое множество.
     * @param second Второе множество.
     * @return Результат пересечения множеств.
     */
    Set<Integer> intersection(Set<Integer> first, Set<Integer> second);

    /**
     * Операция объединения целочисленных множеств.
     * @param first Первое множество.
     * @param second Второе множество.
     * @return Результат объединения множеств.
     */
    Set<Integer> union(Set<Integer> first, Set<Integer> second);
}
