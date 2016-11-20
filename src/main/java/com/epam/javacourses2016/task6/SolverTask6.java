package com.epam.javacourses2016.task6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочления, ключи для которых отсутствуют в карте, равны нулю.
 */
public class SolverTask6 {

    /**
     * Осуществляет сложение двух многочленов.
     *
     * @param first  Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int firstKey : first.keySet()) {
            result.put(firstKey, first.get(firstKey) + second.get(firstKey));
        }
        for (int secondKey : second.keySet()) {
            if (!first.containsKey(secondKey)) result.put(secondKey, second.get(secondKey));
        }
        return result;
    }

}
