package com.epam.javacourses2016.task5;

import java.util.List;
import java.math.BigDecimal;

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
        double sum1 = 0;
        double sum2 = 0;
        sum1 = measurements.stream().mapToDouble((m) -> m.getCurrent() * m.getVoltage()).sum();
        sum2 = measurements.stream().mapToDouble((m) -> m.getCurrent() * m.getCurrent()).sum();
        if (sum2 == 0){
            return 0;
        } else {
            return sum1/sum2;
        }
    }
}
