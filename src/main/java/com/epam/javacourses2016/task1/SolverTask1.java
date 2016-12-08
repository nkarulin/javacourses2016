package com.epam.javacourses2016.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;


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
        List<String> listfromfile = null;

        try {
            listfromfile = Files.readAllLines(Paths.get(input.getPath()), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileWriter fw = new FileWriter(output)) {

            for (int i = listfromfile.size() - 1; i >= 0; i--) {
                fw.write(listfromfile.get(i) + '\n');

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listfromfile;
    }
}
