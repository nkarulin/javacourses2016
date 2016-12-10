package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.task15.Line;
import com.epam.javacourses2016.task15.SolverTask15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Vasya on 27.11.2016.
 */
public class FileWithPoints implements SolverTask16.IFileWithPoints {
    private File file;

    /**
     * @return Файл с результатами анализа.
     */
    @Override
    public File getFile() {
        return file;
    }

    public FileWithPoints(File file) {
        this.file = file;
    }

    /**
     * Извлекает из файла информацию о хранящихся в нем точках.
     *
     * @return Множество пар: точка + расстояние до центра.
     */
    @Override
    public SortedMap<Point2D, Double> getPoints() {
        try {
            Scanner scanner = new Scanner(new FileReader(file));

            SortedMap<Point2D, Double> points = new TreeMap<Point2D, Double>();
            while (scanner.hasNextInt()) {
                points.put(new Point2D(scanner.nextInt(), scanner.nextInt()),scanner.nextDouble());
            }
            return points;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}