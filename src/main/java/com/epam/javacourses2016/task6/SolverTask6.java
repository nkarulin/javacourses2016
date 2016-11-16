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
        HashMap<Integer, Integer> sum = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : first.entrySet()) {
            Integer key = entry.getKey();
            Integer secondValue = 0;

            if (second.containsKey(key)) {
                secondValue = second.get(key);
            }

            sum.put(key, entry.getValue() + secondValue);
        }

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            Integer key = entry.getKey();

            if (!first.containsKey(key)) {
                sum.put(key, entry.getValue());
            }
        }

        return sum;
    }
}
