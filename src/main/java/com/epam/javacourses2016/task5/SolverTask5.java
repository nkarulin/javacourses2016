package com.epam.javacourses2016.task5;

import java.math.RoundingMode;
import java.util.List;
import java.math.BigDecimal;

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
     * y=kx=> I=U/R or U=R*I, then y=U and x=I
     * and because k=(E(xi*yi))/E(xi^2)
     * R=(E(I*U))/E(I^2)
     *
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    double calcResistance(List<Measurement> measurements) {
        BigDecimal numerator = new BigDecimal(0);
        BigDecimal denominator = new BigDecimal(0);
        for (Measurement measure : measurements) {
            numerator=numerator.add(BigDecimal.valueOf(measure.getVoltage()*measure.getCurrent()));
            denominator=denominator.add(BigDecimal.valueOf(measure.getCurrent()*measure.getCurrent()));
        }

        return numerator.divide(denominator,3, RoundingMode.HALF_UP).doubleValue();

    }
}
