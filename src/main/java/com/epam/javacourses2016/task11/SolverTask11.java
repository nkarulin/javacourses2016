package com.epam.javacourses2016.task11;

import java.util.ArrayList;
import java.util.Iterator;
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
     *
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(ArrayList<String> peoples) {

        while (peoples.size() != 1) {
            Iterator iterator = peoples.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                if (index % 2 == 0) {
                    iterator.next();
                    iterator.remove();
                }
                index++;
            }
        }
        return peoples.get(0);
    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     *
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(LinkedList<String> peoples) {
        int second = 1;
        int numberOfDeletes = 0;
        while (peoples.size() > 1) {
            if (numberOfDeletes % 2 == 0) {
                peoples.removeFirst();
                numberOfDeletes++;
            } else {
                peoples.remove(second);
                numberOfDeletes++;
            }
        }
        return peoples.getFirst();
    }
}
