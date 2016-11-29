package com.epam.javacourses2016.task2;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
        getFilesInDirectory(directory, fileSet);
        System.out.println(fileSet);
        return fileSet;
    }

    private void getFilesInDirectory(File directory, Set<File> fileSet) {
        if(directory.exists()) {
            fileSet.add(directory);
            if(directory.isDirectory() && (directory.list() != null) && (directory.listFiles() != null)) {
                List<File> files = Arrays.asList(directory.listFiles());
                for(File file : files) {
                    fileSet.add(file);
                    getFilesInDirectory(file,fileSet);
                }
            }
        }
    }
}
