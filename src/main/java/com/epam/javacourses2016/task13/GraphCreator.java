package com.epam.javacourses2016.task13;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class GraphCreator extends AbstractGraphCreator {
    @Override
    AbstractGraph createGraph(int numberNodes) {
        if (numberNodes > 0) {
            return new Graph(numberNodes);
        }
        return null;
    }
}
