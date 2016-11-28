package com.epam.javacourses2016.task3;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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
        poems.stream()
                .filter(poem -> poem.getAuthor().equals(author))
                .map(Poem::getLines)
                .forEach(authorLines::addAll);

//        for (Poem p : poems) {
//            if (Objects.equals(p.getAuthor(), author)) {
//                authorLines.addAll(p.getLines());
//            }
//        }
        authorLines.sort((a1,a2)->a1.compareTo(a2));


        return authorLines;
    }
}
