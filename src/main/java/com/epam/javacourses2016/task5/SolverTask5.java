package com.epam.javacourses2016.task5;


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
        Double sumXi = 0.0;
        Double sumYi= 0.0;
        Double sumXiYi= 0.0;
        Double sumSqrXi= 0.0;
        for (Measurement measurement : measurements) {
            sumXi += measurement.getCurrent();
            sumYi += measurement.getVoltage();
            sumXiYi += measurement.getCurrent()*measurement.getVoltage();
            sumSqrXi += measurement.getCurrent()*measurement.getCurrent();
        }
        int n = measurements.size();
        Double x = 0.0;
        Double y = 0.0;
        if ((sumSqrXi*n)-(sumXi*sumXi) != 0) {
            x = ((sumXiYi*n)-(sumXi*sumYi))/((sumSqrXi*n)-(sumXi*sumXi));
            y = ((sumSqrXi*sumYi)-(sumXiYi*sumXi))/((sumSqrXi*n)-(sumXi*sumXi));
        }
        Double e = 0.0;
        for (Measurement measurement : measurements) {
            e += Math.pow(((measurement.getVoltage())-(optimalFuncValue(measurement.getCurrent(),x,y))),2);
        }
        return round(e, 3);
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private static Double optimalFuncValue(Double x, Double coef1, Double coef2) {
        return coef1*x+coef2;
    }

}
