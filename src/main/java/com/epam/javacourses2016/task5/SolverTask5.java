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
        if (measurements.isEmpty()) {
            return 0.0;
        }

        double sumXX = 0;
        double sumXY = 0;
        double sumX = 0;
        double sumY = 0;

        for (int i = 0; i < measurements.size(); i++) {
            sumXX += measurements.get(i).getCurrent() * measurements.get(i).getCurrent();
            sumXY += measurements.get(i).getCurrent() * measurements.get(i).getVoltage();
            sumX += measurements.get(i).getCurrent();
            sumY += measurements.get(i).getVoltage();
        }

        if (sumX == 0) {
            return 0.0;
        }

        BigDecimal result = new BigDecimal((measurements.size() * sumXY - sumX * sumY) / (measurements.size() * sumXX - sumX * sumX));
        return result.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
