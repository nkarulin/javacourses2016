package com.epam.javacourses2016.task13;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractGraphCreatorTest {
    @Test(enabled = true, dataProvider = "nodes")
    public void testCreateGraph(int numberNodesResult) throws Exception {
        AbstractGraphCreator.AbstractGraph graph = AbstractGraphCreator.createGraph(numberNodesResult);
        if(numberNodesResult<=0){
            Assert.assertNull(graph);
        } else {
            Assert.assertEquals(graph.NUMBER_NODES,numberNodesResult);
        }
    }

    @DataProvider(name = "nodes")
    private Object[][] points() {
        return new Object[][]{
                {5},{1},{-1},{0}
        };
    }

}