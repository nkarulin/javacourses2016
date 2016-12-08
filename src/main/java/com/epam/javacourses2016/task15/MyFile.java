package com.epam.javacourses2016.task15;

import java.io.File;
import java.util.Set;

public class MyFile implements SolverTask15.IFileWithLines {
    private File file;

    public MyFile(File file) {
        this.file = file;
    }
    
    @Override
    public File getFile() {
        return null;
    }

    @Override
    public Set<SolverTask15.ILine> getLines() {
        return null;
    }
}
