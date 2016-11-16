package com.epam.javacourses2016.task5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
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
        BigDecimal Syx = new BigDecimal(0);
        for (Measurement measurement : measurements) {
            Syx = Syx.add(new BigDecimal(measurement.getCurrent()*measurement.getVoltage()));
        }
        BigDecimal Sxx = new BigDecimal(0);
        for (Measurement measurement : measurements) {
            Sxx = Sxx.add(new BigDecimal(measurement.getCurrent()*measurement.getCurrent()));
        }
        BigDecimal R = Syx.divide(Sxx,6);
        return R.doubleValue();
    }
}
