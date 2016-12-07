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
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате перемножения.
     */
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {

        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> sums = new ArrayList<>();

        for(int i = 0; i < first.size(); i++) {
            for(int j = 0; j < second.size(); j++) {
                int pow = i + j;
                int rez = 0;
                rez = first.get(i) * second.get(j);

                 if (!result.containsKey(pow)) {
                    result.put(pow, rez);
                }else {
                    int prevRez = result.get(pow);
                    result.put(pow, prevRez + rez);
                 }
            }
        }

        result.keySet().stream().sorted().forEach(key -> sums.add(result.get(key)));
        return sums;
    }
}
