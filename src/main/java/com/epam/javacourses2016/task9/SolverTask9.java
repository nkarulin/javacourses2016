package com.epam.javacourses2016.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

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
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String word;
            while ((word = reader.readLine()) != null) {
                result.add(word.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
