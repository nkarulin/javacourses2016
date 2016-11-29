package com.epam.javacourses2016.task5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Интерфейс для юнит-тестирования задания №5.
 *
 * Список содержит результаты измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 * Для повышения точности вычислений использовать класс {@link java.math.BigDecimal}
 */
public class SolverTask5 {

    /**
     * Вычисляет сопротивление методом наименьших квадратов.
     *
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    double calcResistance(List<Measurement> measurements) {
        int size = measurements.size();
        BigDecimal sumCurrent = BigDecimal.valueOf(0);
        BigDecimal sumVoltage = BigDecimal.valueOf(0);
        for (int i = 0; i < size; i++) {
            sumCurrent = sumCurrent.add(BigDecimal.valueOf(measurements.get(i).getCurrent()));
            sumVoltage = sumVoltage.add(BigDecimal.valueOf(measurements.get(i).getVoltage()));
        }
        BigDecimal avgCurrent = sumCurrent.divide(BigDecimal.valueOf(size));
        BigDecimal avgVoltage = sumVoltage.divide(BigDecimal.valueOf(size));

        BigDecimal numerator = BigDecimal.valueOf(0);
        BigDecimal denominator = BigDecimal.valueOf(0);
        for (int i = 0; i < size; i++) {
            numerator = numerator.add(((BigDecimal.valueOf(measurements.get(i).getCurrent()).subtract(avgCurrent)).multiply(BigDecimal.valueOf(measurements.get(i).getVoltage()).subtract(avgVoltage))));
            denominator = denominator.add((BigDecimal.valueOf(measurements.get(i).getCurrent()).subtract(avgCurrent)).pow(2));
        }
        double result = (numerator.divide(denominator,3, RoundingMode.HALF_UP)).doubleValue();
        return  result;
    }
}
