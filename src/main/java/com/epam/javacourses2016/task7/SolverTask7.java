package com.epam.javacourses2016.task7;

import java.util.*;

/**
 * Умножить два многочлена заданной степени, если коэффициенты многочленов хранятся в различных списках.
 * Элемент списка с индексом i соответствует коэффициенту i-й степени.
 * Степень результирующего многочлена равна сумме максимальных ненулевых степеней исходных многочленов.
 * Случай, когда многочлен вырождается в 0 описывается состоянием [0].
 */
public class SolverTask7 {

    /**
     * Осуществляет перемножение двух многочленов.
     *
     * @param first  Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате перемножения.
     */
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mapPowVal = new HashMap<>();
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                int power = i + j;
                int coefficient = first.get(i) * second.get(j);
                if (mapPowVal.containsKey(power)) {
                    mapPowVal.put(power, mapPowVal.get(power) + coefficient);
                } else {
                    mapPowVal.put(power, coefficient);
                }
            }
        }

        int maxPower = Collections.max(mapPowVal.keySet());
        for (int i = 0; i <= maxPower; i++) {
            result.add(mapPowVal.get(i));
        }

        return result;
    }
}
