package com.epam.javacourses2016.task10;

import java.io.File;
import java.io.FileNotFoundException;
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
    public HashMap<String, Integer> countNumberWords(File input) throws FileNotFoundException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()){
            String current = scanner.next();
            if (hashMap.containsKey(current)) hashMap.put(current,hashMap.get(current)+1);
            else hashMap.put(current,1);
        }
        return hashMap;
    }
}
