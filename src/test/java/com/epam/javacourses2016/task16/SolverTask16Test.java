package com.epam.javacourses2016.task16;

import com.epam.javacourses2016.Point2D;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class SolverTask16Test {

    @Test
    public void testAnalyze() throws Exception {

    }

    @Test(enabled = true, dataProvider = "points")
    public void testAnalyze_fromKA(Point2D center, int radius, File file, Double[][] doubles) throws Exception {
        SolverTask16 solverTask16 = new SolverTask16();
        SortedMap<Point2D, Double> sortedMap = convertToSortedMap(doubles);
        SortedMap<Point2D, Double> sortedMap1 = solverTask16.analyze(center,radius,file).getPoints();
        SortedSet<Map.Entry<Point2D, Double>> sortedSet = getSortedSet(sortedMap);
        SortedSet<Map.Entry<Point2D, Double>> sortedSet1 = getSortedSet(sortedMap1);
        Assert.assertEquals(sortedSet, sortedSet1);
    }

    private SortedSet<Map.Entry<Point2D, Double>> getSortedSet(SortedMap<Point2D,Double> sortedMap) {
        SortedSet<Map.Entry<Point2D, Double>> sortedset = new TreeSet<Map.Entry<Point2D, Double>>(
                new Comparator<Map.Entry<Point2D, Double>>() {
                    @Override
                    public int compare(Map.Entry<Point2D, Double> e1,
                                       Map.Entry<Point2D, Double> e2) {

                        if(e1.getValue() < e2.getValue())
                            return -1;
                        if(e1.getValue() > e2.getValue())
                            return 1;
                        else {
                            if (e1.getKey().getX() < e2.getKey().getX())
                                return -1;
                            if (e1.getKey().getX() > e2.getKey().getX())
                                return 1;
                            if (e1.getKey().getY() < e2.getKey().getY())
                                return -1;
                            if (e1.getKey().getY() > e2.getKey().getY())
                                return 1;
                            return 0;
                        }
                    }
                });

        sortedset.addAll(sortedMap.entrySet());
        return sortedset;
    }

    private SortedMap<Point2D, Double> convertToSortedMap(Double[][] doubles) {
        SortedMap<Point2D, Double> sortedMap = new TreeMap<>();
        for (Double[] aDouble : doubles) {
            sortedMap.put(new Point2D(aDouble[0], aDouble[1], aDouble[2]), aDouble[2]);
        }
        return sortedMap;
    }

    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][] {
                {new com.epam.javacourses2016.Point2D(0.0,0.0), 2, new File("output1.txt"),new Double[][] {
                        {0.0, 0.0,  0.0},
                        {-1.0, 0.0,  1.0},
                        {0.0, -1.0,  1.0},
                        {0.0, 1.0, 1.0},
                        {1.0, 0.0,  1.0},
                        {-1.0, -1.0,  1.4142135623730951},
                        {-1.0, 1.0, 1.4142135623730951},
                        {1.0, -1.0,  1.4142135623730951},
                        {1.0, 1.0,  1.4142135623730951},
                }},
                {new com.epam.javacourses2016.Point2D(0.0,0.0), 1, new File("output2.txt"),new Double[][] {}},
                {new com.epam.javacourses2016.Point2D(0.4,0.4), 2, new File("output3.txt"),new Double[][] {
                        { 0.0, 0.0,  0.5656854249492381},
                        { 0.0, 1.0,  0.7211102550927979},
                        { 1.0, 0.0,  0.7211102550927979},
                        { 1.0, 1.0,  0.848528137423857},
                        { -1.0, 0.0,  1.4560219778561034},
                        { 0.0, -1.0,  1.4560219778561034},
                        { -1.0, 1.0,  1.5231546211727816},
                        { 1.0, -1.0,  1.5231546211727816},
                        { 0.0, 2.0,  1.6492422502470645},
                        { 2.0, 0.0,  1.6492422502470645},
                        { 1.0, 2.0,  1.7088007490635064},
                        { 2.0, 1.0,  1.7088007490635064},
                        { -1.0, -1.0,  1.979898987322333},
                }},
                {new com.epam.javacourses2016.Point2D(0.7,0.7), 2, new File("output4.txt"),new Double[][] {
                        { 1.0, 1.0,  0.42426406871192857},
                        { 0.0, 1.0,  0.7615773105863908},
                        { 1.0, 0.0, 0.7615773105863908},
                        { 0.0, 0.0,  0.9899494936611665},
                        { 1.0, 2.0,  1.3341664064126335},
                        { 2.0, 1.0,  1.3341664064126335},
                        { 0.0, 2.0,  1.47648230602334},
                        { 2.0, 0.0,  1.47648230602334},
                        { -1.0, 1.0,  1.7262676501632068},
                        { 1.0, -1.0,  1.7262676501632068},
                        { -1.0, 0.0,  1.8384776310850235},
                        { 0.0, -1.0,  1.8384776310850235},
                        { 2.0, 2.0,  1.8384776310850237},

                }},
        };
    }

}