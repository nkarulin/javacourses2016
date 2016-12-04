package com.epam.javacourses2016.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Занести строки, составляющие стихотворения указанного автора, в список.
 * Провести сортировку по возрастанию длин строк.
 */
public class SolverTask3 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     * @param poems Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    public List<String> sortPoems(Set<Poem> poems, String author) {
        List<String> stringList = new ArrayList<>();
        for(Poem  p : poems) {
            if(p.getAuthor().equals(author)) {
                stringList.addAll(p.getLines());
            }
        }
        Collections.sort(stringList,new MyComparator());
        return stringList;
    }

    class MyComparator implements java.util.Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}
