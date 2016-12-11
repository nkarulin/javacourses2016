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
     *
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(ArrayList<String> peoples) {
        int index = 0;
        while (peoples.size() > 1) {
            if (index >= peoples.size()) {
                index %= 2;
            }
            peoples.remove(index);
            index++;
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
        ListIterator iterator = peoples.listIterator();
        while (peoples.size() > 1) {
            if (!iterator.hasNext()) {
                iterator = peoples.listIterator();
            }
            iterator.next();
            iterator.remove();
            if (!iterator.hasNext()) {
                iterator = peoples.listIterator();
            }
            iterator.next();
        }
        return peoples.removeFirst();
    }

}
