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
        List<Integer> polynom = new ArrayList<>();
        for (int i = 0; i < first.size() + second.size() - 1; i++) {
            polynom.add(i, 0);
        }
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                polynom.set(i + j, polynom.get(i + j) + first.get(i) * second.get(j));
            }
        }
        if( polynom.stream().reduce((a,b) -> a+b).get().equals(0) )
            return new ArrayList<>();
        else return polynom;
    }
}
