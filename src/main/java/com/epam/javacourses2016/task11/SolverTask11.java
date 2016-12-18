package com.epam.javacourses2016.task11;

import java.util.ArrayList;
import java.util.Iterator;
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
        int passes = 2;
        int person = 0;
        while (peoples.size() > 1) {
            peoples.remove(person);
            person = (person + passes - 1) % peoples.size();
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
        int numberOfPeople = peoples.size();
        int peopleRemaining = numberOfPeople;
        ListIterator listIterator = peoples.listIterator();
        while (peopleRemaining-- > 1) {
            if (!listIterator.hasNext()) {
                listIterator = peoples.listIterator();
            }
            listIterator.next();
            listIterator.remove();
            if (!listIterator.hasNext()) {
                listIterator = peoples.listIterator();
            }
            listIterator.next();
        }
        listIterator = peoples.listIterator();
        return (String) listIterator.next();
    }
}
