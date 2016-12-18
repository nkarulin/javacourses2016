package com.epam.javacourses2016.task5;

import java.math.BigDecimal;
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

        if (measurements.isEmpty()) {
            return 0.0;
        }

        double sXX = 0;
        double sXY = 0;
        double sX = 0;
        double sY = 0;

        for (int i = 0; i < measurements.size(); i++) {
            sXX += measurements.get(i).getCurrent() * measurements.get(i).getCurrent();
            sXY += measurements.get(i).getCurrent() * measurements.get(i).getVoltage();
            sX += measurements.get(i).getCurrent();
            sY += measurements.get(i).getVoltage();
        }
        if (sX == 0) {
            return 0.0;
        }

        BigDecimal result = new BigDecimal((measurements.size() * sXY - sX * sY) / (measurements.size() * sXX - sX * sX));
        return result.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
