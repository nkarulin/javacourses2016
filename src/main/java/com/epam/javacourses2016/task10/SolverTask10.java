package com.epam.javacourses2016.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(input))) {
            while (scanner.hasNextLine()) {
                Scanner scanner2 = new Scanner(scanner.nextLine());
                while (scanner2.hasNext()) {
                    lines.add(scanner2.next());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> words = new HashMap<>();
        for(String line: lines){
            if (words.containsKey(line)) {
                words.put(line, words.get(line) + 1);
            }
            else {
                words.put(line, 1);
            }
        }
        return words;
    }
}
