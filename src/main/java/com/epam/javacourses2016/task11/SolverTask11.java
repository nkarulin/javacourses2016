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
        int counter = 0;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (counter % 2 == 0) {
                iterator.remove();
            }
            else
            {
                counter++;
            }
            if (!iterator.hasNext()){
                iterator = peoples.iterator();
            }
            else{
                iterator.next();
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
        return null;
    }
}
