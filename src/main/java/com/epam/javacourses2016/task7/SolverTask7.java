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

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                int pow = i + j;
                int coeff = first.get(i) * second.get(j);

                if (map.containsKey(pow)) {
                    int val = map.get(pow);
                    map.put(pow, val + coeff);
                } else {
                    map.put(pow, coeff);
                }
            }
        }

        Set<Integer> keyset = map.keySet();
        int maxPow = Collections.max(map.keySet());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i <= maxPow; i++) {
            list.add(map.get(i));
        }

        return list;
    }
}
