package com.epam.javacourses2016.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
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
     *
     * @param input Анализируемый файл.
     * @return Множество полученных слов.
     */

    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> result = new HashSet<>();
        try {
            try (Scanner scanner = new Scanner(input)) {
                while (scanner.hasNext()) {
                    String tmp = scanner.next();
                    tmp = tmp.toLowerCase();
                    result.add(tmp);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
