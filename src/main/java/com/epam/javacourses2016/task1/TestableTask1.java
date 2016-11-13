package com.epam.javacourses2016.task1;

import java.io.File;
import java.util.List;

/**
 * Интерфейс для юнит-тестирования задания №1.
 * Ввести строки из файла, записать в список.
 * Вывести строки в файл в обратном порядке.
 */
public interface TestableTask1 {

    /**
     * Читает строки из исходного файла и сохраняет в выходной в обратном порядке.
     * @param input Файл с входными данными.
     * @param output Файл с выходными данными.
     * @return Список строк, прочитанных из входного файла в прямом порядке.
     */
    List<String> reverseFile(File input, File output);
}