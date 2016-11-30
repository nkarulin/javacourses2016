package com.epam.javacourses2016.task6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        ArrayList<Integer> firstKeys = new ArrayList<>();
        ArrayList<Integer> secondKeys = new ArrayList<>();
        firstKeys.addAll(first.keySet());
        secondKeys.addAll(second.keySet());
        List<Integer> sameKeys = firstKeys.stream()
                .filter(secondKeys::contains)
                .collect(Collectors.toList());

        secondKeys.removeAll(firstKeys);
        for (Integer secondKey : secondKeys) {
            result.put(secondKey, second.get(secondKey));
        }

        firstKeys.removeAll(secondKeys);
        for (Integer firstKey : firstKeys) {
            result.put(firstKey, first.get(firstKey));
        }

        for (Integer key : sameKeys) {
            Integer sumValues = first.get(key) + second.get(key);
            result.put(key, sumValues);
        }
        return result;
    }
}
