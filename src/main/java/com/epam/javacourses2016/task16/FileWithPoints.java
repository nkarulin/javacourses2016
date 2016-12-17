package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;

import java.io.*;
import java.util.*;

/**
 * Created by GiulioRM on 12/17/2016.
 */
public class FileWithPoints implements SolverTask16.IFileWithPoints  {

        private File file;

        public FileWithPoints(File file) {
            this.file = file;
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public SortedMap<Point2D, Double> getPoints() {
            SortedMap<Point2D, Double> points = new TreeMap<>();
            try(Scanner scanner = new Scanner(new FileReader(file))) {
                Double x = null;
                Double y = null;
                while (scanner.hasNextDouble()) {
                    double next = scanner.nextDouble();
                    if (x == null)
                        x = next;
                    else if (y == null)
                        y = next;
                  //  params.add(scanner.nextDouble());
                  //  if (params.size() == 3) {
                    if (x != null && y != null) {
                        points.put(new Point2D(x, y), 0.0);
                        x = null;
                        y = null;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
            return points;
        }

        public void writeIntoFile(List<Point2D> result) {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Point2D point : result) {
                    writer.write(point.getX() + " "
                            + point.getY() + " " + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

}
