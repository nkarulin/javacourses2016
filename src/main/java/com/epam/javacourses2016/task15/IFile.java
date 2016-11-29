package com.epam.javacourses2016.task15;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.TreeSet;

public class IFile implements SolverTask15.IFileWithLines {

    private File file;
    private Set<SolverTask15.ILine> lines;

    public IFile(File file) {
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

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {
        return lines;
    }
}
