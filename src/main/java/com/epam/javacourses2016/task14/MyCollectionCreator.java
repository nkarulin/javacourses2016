package com.epam.javacourses2016.task14;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by n on 15.12.2016.
 */
public class MyCollectionCreator<T extends Number> extends AbstractCollection<T> implements AbstractCollectionCreator.NumberCollection<T> {
    private List<T> list;

    public MyCollectionCreator() {
        list = new ArrayList();
    }

    @Override
    public T nearest(T value) {
        int index = 0;
        double min = Math.abs(list.get(0).doubleValue() - value.doubleValue());
        for (int i = 1; i < list.size(); i++) {
            if (Math.abs(list.get(i).doubleValue() - value.doubleValue()) < min) {
                min = Math.abs(list.get(i).doubleValue() - value.doubleValue());
                index = i;
            }
        }
        return (T) list.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean add(T t) {
        return list.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }
}
