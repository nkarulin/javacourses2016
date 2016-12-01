package com.epam.javacourses2016.task10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

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
        HashMap<String, Integer> result = new HashMap<>();
        String str;
        try (FileReader fr = new FileReader(input); BufferedReader br = new BufferedReader(fr)) {
            while ((str = br.readLine()) != null) {
                String[] words = str.split("\\|");
                for (String s : words) {
                    if (result.containsKey(s)) {
                        result.put(s, result.get(s) + 1);
                    } else {
                        result.put(s, 1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
}
