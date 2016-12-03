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

        if (peoples == null || peoples.size() == 0) {
            throw new NullPointerException();
        }

        int index = 0;
        while (peoples.size() != 1) {
            index += 1;
            if (index >= peoples.size()) {
                index = index % 2;
            }
            peoples.remove(index);
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

        /*
        Bad way - this will be n^2, because peoples.get(i) will iterate through all peoples(before i)
        to find i element, that's why i using iterator here.
        for (int i = 0; i < peoples.size(); i++) {
            peoples.get(i);
        }
        */

        if (peoples == null || peoples.size() == 0) {
            throw new NullPointerException();
        }

        int index = 0;
        ListIterator iterator = peoples.listIterator();
        iterator.next();

        while (peoples.size() != 1) {
            iterator.next();
            index++;

            //If we out of range - recreate iterator and move it for zero[0] o first[1] element
            if (index >= peoples.size()) {
                index = index % 2;
                iterator = peoples.listIterator();
                iterator.next();
                if (index == 1) {
                    iterator.next();
                }
            }

            iterator.remove();
        }
        return peoples.get(0);
    }
}
