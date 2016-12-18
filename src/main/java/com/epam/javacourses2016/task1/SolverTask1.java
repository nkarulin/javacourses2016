package com.epam.javacourses2016.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ввести строки из файла, записать в список.
 * Вывести строки в файл в обратном порядке.
 */
public class SolverTask1 {

    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     * @param input Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
    public List<String> reverseFile(File input, File output) {
        BufferedReader inputReader = null;
        try {
            inputReader = new BufferedReader(new FileReader(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> lines = inputReader.lines().collect(Collectors.toCollection(ArrayList::new));
        FileWriter outputWriter = null;
        try {
            outputWriter = new FileWriter(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(lines);
        FileWriter finalOutputWriter = outputWriter;
        lines.stream().forEachOrdered((l) -> {
            try {
                finalOutputWriter.write(l);
                finalOutputWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        try {
            finalOutputWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(lines);
        return lines;
    }
}
