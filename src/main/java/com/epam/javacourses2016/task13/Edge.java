package com.epam.javacourses2016.task13;

/**
 * Created by Vasya on 25.11.2016.
 */
public class Edge {
    private int first;
    private int second;


    public Edge(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean is(int first, int second) {
        if (this.first == first && this.second == second) {
            return true;
        } else {
            return false;
        }
    }
}
