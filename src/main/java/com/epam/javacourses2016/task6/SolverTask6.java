package com.epam.javacourses2016.task6;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочления, ключи для которых отсутствуют в карте, равны нулю.
 */
public class SolverTask6 {

    /**
     * Осуществляет сложение двух многочленов.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> polySum = new HashMap<>();
        Set<Integer> keys = first.keySet().stream().collect(Collectors.toSet());
        keys.addAll(second.keySet());
        for(Integer key : keys) {

            boolean firstContains = first.containsKey(key);
            boolean secondContains =  second.containsKey(key);

            if (firstContains && secondContains) {
                polySum.put(key, first.get(key) + second.get(key));
            } else if (firstContains && !secondContains) {
                polySum.put(key, first.get(key));
            } else if (secondContains && !firstContains) {
                polySum.put(key, second.get(key));
            }
        }
        return polySum;
    }
}
