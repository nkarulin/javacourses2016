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
        int size = peoples.size();
        if (peoples.size() % 2 != 0) {
            while (peoples.size() > 1) {
                peoples.remove(size % peoples.size());
            }
        }
        else {
            while (peoples.size() > 1) {
                peoples.remove(size % peoples.size());
                if (peoples.size() == size / 2) {
                    size = peoples.size();
                }
            }
        }
        return peoples.get(0);
    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public static String emulate(LinkedList<String> peoples) {
        int i = 0;
        int size = peoples.size();
        while (peoples.size() > 1) {
            peoples.remove(i);
            i++;
            if (i >= peoples.size()) {
                if (size % 2 == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
        }
        return peoples.get(0);
    }
}
