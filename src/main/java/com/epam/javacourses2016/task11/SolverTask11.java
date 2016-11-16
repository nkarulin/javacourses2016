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
        for (int i = 0; i < peoples.size(); i+=2) {
            peoples.remove(i);
        }
        return peoples.get(peoples.size());
    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public static String emulate(LinkedList<String> peoples) {
        for (int i = 0; i < peoples.size(); i+=2) {
            peoples.remove(i);
        }
        return peoples.get(peoples.size());
    }

    public static void main(String[] args) {
        ArrayList<String> ppl = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ppl.add("3"+i);
        }
        LinkedList<String> ppl1 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ppl1.add("4"+i);
        }
        System.out.println(emulate(ppl));
        System.out.println(emulate(ppl1));
    }
}
