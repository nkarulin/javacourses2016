package com.epam.javacourses2016.task6;

import java.util.HashMap;
import java.util.Map;

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

        for (Map.Entry<Integer, Integer> entry : first.entrySet()) {
            if (second.containsKey(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue() + second.get(entry.getKey()));
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            if (!first.containsKey(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }
}
