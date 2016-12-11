package com.epam.javacourses2016.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ввести строки из файла, записать в список.
 * Вывести строки в файл в обратном порядке.
 */
public class SolverTask1 {

    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     *
     * @param input  Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String str;
            while ((str = reader.readLine()) != null) {
                strings.add(str);
            }
        }
        Collections.reverse(strings);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (String str : strings) {
                writer.write(str);
                writer.newLine();
            }
        }
        Collections.reverse(strings);
        return strings;
    }
}
