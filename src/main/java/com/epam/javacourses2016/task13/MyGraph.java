package com.epam.javacourses2016.task13;

import java.util.HashSet;
import java.util.Set;

public class MyGraph extends AbstractGraphCreator.AbstractGraph {
    private Set<Edge> edges = new HashSet<>();
    private int numberNodes;

    MyGraph(int numberNodes) {
        super(numberNodes);
        this.numberNodes = numberNodes;
    }

    @Override
    public void addEdge(int first, int second) {
        if (!(isExistEdge(first, second) && (first < numberNodes && second < numberNodes))) {
            edges.add(new Edge(first, second));
        }
    }

    @Override
    public void removeEdge(int first, int second) {
        if (isExistEdge(first, second)) {
            edges.remove(new Edge(first, second));
        }
    }

    @Override
    public boolean isExistEdge(int first, int second) {
        return edges.contains(new Edge(first, second)) || edges.contains(new Edge(second, first));
    }
}
