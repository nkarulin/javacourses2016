package com.epam.javacourses2016.task1;

import com.epam.javacourses2016.task3.Poem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Ввести строки из файла, записать в список.
 * Вывести строки в файл в обратном порядке.
 */
public class SolverTask1 {

    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     * @param input Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
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
