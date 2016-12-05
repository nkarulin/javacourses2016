package com.epam.javacourses2016.task1;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))){
            for (String s : reversedList) {
                bw.write(s);
                bw.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
