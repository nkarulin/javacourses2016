package com.epam.javacourses2016.task18;

/**
 * Created by Рамиль on 12.12.2016.
 */
public class Pair {
    private int width;
    private int height;


    public Pair(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Pair(Pair pair) {
        this.height = pair.getHeight();
        this.width = pair.getWidth();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
