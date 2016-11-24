package com.epam.javacourses2016.task13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 24/11/2016.
 */
public class Graph extends AbstractGraphCreator.AbstractGraph {

    private List<Edge> edges = new ArrayList<>();

    public Graph(int numberNodes) {
        super(numberNodes);
    }

    @Override
    public void addEdge(int first, int second) {
        if (!isExistEdge(first, second))
            edges.add(new Edge(first,second));
    }

    @Override
    public void removeEdge(int first, int second) {
        edges.remove(new Edge(first,second));
    }

    @Override
    public boolean isExistEdge(int first, int second) {
        Edge edge = new Edge(first,second);
        return edges.contains(edge);
    }
}
