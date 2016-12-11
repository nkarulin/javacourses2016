package com.epam.javacourses2016.task13;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class GraphTest {
    @Test(enabled = true, dataProvider = "add-edges")
    public void testAddEdge(int numberNodes, Integer[][] edges,Integer[][]result) throws Exception {
        AbstractGraphCreator.AbstractGraph graph = AbstractGraphCreator.createGraph(numberNodes);
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }
        for (int i = 0; i < result.length; i++) {
            Assert.assertTrue(graph.isExistEdge(result[i][0], result[i][1]));
        }

    }

    @Test(enabled = true, dataProvider = "remove-edges")
    public void testRemoveEdge(int numberNodes, Integer[][] edges, Integer[][] edgesForDel) throws Exception {
        AbstractGraphCreator.AbstractGraph graph = AbstractGraphCreator.createGraph(numberNodes);
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }
        for (int i = 0; i < edgesForDel.length; i++) {
            graph.removeEdge(edgesForDel[i][0], edgesForDel[i][1]);
        }
        for (int i = 0; i < edgesForDel.length; i++) {
            Assert.assertFalse(graph.isExistEdge(edgesForDel[i][0], edgesForDel[i][1]));
        }
    }

    @Test(enabled = true, dataProvider = "exist-edges")
    public void testIsExistEdge(int numberNodes, Integer[][] edges, Integer[][] exist, Boolean[] result) throws Exception {
        AbstractGraphCreator.AbstractGraph graph = AbstractGraphCreator.createGraph(numberNodes);
        List<Boolean> isExistList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }
        for (int i = 0; i < exist.length; i++) {
            isExistList.add(graph.isExistEdge(exist[i][0], exist[i][1]));
        }
        Assert.assertEquals(isExistList, Arrays.asList(result));
    }

    @DataProvider(name = "add-edges")
    public Object[][] addEdges() {
        return new Object[][]{
                {4, new Integer[][]{{4, 2}, {3, 2}, {2, 2}}, new Integer[][]{{4, 2}, {3, 2}, {3, 2}}},
                {3, new Integer[][]{{4, 2}, {3, 2}, {2, 2}}, new Integer[][]{{3, 2}, {2, 2}}},
                {4, new Integer[][]{{4, 2}, {3, 2}, {3, 2}}, new Integer[][]{{4, 2}, {3, 2}}}
        };
    }

    @DataProvider(name = "remove-edges")
    public Object[][] removeEdges() {
        return new Object[][]{
                {4, new Integer[][]{{4, 2}, {3, 2}, {2, 2}}, new Integer[][]{{3, 2}}},
                {3, new Integer[][]{{4, 2}, {3, 2}, {2, 2}}, new Integer[][]{{4, 2}, {3, 2}, {2, 2}}},
                {4, new Integer[][]{{4, 2}, {3, 2}, {3, 2}}, new Integer[][]{{3, 2}}}
        };
    }

    @DataProvider(name = "exist-edges")
    public Object[][] existEdges() {
        return new Object[][]{
                {4, new Integer[][]{{4, 2}, {3, 2}, {2, 2}}, new Integer[][]{{4, 2}, {3, 2}},new Boolean[]{true,true}},
                {3, new Integer[][]{{4, 2}, {3, 2}, {2, 2}}, new Integer[][]{{2, 4}, {2, 2},{1,2}},new Boolean[]{true,true,false}},
                {4, new Integer[][]{{4, 2}, {3, 2}, {3, 2}}, new Integer[][]{{4, 2}, {3, 2}},new Boolean[]{true,true}}
        };
    }
}