package com.epam.javacourses2016.task13;

/**
 * Created by Elarion on 25.11.2016.
 */
public class MyGraphCreator extends AbstractGraphCreator{
    @Override
    public MyGraph createGraph(int numberNodes) {
        return new MyGraph(10);
    }
}
