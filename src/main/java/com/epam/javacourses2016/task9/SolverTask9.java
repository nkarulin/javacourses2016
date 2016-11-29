package com.epam.javacourses2016.task9;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми.
 * Использовать класс HashSet.
 */
public class SolverTask9 {

    /**
     * Формирует множество уникальных слов, извлекая их из файла.
     *
     * @param input Анализируемый файл.
     * @return Множество полученных слов.
     */
    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> uniqueWords = new HashSet<>();

        try (Scanner scanner = new Scanner(input)) {
            Pattern pattern = Pattern.compile("[(A-Za-z)('\\-)(A-Za-z)]+");

            while (scanner.hasNext(pattern)) {
                uniqueWords.add(scanner.next(pattern).toLowerCase());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return uniqueWords;
    }
}
