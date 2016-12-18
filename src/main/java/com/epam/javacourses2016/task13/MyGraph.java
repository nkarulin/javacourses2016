package com.epam.javacourses2016.task13;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by n on 15.12.2016.
 */
public class MyGraph extends AbstractGraphCreator.AbstractGraph{

    private HashMap<Integer,ArrayList<Integer>> adjacencyList;
    public MyGraph(int numberNodes) {
        super(numberNodes);
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addEdge(int first, int second) {
        checkVertexForAdd(first,second);
        checkVertexForAdd(second,first);
    }

    @Override
    public void removeEdge(int first, int second) {
        if (isExistEdge(first, second)) {
            adjacencyList.get(first).remove(new Integer(second));
            adjacencyList.get(second).remove(new Integer(first));
        }
    }

    @Override
    public boolean isExistEdge(int first, int second) {
        if (adjacencyList.containsKey(first)){
            if (adjacencyList.get(first).contains(new Integer(second))) return true;
        }
        return false;
    }
    public void checkVertexForAdd(int first, int second){
        if (adjacencyList.containsKey(first)){
            if (!adjacencyList.get(first).contains(new Integer(second))){
                adjacencyList.get(first).add(second);
            }
            else return;
        }
        else{
            ArrayList list = new ArrayList();
            list.add(second);
            adjacencyList.put(first,list);
        }
    }
}
