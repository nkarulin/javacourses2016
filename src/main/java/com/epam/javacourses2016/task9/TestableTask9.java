package com.epam.javacourses2016.task9;

import java.io.File;
import java.util.HashSet;

/**
 * Интерфейс для юнит-тестирования задания №9.
 *
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми.
 * Использовать класс HashSet.
 */
public interface TestableTask9 {
    /**
     * Формирует множество уникальных слов, извлекая их из файла.
     * @param input Анализируемый файл.
     * @return Множество полученных слов.
     */
    HashSet<String> getUniqueWords(File input);
}
