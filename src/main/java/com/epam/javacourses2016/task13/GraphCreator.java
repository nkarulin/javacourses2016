package com.epam.javacourses2016.task13;

/**
 * Created by Ivan on 24/11/2016.
 */
public class GraphCreator extends AbstractGraphCreator {
    private Graph graph;
    @Override
    AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }
}
