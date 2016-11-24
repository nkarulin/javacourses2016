package com.epam.javacourses2016.task5;

import java.math.BigDecimal;
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
        // TODO: BigDecimal
        int size = measurements.size();
        double sumCurrent = 0;
        double sumVoltage = 0;
        for (int i = 0; i < size; i++) {
            sumCurrent += measurements.get(i).getCurrent();
            sumVoltage += measurements.get(i).getVoltage();
        }
        double avgCurrent = sumCurrent / size;
        double avgVoltage = sumVoltage / size;

        double numerator = 0;
        double denominator = 0;
        for (int i = 0; i < size; i++) {
            numerator += (measurements.get(i).getCurrent() - avgCurrent) * (measurements.get(i).getVoltage() - avgVoltage);
            denominator += Math.pow((measurements.get(i).getCurrent() - avgCurrent),2);
        }
        return numerator / denominator;
    }
}
