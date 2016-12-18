package com.epam.javacourses2016.task10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

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
        BufferedReader inputReader = null;
        String text = "";
        HashMap<String, Integer> uniqueWords = new HashMap<>();
        try {
            inputReader = new BufferedReader(new FileReader(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> lines = inputReader.lines().collect(Collectors.toCollection(ArrayList::new));
        for(String line : lines) {
            text += line + " ";
        }

        String[] words = text.trim().split(" ");
        Arrays.stream(words).forEach((w) -> {
            if (uniqueWords.containsKey(w)){
                uniqueWords.put(w, uniqueWords.get(w) + 1);
            } else {
                uniqueWords.put(w, 1);
            }
        });
        return uniqueWords;
    }
}
