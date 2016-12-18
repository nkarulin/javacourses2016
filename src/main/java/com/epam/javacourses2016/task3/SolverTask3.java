package com.epam.javacourses2016.task3;

import java.util.*;

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
        ArrayList<String> sortedLines = new ArrayList<>();
        poems.stream().forEach((poem) -> {
            if (poem.getAuthor().equals(author)){
                sortedLines.addAll(poem.getLines());
            }
        });
        Collections.sort(sortedLines, new MyComparator());
        return sortedLines;
    }

    private class MyComparator implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.length() - s2.length();
        }
    }
}
