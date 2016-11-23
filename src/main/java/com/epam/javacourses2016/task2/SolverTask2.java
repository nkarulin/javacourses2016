package com.epam.javacourses2016.task2;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Сформировать множество элементов, входящих в каталог и его подкаталоги.
 */
public class SolverTask2 {

    private boolean equals(File file1, File file2)  {

        boolean equals = false;
        try {
            equals = file1.getCanonicalPath().equals(file2.getCanonicalPath());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return equals;
    }

    /**
     * Формирует множество всех элементов, входящих в текущий каталог и во все вложенные.
     * @param directory Корневой каталог.
     * @return Множество элементов корневого каталога и подкаталогов.
     */

    public Set<File> getFiles(File directory) {

        Set<File> elements = new HashSet<>();
        if (directory != null) {
            File[] files = directory.listFiles();
            for(int i = 0; i < files.length; i++) {

                if (!equals(directory, files[i])) {
                    if (files[i].isDirectory())
                        elements.addAll(getFiles(files[i]));
                    else
                        elements.add(files[i]);
                }
            }
        }

        return elements;
    }
}
