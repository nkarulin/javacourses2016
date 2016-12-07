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
        BigDecimal numerator = BigDecimal.ZERO;
        BigDecimal denominator = BigDecimal.ZERO;
        for (Measurement measurement : measurements) {
            double tmpCur = measurement.getCurrent();
            double tmpVolt = measurement.getVoltage();
            numerator = numerator.add(BigDecimal.valueOf(tmpCur * tmpVolt));
            denominator = denominator.add(BigDecimal.valueOf(tmpCur * tmpCur));
        }
        BigDecimal result = numerator.divide(denominator, 3, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }
}
