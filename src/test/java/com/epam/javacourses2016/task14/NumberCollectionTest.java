package com.epam.javacourses2016.task14;

import com.epam.javacourses2016.task13.AbstractGraphCreator;
import com.epam.javacourses2016.task13.MyGraphCreator;
import org.testng.annotations.Test;

/**
 * Created by kodoo on 13.11.16.
 */
public class NumberCollectionTest {

    @Test
    public void testNearest() throws Exception {
        AbstractGraphCreator creator = new MyGraphCreator();
        AbstractGraphCreator.AbstractGraph graph = creator.createGraph(10);
        graph.addEdge(1,1);
        graph.addEdge(1,2);

    }

}