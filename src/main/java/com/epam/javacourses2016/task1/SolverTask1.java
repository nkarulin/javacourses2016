package com.epam.javacourses2016.task1;

import com.epam.javacourses2016.task3.Poem;

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
        try {
            if (!output.exists()) {
                output.createNewFile();
            }
            FileWriter fw = new FileWriter(output.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : reversedList) {
                bw.write(s);
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*public static void main(String[] args) {
        File file = new File("./1.txt");
        File file1 = new File("./2.txt");
        List<String> list = reverseFile(file, file1);
        for (String s : list) {
            System.out.println(s);
        }
    }*/
}
