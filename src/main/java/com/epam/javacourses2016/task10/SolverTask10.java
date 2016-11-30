package com.epam.javacourses2016.task10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

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
        HashMap<String, Integer> result = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader(input))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if(result.containsKey(word)) {
                    result.put(word, result.get(word) + 1);
                }
                else {
                    result.put(word, 1);
                }
            }
        } catch (IOException e) {
            System.out.println("I/O ex");
            e.printStackTrace();
        }
        return result;
    }
}
