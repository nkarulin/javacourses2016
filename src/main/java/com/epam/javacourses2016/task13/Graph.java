package com.epam.javacourses2016.task13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Рамиль on 29.11.2016.
 */
public class Graph extends AbstractGraphCreator {

    @Override
    AbstractGraph createGraph(int numberNodes) {
        AbstractGraphImpl graph = new AbstractGraphImpl(numberNodes);
        return graph;
    }

    public class AbstractGraphImpl extends AbstractGraph {

        public Set<Node> nodes;

        public AbstractGraphImpl(int numberNodes) {
            super(numberNodes);
            nodes = new HashSet<>();
            for (int i = 0; i < NUMBER_NODES; i++) {
                Node node = new Node(i);
                nodes.add(node);
            }
        }

        @Override
        public void addEdge(int first, int second) {
            for (Node node : nodes) {
                if (node.getVertex() == first && !node.isNeighbour(second)) {
                    node.addNeigbour(second);
                    break;
                }
            }
            for (Node node : nodes) {
                if (node.getVertex() == second && !node.isNeighbour(first)) {
                    node.addNeigbour(first);
                    break;
                }
            }
        }

        @Override
        public void removeEdge(int first, int second) {
            for (Node node : nodes) {
                if (node.getVertex() == first) {
                    nodes.remove(node);
                    break;
                }
            }
            for (Node node : nodes) {
                if (node.getVertex() == second) {
                    nodes.remove(node);
                    break;
                }
            }
            for (Node node : nodes) {
                if (node.isNeighbour(first)) {
                    node.removeNeigbour(first);
                }
                if (node.isNeighbour(second)) {
                    node.removeNeigbour(second);
                }
            }
        }

        @Override
        public boolean isExistEdge(int first, int second) {
            for (Node node : nodes) {
                if (node.getVertex() == first) {
                    if (node.isNeighbour(second)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        AbstractGraph g = graph.createGraph(3);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,2);
        g.removeEdge(0,2);
    }
}
