package com.epam.javacourses2016.task2;

import java.io.File;
import java.util.Set;

/**
 * Интерфейс для юнит-тестирования задания №2.
 * Сформировать множество элементов, входящих в каталог и его подкаталоги.
 */
public interface TestableTask2 {

    /**
     * Формирует множество всех элементов, входящих в текущий каталог и во все вложенные.
     * @param directory Корневой каталог.
     * @return Множество элементов корневого каталога и подкаталогов.
     */
    Set<File> getFiles(File directory);
}
