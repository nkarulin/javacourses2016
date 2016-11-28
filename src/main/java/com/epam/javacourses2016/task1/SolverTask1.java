package com.epam.javacourses2016.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        Scanner s = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            s = new Scanner(input);

            while (s.hasNextLine()){
                list.add(s.nextLine());
            }
            s.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> reverseList = list.subList(0, list.size());
        Collections.reverse(reverseList);

        try {
            FileWriter writer = new FileWriter(output);
            for (String str:reverseList){
                writer.append(str+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
