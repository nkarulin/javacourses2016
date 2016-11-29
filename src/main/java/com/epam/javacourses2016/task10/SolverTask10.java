package com.epam.javacourses2016.task10;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
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

        try (Scanner scanner = new Scanner(input)) {
            Pattern pattern = Pattern.compile("[(A-Za-z)('\\-)(A-Za-z)]+");
            String key;

            while (scanner.hasNext(pattern)) {
                key = scanner.next();
                if (!uniqueWords.containsKey(key)) {
                    uniqueWords.put(key, 1);
                } else {
                    int val = uniqueWords.get(key);
                    val++;
                    uniqueWords.replace(key, val);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return uniqueWords;
    }
}
