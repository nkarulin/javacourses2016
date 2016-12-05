package com.epam.javacourses2016.task11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

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
    public String emulate(ArrayList<String> peoples) {
        int i = 0;
        while (peoples.size() != 1) {
            peoples.remove(i);
            if(i >= peoples.size()-1)
                i = 0;
            else i++;
        }
        return peoples.get(0);
    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(LinkedList<String> peoples) {
        int i = 0;
        ListIterator iterator = peoples.listIterator();
        while (peoples.size() != 1) {
            iterator.next();
            iterator.remove();
            i++;
            if (i >= peoples.size()) {
                i = 0;
                iterator = peoples.listIterator();
            } else {
                iterator.next();
            }

        }
        return peoples.get(0);
    }
}
