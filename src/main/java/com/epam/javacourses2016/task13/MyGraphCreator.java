package com.epam.javacourses2016.task13;

public class MyGraphCreator extends AbstractGraphCreator {
    @Override
    AbstractGraph createGraph(int numberNodes) {
       return new MyGraph(numberNodes);
    }
}
