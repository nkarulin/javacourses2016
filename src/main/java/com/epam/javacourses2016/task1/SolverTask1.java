package com.epam.javacourses2016.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    public List<String> reverseFile(File input, File output) {
        List<String> lines = readFile(input);
        Collections.reverse(lines);
        fileWriter(output, lines);

        Collections.reverse(lines);
        return lines;
    }

    private List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        String s;

        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ((s = bufferedReader.readLine()) != null) {
                lines.add(s);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return lines;
    }

    private void fileWriter(File file, List<String> lines) {
        try (FileWriter writer = new FileWriter(file)) {

            int linesCount = lines.size();
            for (int i = 0; i < linesCount; i++) {
                writer.write(lines.get(i) + '\n');
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
