package com.epam.javacourses2016.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Poem> poemsOfAuthor = poems.stream()
                .filter(poem -> poem.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        List<String> allLines = new ArrayList<>();
        for (Poem poem : poemsOfAuthor) {
            List<String> poemsLines = poem.getLines();
            allLines.addAll(poemsLines);
        }
        allLines.stream().sorted((string1, string2) -> {
            if (string1.length() > string2.length()) {
                return 1;
            } else if (string1.length() < string2.length()) {
                return -1;
            } else return 0;
        }).close();
        return allLines;
    }
}
