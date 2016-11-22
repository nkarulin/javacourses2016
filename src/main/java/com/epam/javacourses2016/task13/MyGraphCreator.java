package com.epam.javacourses2016.task13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elarion on 22.11.2016.
 */
public class MyGraphCreator extends AbstractGraphCreator {
    @Override
    AbstractGraph createGraph(int numberNodes) {
        return new MyGraph(numberNodes);
    }

    class MyGraph extends AbstractGraph {
        List<Edge> edgeMap;

        public MyGraph(int numberNodes) {
            super(numberNodes);
            edgeMap = new ArrayList<>();
        }

        @Override
        public void addEdge(int first, int second) {

        }

        @Override
        public void removeEdge(int first, int second) {

        }

        @Override
        public boolean isExistEdge(int first, int second) {
            return false;
        }


        class Edge {
            int v;
            int w;

            public int getV() {
                return v;
            }

            public void setV(int v) {
                this.v = v;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }
        }
    }
}
