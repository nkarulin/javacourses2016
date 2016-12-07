package com.epam.javacourses2016.task9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

/**
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми.
 * Использовать класс HashSet.
 */
public class SolverTask9 {

    public static boolean isEnglish(String word) {
        word = word.toLowerCase();
        for(int i = 0; i < word.length(); i++) {
            char let = word.charAt(i);
            if((let <  'а' || let > 'z') && let >= 'а' && let <= 'я')
                return false;
        }
        return true;
    }
    /**
     * Формирует множество уникальных слов, извлекая их из файла.
     * @param input Анализируемый файл.
     * @return Множество полученных слов.
     */
    public HashSet<String> getUniqueWords(File input) {

        HashSet<String> englishWords = new HashSet<>();
        try (FileReader fr = new FileReader(input); BufferedReader br = new BufferedReader(fr)) {

            String s = null;
            while((s = br.readLine()) != null) {
                String[] words = s.split(" ");
                for(int i = 0; i < words.length; i++) {
                    words[i] = words[i].toLowerCase();
                    if (isEnglish(words[i]))
                        englishWords.add(words[i]);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return englishWords;
    }
}
