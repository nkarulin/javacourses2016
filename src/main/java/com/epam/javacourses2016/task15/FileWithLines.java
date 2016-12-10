package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vasya on 26.11.2016.
 */
public class FileWithLines implements SolverTask15.IFileWithLines {
    File file;

    /**
     * @return Файл с результатами анализа.
     */
    @Override
    public File getFile() {
        return file;
    }

    public FileWithLines(File file) {
        this.file = file;
    }

    /**
     * Извлекает из файла информацию о хранящихся в нем линиях.
     *
     * @return Множество линий, найденных в результате анализа.
     */
    @Override
    public Set<SolverTask15.ILine> getLines() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            Set<SolverTask15.ILine> lines = new HashSet<>();
            String s = bf.readLine();
            while (s != null) {
                lines.add(new Line(new Point2D(new Double(s), new Double(bf.readLine())),
                        new Point2D(new Double(bf.readLine()), new Double(bf.readLine()))));
                s =Integer.toString(bf.read());
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}