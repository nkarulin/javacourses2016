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
        List<String> list = new ArrayList<>();
        for (Poem poem : poems) {
            if (poem.getAuthor().equals(author)){
                list.addAll(poem.getLines());
            }
        }
        Collections.sort(list, (o1, o2)->o1.length()-o2.length());
        return list;
    }
}
