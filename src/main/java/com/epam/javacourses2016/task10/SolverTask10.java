package com.epam.javacourses2016.task10;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public HashMap<String, Integer> countNumberWords(File input) throws IOException {
        StringBuilder strings = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.append(line).append(" ");
            }

        }
        String words[] = strings.toString().trim().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                    continue;
                }
                map.put(word, 1);
            }
        }
        return (HashMap<String, Integer>) map;
    }
}
