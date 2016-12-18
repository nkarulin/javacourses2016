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
     * @param input Анализируемый файл.
     * @return Множество полученных слов.
     */
    public HashSet<String> getUniqueWords(File input) throws FileNotFoundException {
        HashSet<String> hashSet = new HashSet<>();
        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()) {
            hashSet.add(scanner.next().toLowerCase());
        }
        return hashSet;
    }
}
