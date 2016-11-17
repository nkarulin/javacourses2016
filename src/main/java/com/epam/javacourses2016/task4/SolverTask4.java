package com.epam.javacourses2016.task4;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //TODO
        Set<Integer> interSet = first.stream()
                                .filter(second::contains)
                                .collect(Collectors.toSet());
        return interSet;
    }

    /**
     * Операция объединения целочисленных множеств.
     * @param first Первое множество.
     * @param second Второе множество.
     * @return Результат объединения множеств.
     */
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        //TODO
        Set<Integer> unionSet = Stream.concat(first.stream(), second.stream()).collect(Collectors.toSet());
        return unionSet;
    }
}
