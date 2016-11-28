package com.epam.javacourses2016.task13;

/**
 * Created by Ivan on 24/11/2016.
 */
public class GraphCreator extends AbstractGraphCreator {

    @Override
    AbstractGraph createGraph(int numberNodes) {
        if(numberNodes<=0){
            return null;
        }
        return new Graph(numberNodes);
    }
}
