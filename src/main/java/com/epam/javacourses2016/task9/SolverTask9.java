package com.epam.javacourses2016.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<String> allWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String word;
            while ((word = reader.readLine()) != null) {
                allWords.add(word);
            }
            for (String oneWord : allWords) {
                int count = 0;
                for (String resultWord : result) {
                    if (oneWord.equalsIgnoreCase(resultWord)) {
                        count++;
                    }
                }
                if (count == 0) {
                    result.add(oneWord);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
