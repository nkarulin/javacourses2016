package com.epam.javacourses2016.task13;

import org.testng.annotations.Test;

import java.util.Map;

public class AbstractGraphCreatorTest {
    @Test
    public void testCreateGraph() throws Exception {
        MyGraphCreator creator = new MyGraphCreator();
        MyGraphCreator.MyGraph graph = creator.createGraph(10);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.isExistEdge(1,2);
    }
}