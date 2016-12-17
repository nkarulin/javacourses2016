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

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                if(result.size()<=i+j)result.add(i+j, first.get(i)*second.get(j));
                else result.set(i+j, result.get(i+j) + first.get(i)*second.get(j));
            }
        }
        return result;
    }
}
