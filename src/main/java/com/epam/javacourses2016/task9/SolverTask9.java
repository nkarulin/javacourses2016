package com.epam.javacourses2016.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

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
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(input))) {
            while (scanner.hasNextLine()) {
                Scanner scanner2 = new Scanner(scanner.nextLine());
                while (scanner2.hasNext()) {
                    lines.add(scanner2.next().toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashSet<String> words = new HashSet<>();
        for(String line : lines){
            if (!containsIgnoreCase(words, line)) {
                words.add(line);
            }
        }
        return words;
    }

    private static boolean containsIgnoreCase(HashSet<String> words, String word) {
        for (String s : words) {
            if (s.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
