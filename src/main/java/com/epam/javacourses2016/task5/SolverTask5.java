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
            return 0;
        }
        int allMeasurements = measurements.size();
        BigDecimal numerator = BigDecimal.ZERO;
        BigDecimal denominator = BigDecimal.ZERO;
        BigDecimal sumCur = BigDecimal.ZERO;
        BigDecimal sumVolt = BigDecimal.ZERO;
        for (Measurement measurement : measurements) {
            double tmpCur = measurement.getCurrent();
            double tmpVolt = measurement.getVoltage();
            sumCur = sumCur.add(BigDecimal.valueOf(tmpCur));
            sumVolt = sumVolt.add(BigDecimal.valueOf(tmpVolt));
        }
        BigDecimal averageCur = sumCur.divide(BigDecimal.valueOf(allMeasurements), BigDecimal.ROUND_HALF_UP);
        BigDecimal averageVolt = sumVolt.divide(BigDecimal.valueOf(allMeasurements), BigDecimal.ROUND_HALF_UP);
        for (Measurement measurement : measurements) {
            double tmpCur = measurement.getCurrent();
            double tmpVolt = measurement.getVoltage();
            BigDecimal curDiff = BigDecimal.valueOf(tmpCur).subtract(averageCur);
            BigDecimal voltDiff = BigDecimal.valueOf(tmpVolt).subtract(averageVolt);
            numerator = numerator.add(curDiff.multiply(voltDiff));
            denominator = denominator.add(curDiff.multiply(curDiff));
        }
        if (BigDecimal.ZERO.compareTo(denominator) == 0) {
            return 0;
        }
        BigDecimal result = numerator.divide(denominator, 3, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }
}
