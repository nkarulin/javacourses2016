package com.epam.javacourses2016.task13;

import java.util.*;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class Graph extends AbstractGraphCreator.AbstractGraph {

    private int nodesNumber;
    private List<Edge> edges;

    public Graph(int numberNodes) {
        super(numberNodes);
        this.nodesNumber = numberNodes;
        this.edges = new ArrayList<>();
    }

    @Override
    public void addEdge(int first, int second) {
        this.edges.add(new Edge(first, second));
    }

    @Override
    public void removeEdge(int first, int second) {
        this.edges.removeIf(edge -> edge.getFirst() == first && edge.getSecond() == second);
    }

    @Override
    public boolean isExistEdge(int first, int second) {
        return edges.stream().anyMatch(edge -> edge.getSecond() == second && edge.getFirst() == first
                        || edge.getFirst() == second && edge.getSecond() == first);
    }
}
