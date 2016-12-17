package com.epam.javacourses2016.task10;

import java.io.File;
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
    public HashMap<String, Integer> countNumberWords(File input) throws IOException {
        Scanner scanner = new Scanner(input);
        HashMap<String, Integer> result = new HashMap<>();

        while (scanner.hasNext()) {
            String s = scanner.next();
            result.merge(s,1, (v1,v2)-> v1+v2);
        }

        return result;
    }
}