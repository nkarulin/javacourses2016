package com.epam.javacourses2016.task3;

import java.util.ArrayList;
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
        List<String> lines = new ArrayList<>();
        for (Poem p : poems) {
            if (p.getAuthor().equals(author)) {
                lines = p.getLines();
            }
        }
        for (int i = lines.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (lines.get(j).length() > lines.get(j + 1).length()) {
                    String t = lines.get(j);
                    lines.set(j, lines.get(j+1));
                    lines.set(j+1, t);
                }
            }
        }
        return lines;
    }
}
