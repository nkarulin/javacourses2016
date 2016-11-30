package com.epam.javacourses2016.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми.
 * Использовать класс HashSet.
 */
public class SolverTask9 {

    /**
     * Формирует множество уникальных слов, извлекая их из файла.
     *
     * @param input Анализируемый файл.
     * @return Множество полученных слов.
     */
    public HashSet<String> getUniqueWords(File input) throws IOException {
        StringBuilder strings = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.append(line).append(" ");
            }
        }
        String words[] = strings.toString().trim().split(" ");
        Set<String> result = new HashSet<>();
        for (String word : words) {
            if (!word.isEmpty()) result.add(word.toLowerCase());
        }
        return (HashSet<String>) result;
    }
}
