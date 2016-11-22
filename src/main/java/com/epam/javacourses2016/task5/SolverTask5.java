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
        /*
        double a;
        double b;
        a = ((measureCount * xySum) - (xSum * ySum)) / (measureCount * xSqrSum - xSum * xSum);
        b = (ySum - a * xSum) / measureCount;
        */

        BigDecimal aBig;
        BigDecimal bBig;
        aBig = new BigDecimal((measureCount * xySum - (xSum * ySum)) / (measureCount * xSqrSum - xSum * xSum));
        bBig = BigDecimal.valueOf(ySum).subtract(aBig.multiply(BigDecimal.valueOf(xSum)))
                .divide(BigDecimal.valueOf(measureCount), RoundingMode.CEILING);

        //double e = 0;
        BigDecimal eBig = BigDecimal.ZERO;
        for (Measurement measure : measurements) {
            /*
            double func = measure.getVoltage() - (a * measure.getCurrent() + b);
            e += Math.pow(func, 2);
            */

            BigDecimal funcBig = BigDecimal.valueOf(measure.getVoltage())
                    .subtract(aBig.multiply(BigDecimal.valueOf(measure.getCurrent())).add(bBig));
            eBig = eBig.add(funcBig.pow(2));
        }

        return eBig.doubleValue();
    }
}
