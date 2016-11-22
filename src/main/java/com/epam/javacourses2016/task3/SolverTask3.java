package com.epam.javacourses2016.task3;

import java.util.*;

/**
 * Занести строки, составляющие стихотворения указанного автора, в список.
 * Провести сортировку по возрастанию длин строк.
 */
public class SolverTask3 {

    /**
     * Формирует упорядоченный список строк из стихотворений указанного автора.
     *
     * @param poems  Анализируемое множество стихотворений.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @return Список, упорядоченных по длине строк, составляющих стихотворения автора.
     */
    public List<String> sortPoems(Set<Poem> poems, String author) {
        List<String> authorLines = new ArrayList<>();

        for (Poem poem : poems) {
            if (Objects.equals(poem.getAuthor(), author)) {
                authorLines.addAll(poem.getLines());
            }
        }

        List<String> sortedLines = sortLines(authorLines);
        return sortedLines;
    }

    private List<String> sortLines(List<String> lines) {
        Collections.sort(lines, new MyStringComparator());
        return lines;
    }

    private class MyStringComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }
}
