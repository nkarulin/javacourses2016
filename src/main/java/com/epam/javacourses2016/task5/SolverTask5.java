package com.epam.javacourses2016.task5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Интерфейс для юнит-тестирования задания №5.
 * <p>
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
        if (measurements == null || measurements.size() == 0) {
            return 0;
        }

        double xSum = 0;
        double ySum = 0;
        double xSqrSum = 0;
        double xySum = 0;

        for (Measurement measure : measurements) {
            xSum += measure.getCurrent();
            ySum += measure.getVoltage();
            xSqrSum += Math.pow(measure.getCurrent(), 2);
            xySum += measure.getCurrent() * measure.getVoltage();
        }

        double measureCount = measurements.size();

        if (xSum == 0) {
            return 0;
        }

        BigDecimal aBig;
        aBig = new BigDecimal((measureCount * xySum - (xSum * ySum)) / (measureCount * xSqrSum - xSum * xSum));
        return aBig.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}
