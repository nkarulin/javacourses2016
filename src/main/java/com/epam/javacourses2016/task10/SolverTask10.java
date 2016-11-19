package com.epam.javacourses2016.task10;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

/**
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова и посчитать частоту их встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.
 * Использовать класс HashMap.
 */
public class SolverTask10 {

    /**
     * Подсчитывает количество вхождений каждого слова в файле.
     * @param input Файл с исходными данными.
     * @return Множество пар <слово, количество вхождений в файле>.
     */
    public HashMap<String, Integer> countNumberWords(File input) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(input.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> words = new HashMap<>();
        for(String line: lines){
            if (words.containsKey(line)) {
                words.put(line, words.get(line) + 1);
            }
            else {
                words.put(line, 1);
            }
        }
        return words;
    }
}
