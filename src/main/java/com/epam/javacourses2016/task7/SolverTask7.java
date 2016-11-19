package com.epam.javacourses2016.task7;

import java.util.ArrayList;
import java.util.List;

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
        int maxPow = (first.size() - 1) + (second.size() - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxPow; i++) {
            result.add(i, 0);
        }
        for (int i = first.size() - 1; i >= 0; i--) {
            for (int j = second.size() - 1; j >= 0; j--) {
                int pow = (i + j) - 1;
                if ((i+j) == 0) {
                    pow = 0;
                }
                if (result.get(pow) == 0) {
                    result.remove(pow);
                    result.add(pow, first.get(i) * second.get(j));
                }
                else {
                    int tempCoef = result.get(pow);
                    result.remove(pow);
                    result.add(pow, tempCoef + first.get(i) * second.get(j));
                }
            }
        }
        return result;
    }
}
