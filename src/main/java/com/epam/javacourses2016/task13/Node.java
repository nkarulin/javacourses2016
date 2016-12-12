package com.epam.javacourses2016.task13;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final int vertex;
    private List<Integer> neighbours;

    public Node(int vertex) {
        this.vertex = vertex;
        this.neighbours = new ArrayList<>();
    }

    public int getVertex() {
        return vertex;
    }

    public void addNeigbour(Integer vertex) {
        neighbours.add(vertex);
    }

    public void removeNeigbour(Integer vertex) {
        neighbours.remove(vertex);
    }

    public boolean isNeighbour(Integer vertex) {
        return neighbours.contains(vertex);
    }
}
