package com.epam.javacourses2016.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
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
    public HashMap<String, Integer> countNumberWords(File input){
    HashMap<String, Integer> result = new HashMap<>();
        try {
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                String tmp = scanner.next();
                if (!result.containsKey(tmp)) {
                    result.put(tmp,1);
                }else{
                    int key=result.get(tmp)+1;
                    result.put(tmp,key);
                }
            }
        }
        
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        return result;
}
}
