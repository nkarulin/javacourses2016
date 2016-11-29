package com.epam.javacourses2016.task1;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.util.*;

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
        List<String> strings = readLines(input);
        Collections.reverse(strings);
        writeLines(output, strings);
        Collections.reverse(strings);
        return strings;
    }

    private List<String> readLines(File input) {
        ArrayList<String> strings = new ArrayList<>();
        String s = null;
        char[] buf = new char[1024];
        try (FileReader fr = new FileReader(input); BufferedReader br = new BufferedReader(fr)) {

            while((s = br.readLine()) != null) {
                strings.add(s);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return strings;
    }

    private void writeLines(File output, List<String> lines) {
        String empty = "";
        if (output != null && lines != null && lines.size() > 0)
            try (FileWriter fw = new FileWriter(output)) {

                for(int i = 0; i < lines.size(); i++) {
                    String current = lines.get(i);
                    fw.write((current != null ? current : empty));
                    fw.write("\r\n");
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}
