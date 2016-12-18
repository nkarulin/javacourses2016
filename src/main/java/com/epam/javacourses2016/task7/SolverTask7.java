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
        int[] f = first.stream().mapToInt(i -> i).toArray();
        int[] s = second.stream().mapToInt(i -> i).toArray();
        int[] res = new int[first.size() + second.size()-1];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < s.length; j++) {
            res[i+j]+=f[i]*s[j];
            }
        }
        Collections.addAll(result, Arrays.stream(res).boxed().toArray(Integer[]::new));
        return result;
    }
}
