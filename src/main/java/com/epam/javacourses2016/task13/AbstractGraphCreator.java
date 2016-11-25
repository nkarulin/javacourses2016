package com.epam.javacourses2016.task13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public abstract AbstractGraph createGraph(int numberNodes);

    /**
     * Абстрактный граф.
     * При создании задается количество вершин.
     * Нумерация вершин начинается с 0.
     * Допустимы операции добавления, удаления и проверки существования ребер.
     */
    public class MyGraph extends AbstractGraph {

        Map<Integer, Node> nodes = new HashMap<>();

        public MyGraph(int numberOfNodes) {
            super(numberOfNodes);
        }

        @Override
        public void addEdge(int first, int second) {

            Node firstNode = nodes.get(first);
            Node secondNode = nodes.get(second);

            if (firstNode == null) {
                firstNode = new Node(first);
                nodes.put(first, firstNode);
            }

            if (secondNode == null) {
                secondNode = new Node(second);
                nodes.put(second, secondNode);
            }

            firstNode.addNode(secondNode);
            secondNode.addNode(firstNode);
        }

        @Override
        public void removeEdge(int first, int second) {
            Node firstNode = nodes.get(first);
            Node secondNode = nodes.get(second);

            firstNode.getConnectedNodes().remove(secondNode);
            secondNode.getConnectedNodes().remove(firstNode);
        }

        @Override
        public boolean isExistEdge(int first, int second) {
            return nodes.containsKey(first) && nodes.containsKey(second);
        }

        public Map<Integer, Node> getNodes() {
            return nodes;
        }

        class Node {
            int value;
            ArrayList<Node> connectedNodes = new ArrayList<>();

            public Node(int value) {
                this.value = value;
            }

            public boolean addNode(Node node){
                if (!connectedNodes.contains(node)) {
                    connectedNodes.add(node);
                }

                return false;
            }

            public ArrayList<Node> getConnectedNodes() {
                return connectedNodes;
            }

            public void setConnectedNodes(ArrayList<Node> connectedNodes) {
                this.connectedNodes = connectedNodes;
            }
        }
    }

    public abstract class AbstractGraph {

        /**
         * Количество вершин
         */
        protected final int NUMBER_NODES;

        public AbstractGraph(int numberNodes) {
            this.NUMBER_NODES = numberNodes;
        }

        /**
         * Добавление ребра в граф.
         *
         * @param first  Первая связываемая вершина.
         * @param second Вторая связываемая вершина.
         */
        public abstract void addEdge(int first, int second);

        /**
         * Удаление ребра из графа.
         *
         * @param first  Первая освобождаемая от связи вершина.
         * @param second Вторая освобождаемая от связи вершина.
         */
        public abstract void removeEdge(int first, int second);

        /**
         * Проверка наличия ребра.
         *
         * @param first  Первая вершина.
         * @param second Вторая вершина.
         */
        public abstract boolean isExistEdge(int first, int second);
    }
}
