package com.epam.javacourses2016.task11;

import java.util.*;

/**
 * В кругу стоят N человек.
 * На каждой итерации цикла выбывает человек (через одного, начиная с первого), пока не останется единственный.
 * Разработать два решения, моделирующие процесс.
 * Первое должно использовать класс ArrayList, а второе – LinkedList.
 */
public class SolverTask11 {

    private int mod(int index, int N) {
        return index > N ? index % N : index;
    }
    private int indexEven(int prevIndex, int N) {
        int ind =  prevIndex * 2;
        return mod(ind, N);
    }
    private int indexNonEven(int prevIndex, int N) {
        int ind = prevIndex * 2 + 2;
        return mod(ind, N);
    }
    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */
    public String emulate(ArrayList<String> peoples) {

        int N = peoples.size();
        int index = 1;
        int step = 1;
        int i = 1;
        boolean prevEven = peoples.size() % 2 == 0;

        while(N > 2) {

            prevEven = N % 2 == 0;
            index += prevEven || N == 3 ?
                    step : 3 * step;// indexEven(index, peoples.size()) : indexNonEven(index, peoples.size());

            N /= 2;
            step *= 2;
        }
        if (N == 2) {
            index = !prevEven ? index - step : index + step;
        }
        return peoples.get(index - 1);
    }
    /**
     * Выполняет эмуляцию поставленной задачи.
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */

    public String emulate(LinkedList<String> peoples) {
        String result = null;
        boolean even = true;
        while (peoples.size() > 2) {
            LinkedList<String> temp = new LinkedList<>();
            Iterator<String> iterator = even ?
                    peoples.listIterator(0) : peoples.listIterator(1);
            while(iterator.hasNext()) {
                iterator.next();
                if(iterator.hasNext())
                    temp.add(iterator.next());
            }
            if (!even)
                temp.add(peoples.iterator().next());
            even = peoples.size() % 2 == 0;
            peoples = temp;
        }
        return peoples.iterator().next();
    }
}
