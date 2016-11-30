package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.task16.SolverTask16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class IFile implements SolverTask15.IFileWithLines {

    private File file;
    private Set<SolverTask15.ILine> lines;

    public IFile(File file) {
        this.file = file;
        lines = new HashSet<>();
        if (file.length() != 0) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                lines = (Set<SolverTask15.ILine>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {
        return lines;
    }
}
