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

    double currentSquareSum = 0;
    double resistanceSum = 0;
    double currentSum = 0;
    double voltageSum = 0;

    private BigDecimal lsm(int N) {

        if (currentSum == 0) {
            return BigDecimal.valueOf(0);
        }

        BigDecimal result = new BigDecimal((N * resistanceSum - currentSum * voltageSum) /
                (N * currentSquareSum - currentSum * currentSum));
        return result;
    }
    /**
     * Вычисляет сопротивление методом наименьших квадратов.
     *
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    double calcResistance(List<Measurement> measurements) {
        if (measurements.size() < 1)
            return 0.0;

        for(Measurement measurement : measurements) {

            double current = measurement.getCurrent();
            double voltage = measurement.getVoltage();

            currentSquareSum +=  Math.pow(current, 2);
            resistanceSum += current * voltage;
            currentSum += current;
            voltageSum += voltage;
        };

        BigDecimal result = lsm(measurements.size());
        return result.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
