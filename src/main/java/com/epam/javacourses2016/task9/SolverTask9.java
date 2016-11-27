package com.epam.javacourses2016.task9;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

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
        HashSet<String> result = new HashSet<>();
        ArrayList<String> allWords = new ArrayList<>();
        try {
            FileReader fileInputStream = new FileReader(input);
            BufferedReader reader = new BufferedReader(fileInputStream);
            String word;
            while ((word = reader.readLine()) != null) {
                allWords.add(word);
            }
            for (String oneWord : allWords) {
                result.addAll(result.stream()
                        .filter(s -> !oneWord.equalsIgnoreCase(s))
                        .map(s -> oneWord)
                        .collect(Collectors.toList()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
