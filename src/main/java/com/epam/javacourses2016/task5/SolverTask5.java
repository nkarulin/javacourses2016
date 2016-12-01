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
        //TODO
        int totalMeas = measurements.size();

        BigDecimal totalCur = BigDecimal.ZERO;
        BigDecimal averageCur;
        BigDecimal totalVol = BigDecimal.ZERO;
        BigDecimal averageVol;
        for (Measurement measurement : measurements) {
            totalCur = totalCur.add(BigDecimal.valueOf(measurement.getCurrent()));
            totalVol = totalVol.add(BigDecimal.valueOf(measurement.getVoltage()));
        }
        averageCur = totalCur.divide(BigDecimal.valueOf(totalMeas));
        averageVol = totalVol.divide(BigDecimal.valueOf(totalMeas));
        BigDecimal numerator = BigDecimal.ZERO;
        BigDecimal denominator = BigDecimal.ZERO;
        for (Measurement measurement : measurements) {
            BigDecimal tmpVolt = BigDecimal.valueOf(measurement.getVoltage());
            BigDecimal tmpCur = BigDecimal.valueOf(measurement.getCurrent());
            numerator = numerator.add(((tmpCur.subtract(averageCur)).multiply(tmpVolt.subtract(averageVol))));
            denominator = denominator.add((tmpCur.subtract(averageCur)).pow(2));
        }
        return (numerator.divide(denominator, 3, BigDecimal.ROUND_HALF_UP)).doubleValue();
    }
}
