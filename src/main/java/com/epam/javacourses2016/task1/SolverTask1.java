package com.epam.javacourses2016.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        FileWriter fileWriter = new FileWriter(output);
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            String line = iterator.previous();
            fileWriter.write(line + "\n");
        }
        fileWriter.close();
        return list;
    }
}
