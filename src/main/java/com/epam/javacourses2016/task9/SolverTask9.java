package com.epam.javacourses2016.task9;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    public HashSet<String> getUniqueWords(File input) throws IOException {
        BufferedReader inputReader = null;
        try {
            inputReader = new BufferedReader(new FileReader(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> lines = inputReader.lines().collect(Collectors.toCollection(ArrayList::new));
        String text = "";
        for(String line : lines) {
            text += line + " ";
        }

        String[] words = text.toLowerCase().trim().split(" ");
        return Arrays.stream(words).collect(Collectors.toCollection(HashSet::new));
    }
}
