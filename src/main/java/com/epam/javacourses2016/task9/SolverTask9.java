package com.epam.javacourses2016.task9;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;

/**
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми.
 * Использовать класс HashSet.
 */
public class SolverTask9 {

    /**
     * Формирует множество уникальных слов, извлекая их из файла.
     * @param input Анализируемый файл.
     * @return Множество полученных слов.
     */

    public HashSet<String> getUniqueWords(File input) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(input.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashSet<String> words = new HashSet<>();
        for(String line : lines){
            if (!containsIgnoreCase(words, line)) {
                words.add(line);
            }
        }
        return words;
    }

    private static boolean containsIgnoreCase(HashSet<String> words, String word) {
        for (String s : words) {
            if (s.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
