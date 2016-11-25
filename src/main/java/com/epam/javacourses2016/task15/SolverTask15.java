package com.epam.javacourses2016.task15;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.Set;

/**
 * На плоскости задано N точек.
 * Вывести в файл описания всех прямых, которые проходят более чем через 2 точки из заданных.
 */
public class SolverTask15 {
    /**
     * Осуществляет анализ переданных точек, вычисляя линии, которые проходят более чем через 2 точки.
     *
     * @param points Множество точек на плоскости.
     * @param output Файл для вывода результатов.
     * @return Файл с результатами анализа.
     */
    IFileWithLines analyze(Set<Point2D> points, File output) {
        //TODO
        return null;
    }

    /**
     * Представляет файл, содержащий информацию о найденных линиях.
     */
    class LinesWriter implements IFileWithLines {
        @Override
        public File getFile() {
            return null;
        }

        @Override
        public Set<ILine> getLines() {
            return null;
        }
    }
    private void writeLines(File file, Set<ILine> lines) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for(ILine line : lines) {
                writeLine(writer, line);
            }
        } catch (Exception e) {

        }
    }

    private void writeLine(BufferedWriter writer, ILine line) throws IOException {
        for(Point2D point : line.getPoints()) {
            writer.write("Point: {" + point.getX() +"," + point.getY()+"}; ");
        }
        writer.newLine();
    }
    interface IFileWithLines {

        /**
         * @return Файл с результатами анализа.
         */
        File getFile();

        /**
         * Извлекает из файла информацию о хранящихся в нем линиях.
         *
         * @return Множество линий, найденных в результате анализа.
         */
        Set<ILine> getLines();
    }

    /**
     * Прямая, заданная точками, входящими в исходное множество.
     */
    interface ILine {
        /**
         * @return Точки, через которые проходит прямая
         */
        Set<Point2D> getPoints();
    }
}
