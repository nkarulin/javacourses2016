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
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer,Integer> resMap = new HashMap<>();
        first.forEach(resMap::put);
        second.forEach((k,v) -> {
            if(resMap.containsKey(k)) {
                resMap.put(k,resMap.get(k) + v);
            } else {
                resMap.put(k,v);
            }
        });
        return resMap;
    }
}
