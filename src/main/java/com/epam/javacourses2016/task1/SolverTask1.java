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
     * @param input Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> stringList = new ArrayList<>();
        String s;
        try(BufferedReader in = new BufferedReader(new FileReader(input))) {
            while((s = in.readLine()) != null) {
                stringList.add(s);
            }
        }
        try( BufferedWriter out = new BufferedWriter(new FileWriter(output)) ) {
            for(int i = stringList.size()-1; i >= 0; i--) {
                out.write(stringList.get(i));
                out.write("\n");
            }
        }
        return stringList;
    }
}
