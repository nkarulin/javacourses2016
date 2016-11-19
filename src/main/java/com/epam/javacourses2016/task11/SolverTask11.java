package com.epam.javacourses2016.task11;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * В кругу стоят N человек.
 * На каждой итерации цикла выбывает человек (через одного, начиная с первого), пока не останется единственный.
 * Разработать два решения, моделирующие процесс.
 * Первое должно использовать класс ArrayList, а второе – LinkedList.
 */
public class SolverTask11 {

    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public static String emulate(ArrayList<String> peoples) {
        while (peoples.size() != 1) {
            for (int i = 0; i < peoples.size(); i++) {
                peoples.remove(i);
            }
        }
        return peoples.get(peoples.size()-1);
    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public static String emulate(LinkedList<String> peoples) {
        while (peoples.size() != 1) {
            for (int i = 0; i < peoples.size(); i++) {
                peoples.remove(i);
            }
        }
        return peoples.get(peoples.size()-1);
    }
}
