package com.epam.javacourses2016.task13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph extends AbstractGraphCreator.AbstractGraph {

    private Map<Integer, List<Integer>> edges;

    public Graph(int numberNodes) {
        super(numberNodes);
        edges = new HashMap<>();
    }

    @Override
    public void addEdge(int first, int second) {
       addOneEdge(first,second);
       addOneEdge(second,first);
    }

    private void addOneEdge(int from, int to){
        if(edges.containsKey(from)){
            if(!edges.get(from).contains(to)) edges.get(from).add(to);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(to);
            edges.put(from,list);
        }
    }

    @Override
    public void removeEdge(int first, int second) {
        if(edges.containsKey(first)){
            if(edges.get(first).contains(second)) {
                edges.get(first).remove(new Integer(second));
                edges.get(second).remove(new Integer(first));
            }
        }
    }

    @Override
    public boolean isExistEdge(int first, int second) {
        return (edges.containsKey(first) && edges.get(first).contains(second));
    }
}
