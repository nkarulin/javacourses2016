package com.epam.javacourses2016.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(second);
        for (int i = 0; i < result.size(); ++i){
            result.set(i, (result.get(i) * first.get(0)));
        }
        for (int i = 1; i < first.size(); ++i) {
            ArrayList<Integer> subResult = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                subResult.add(0);
            }
            for (int j = 0; j < second.size(); ++j) {
                subResult.add(first.get(i) * second.get(j));
            }
            for (int j = 0; j < result.size(); ++j) {
                result.set(j, (result.get(j) + subResult.get(j)));
            }
            result.add(subResult.get(subResult.size() - 1));
        }

        return result;
    }
}
