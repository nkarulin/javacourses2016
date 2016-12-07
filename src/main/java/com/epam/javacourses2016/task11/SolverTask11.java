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
     * @param people Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(ArrayList<String> people) {
        int passes = 2;
        int person = 0;
        while (people.size() > 1) {
            people.remove(person);
            person = (person + passes - 1) % people.size();
        }
        return people.get(0);

    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     *
     * @param people Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(LinkedList<String> people) {
        int numberOfPeople = people.size();
        int peopleRemaining = numberOfPeople;
        ListIterator listIterator = people.listIterator();
        while (peopleRemaining-- > 1) {
            if (!listIterator.hasNext()) {
                listIterator = people.listIterator();
            }
            listIterator.next();
            listIterator.remove();
            if (!listIterator.hasNext()) {
                listIterator = people.listIterator();
            }
            listIterator.next();
        }
        listIterator = people.listIterator();
        return (String) listIterator.next();
    }
}




