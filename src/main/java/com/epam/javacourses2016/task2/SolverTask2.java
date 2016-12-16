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
     *
     * @param directory Корневой каталог.
     * @return Множество элементов корневого каталога и подкаталогов.
     */
    public Set<File> getFiles(File directory) {
        Set<File> fileset = new HashSet<>();
        File[] folderfiles = directory.listFiles();

        fileset.add(directory);
        for (File file : folderfiles) {

            fileset.add(file);
            if (file.isDirectory()) {
                fileset.addAll(getFiles(file));
            }
        }
        return fileset;
    }
}
