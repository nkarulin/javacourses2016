package com.epam.javacourses2016.task9;

import java.io.*;
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
    public HashSet<String> getUniqueWords(File input) throws IOException {
        HashSet<String> strings = new HashSet<>();
        Scanner sc = new Scanner(input);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for(String s : words)
                strings.add(s.toLowerCase());
        }
        return strings;
    }
}
