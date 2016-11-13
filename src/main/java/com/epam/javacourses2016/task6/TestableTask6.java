package com.epam.javacourses2016.task6;

import java.util.HashMap;

/**
 * Интерфейс для юнит-тестирования задания №6.
 *
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочления, ключи для которых отсутствуют в карте, равны нулю.
 */
public interface TestableTask6 {

    /**
     * Осуществляет сложение двух многочленов.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second);
}
