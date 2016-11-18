package com.epam.javacourses2016.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
        HashSet<String> uniqueWords = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            Pattern pattern = Pattern.compile("[(A-Za-z)('\\-)(A-Za-z)]+");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    uniqueWords.add(matcher.group().toLowerCase());
                }
            }
        } catch (Exception e) {

        }

        return uniqueWords;
    }
}
