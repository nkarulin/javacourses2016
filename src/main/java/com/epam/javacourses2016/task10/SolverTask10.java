package com.epam.javacourses2016.task10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова и посчитать частоту их встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.
 * Использовать класс HashMap.
 */
public class SolverTask10 {

    /**
     * Подсчитывает количество вхождений каждого слова в файле.
     *
     * @param input Файл с исходными данными.
     * @return Множество пар <слово, количество вхождений в файле>.
     */
    public HashMap<String, Integer> countNumberWords(File input) {
        HashMap<String, Integer> uniqueWords = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            int y;
            Pattern pattern = Pattern.compile("[(A-Za-z)('\\-)(A-Za-z)]+");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String key = matcher.group();
                    if (!uniqueWords.containsKey(key)) {
                        uniqueWords.put(key, 1);
                    } else {
                        int val = uniqueWords.get(key);
                        val++;
                        uniqueWords.replace(key, val);
                    }

                }
            }
        } catch (Exception e) {

        }

        return uniqueWords;
    }
}
