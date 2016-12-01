package com.epam.javacourses2016.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

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
        HashSet<String> result = new HashSet<>();
        String str;
        try (FileReader fr = new FileReader(input); BufferedReader br = new BufferedReader(fr)) {
            while ((str = br.readLine()) != null) {
                String[] words = str.split("\\|");
                for (String s: words) {
                    result.add(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
