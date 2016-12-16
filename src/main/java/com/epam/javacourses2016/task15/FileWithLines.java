package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
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
            Scanner scanner = new Scanner(file);
            Set<SolverTask15.ILine> lines = new HashSet<>();

            while (scanner.hasNextDouble()) {
                lines.add(new Line(new Point2D(scanner.nextDouble(), scanner.nextDouble()),
                        (new Point2D(scanner.nextDouble(), scanner.nextDouble()))));
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}