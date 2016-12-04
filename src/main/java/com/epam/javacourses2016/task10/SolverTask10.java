package com.epam.javacourses2016.task10;

import com.epam.javacourses2016.task9.SolverTask9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;

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

        HashMap<String, Integer> englishWords = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {

            String s = null;
            while((s = br.readLine()) != null) {
                String[] words = s.split(" ");
                for(int i = 0; i < words.length; i++) {
                    if (SolverTask9.isEnglish(words[i])) {
                        if (!englishWords.containsKey(words[i])) {
                            englishWords.put(words[i], 1);
                        }
                        else {
                            int rez = englishWords.get(words[i]);
                            englishWords.put(words[i], rez + 1);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return englishWords;
    }
}
