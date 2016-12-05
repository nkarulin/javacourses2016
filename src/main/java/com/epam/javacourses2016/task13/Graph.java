package com.epam.javacourses2016.task13;

import java.util.*;

/**
 * Created by User on 05.12.2016.
 */
public class Graph extends AbstractGraphCreator.AbstractGraph {

    private Map<Integer,GraphNode> graphNodeMap;

    public Graph(int numberNodes) {
        super(numberNodes);
        graphNodeMap = new HashMap<>(numberNodes);
    }

    @Override
    public void addEdge(int first, int second) {
        if(first <= NUMBER_NODES && second <= NUMBER_NODES) {
            GraphNode firstGraphNode = graphNodeMap.get(first);
            if(firstGraphNode == null)
                firstGraphNode = new GraphNode(first);
            GraphNode secondGraphNode = graphNodeMap.get(second);
            if(secondGraphNode == null)
                secondGraphNode = new GraphNode(second);

            if(!firstGraphNode.isContainGraphNode(secondGraphNode))
                firstGraphNode.addGraphNode(secondGraphNode);
            if(!secondGraphNode.isContainGraphNode(firstGraphNode))
                secondGraphNode.addGraphNode(firstGraphNode);
            graphNodeMap.put(first, firstGraphNode);
            graphNodeMap.put(second, secondGraphNode);
        }
    }

    @Override
    public void removeEdge(int first, int second) {
        if(isExistEdge(first,second)) {
            graphNodeMap.get(first).removeGraphNode(graphNodeMap.get(second));
            graphNodeMap.get(second).removeGraphNode(graphNodeMap.get(first));
        }
    }

    @Override
    public boolean isExistEdge(int first, int second) {
        if(!graphNodeMap.containsKey(first))
            return false;
        if(!graphNodeMap.containsKey(second))
            return false;
        return graphNodeMap.get(first).isContainGraphNode(graphNodeMap.get(second)) && graphNodeMap.get(second).isContainGraphNode(graphNodeMap.get(first));
    }

    class GraphNode {

        private int value;
        private ArrayList<GraphNode> graphNodeList;
        public GraphNode(int value) {
            this.value = value;
            graphNodeList = new ArrayList<>();
        }

        public void addGraphNode(GraphNode graphNode) {
            graphNodeList.add(graphNode);
        }

        public void removeGraphNode(GraphNode graphNode) {
            graphNodeList.remove(graphNode);
        }

        public boolean isContainGraphNode(GraphNode graphNode) {
            return graphNodeList.contains(graphNode);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GraphNode graphNode = (GraphNode) o;

            return value == graphNode.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

}
