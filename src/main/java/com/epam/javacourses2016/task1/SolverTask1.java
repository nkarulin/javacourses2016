package com.epam.javacourses2016.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        //TODO: realize solver of a task
        List<String> strings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(input);
            BufferedWriter writer = new BufferedWriter(new PrintWriter(output));
            while (scanner.hasNext()) {
                strings.add(scanner.nextLine());
            }
            Collections.reverse(strings);
            for (String string : strings) {
                writer.write(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(strings);
        return strings;
    }
}
