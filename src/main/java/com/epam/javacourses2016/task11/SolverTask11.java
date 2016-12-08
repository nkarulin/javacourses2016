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
        int i = 0;
        while (peoples.size() > 1) {
            peoples.remove(i);
            i++;

            if (i == peoples.size()) {
                i = 0;
            }
            if (i > peoples.size()) {
                i = 1;
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
        boolean first = true;
        while (peoples.size() > 1) {
            int size = peoples.size();
            ListIterator<String> iterator = peoples.listIterator();
            if (first) {
                iterator.next();
                iterator.remove();
            }
            while (iterator.hasNext()) {
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    if (!iterator.hasNext()) first = false;
                } else {
                    first = true;
                }
            }
        }
        return peoples.getFirst();
    }
}