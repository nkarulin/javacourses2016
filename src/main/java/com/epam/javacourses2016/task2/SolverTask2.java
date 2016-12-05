package com.epam.javacourses2016.task2;


import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Сформировать множество элементов, входящих в каталог и его подкаталоги.
 */
public class SolverTask2 {

    /**
     * Формирует множество всех элементов, входящих в текущий каталог и во все вложенные.
     * @param directory Корневой каталог.
     * @return Множество элементов корневого каталога и подкаталогов.
     */
    public Set<File> getFiles(File directory) {
        Set<File> fileSet = new HashSet<>();
        for (File fileEntry : directory.listFiles()) {
            fileSet.add(fileEntry);
            if (fileEntry.isDirectory()) {
                fileSet.addAll(getFiles(fileEntry));
            }
        }
        return fileSet;
    }
}
