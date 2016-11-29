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
    public String emulate(ArrayList<String> peoples) {

        int[] visited = new int[peoples.size()];
        String last = null;
        int i = 0;
        int iterationNumbers = 2;
        while(iterationNumbers > 0) {
            if (i >= peoples.size()) {
                i = 1;
                iterationNumbers--;
            }
            if (visited[i] != 1) {
                last = peoples.get(i);
                visited[i] = 1;
            }
            i+=2;
        }
        return last;
    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(LinkedList<String> peoples) {
        String last = null;
        while(peoples.iterator().hasNext()) {
            peoples.iterator().next();
            last = peoples.iterator().next();
            peoples.iterator().remove();
        }
        return last;
    }
}
