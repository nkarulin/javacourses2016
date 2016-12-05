package com.epam.javacourses2016.task14;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User on 05.12.2016.
 */
public class MyNumberCollection<T extends Number> extends AbstractCollection<T> implements AbstractCollectionCreator.NumberCollection<T>  {

    private List<T> tList;

    public MyNumberCollection() {
        tList = new ArrayList<>();
    }

    @Override
    public T nearest(T value) {
        double mindistance = Double.MAX_VALUE;
        T result = null;
        for(T t : tList) {
            double distance = Math.abs(t.doubleValue() - value.doubleValue());
            if(distance < mindistance) {
                mindistance = distance;
                result = t;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return tList.iterator();
    }

    @Override
    public int size() {
        return tList.size();
    }

    @Override
    public boolean add(T t) {
        return tList.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return tList.remove(o);
    }
}
