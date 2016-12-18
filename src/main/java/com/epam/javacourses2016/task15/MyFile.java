package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class MyFile implements SolverTask15.IFileWithLines {
    private File file;
    private Set<SolverTask15.ILine> lines;

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {
        return lines;
    }

    public MyFile(File file) {
        this.file = file;
        lines = new TreeSet<>();
        if (file.length() != 0) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                lines = (Set<SolverTask15.ILine>) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
