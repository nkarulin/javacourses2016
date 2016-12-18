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
        Set<File> files = new HashSet<>();
        files.add(directory);
        for (File file : directory.listFiles()) {
            //   files.add(file);
            if (file.isDirectory()) {
                files.addAll(getFiles(file));
            }
            else files.add(file);
        }

        return files;
    }
}
