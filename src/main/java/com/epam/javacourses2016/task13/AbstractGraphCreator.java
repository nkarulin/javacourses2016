package com.epam.javacourses2016.task13;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Реализовать класс Graph, представляющий собой неориентированный граф.
 * В конструкторе класса передается количество вершин в графе.
 * Методы должны поддерживать быстрое добавление и удаление ребер.
 */
public abstract class AbstractGraphCreator {
    /**
     * @param numberNodes Количество вершин в графе.
     * @return Граф указанной конфигурации.
     */

    public static AbstractGraph createGraph(int numberNodes){
        if (numberNodes <= 0) return null;
        Graph graph = new Graph(numberNodes);
        return graph;
    }

    /**
     * Абстрактный граф.
     * При создании задается количество вершин.
     * Нумерация вершин начинается с 0.
     * Допустимы операции добавления, удаления и проверки существования ребер.
     */
    static abstract class AbstractGraph {

        /** Количество вершин */
        protected final int NUMBER_NODES;

        public AbstractGraph(int numberNodes) {
            this.NUMBER_NODES = numberNodes;

        }

        /**
         * Добавление ребра в граф.
         * @param first Первая связываемая вершина.
         * @param second Вторая связываемая вершина.
         */
        public abstract void addEdge(int first, int second);

        /**
         * Удаление ребра из графа.
         * @param first Первая освобождаемая от связи вершина.
         * @param second Вторая освобождаемая от связи вершина.
         */
        public abstract void removeEdge(int first, int second);

        /**
         * Проверка наличия ребра.
         * @param first Первая вершина.
         * @param second Вторая вершина.
         */
        public abstract boolean isExistEdge(int first, int second);
    }

    public static class Graph extends AbstractGraph {

        ArrayList<Edge> edges;

        public Graph(int numberNodes) {
            super(numberNodes);
            edges = new ArrayList<>();
        }

        @Override
        public void addEdge(int first, int second) {
            edges.add(new Edge(first, second));
        }

        @Override
        public void removeEdge(int first, int second) {
            while(edges.contains(new Edge(first, second)))
                edges.remove(new Edge(first, second));
        }

        @Override
        public boolean isExistEdge(int first, int second) {
            return edges.stream().anyMatch((e) -> e.equals(new Edge(first, second)));
        }
    }

    private static class Edge {
        private int firstNode;
        private int secondNode;

        public Edge(int firstNode, int secondNode) {
            this.firstNode = firstNode;
            this.secondNode = secondNode;
        }

        public int getFirstNode() {
            return firstNode;
        }

        public int getSecondNode() {
            return secondNode;
        }

        public void setFirstNode(int firstNode) {
            this.firstNode = firstNode;
        }

        public void setSecondNode(int secondNode) {
            this.secondNode = secondNode;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if ((firstNode == edge.firstNode && secondNode == edge.secondNode) || (firstNode == edge.secondNode && secondNode == edge.firstNode)) return true;

            return false;
        }


    }
}
