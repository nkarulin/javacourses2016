package com.epam.javacourses2016.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class MyNumberCollection<T extends Number> implements AbstractCollectionCreator.NumberCollection<T> {

    private List<T> numberList;

    public MyNumberCollection() {
        numberList = new ArrayList<>();
    }

    @Override
    public T nearest(Number value) {
        double minDif = Double.MAX_VALUE;
        T nearestValue = null;
        for (T curNum : numberList) {
            if (Math.abs(value.doubleValue() - curNum.doubleValue()) < minDif) {
                minDif = Math.abs(value.doubleValue() - curNum.doubleValue());
                nearestValue = curNum;
            }
        }
        return nearestValue;
    }

    @Override
    public int size() {
        return numberList.size();
    }

    @Override
    public boolean isEmpty() {
        return numberList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return numberList.contains(o);
    }

    @Override
    public Iterator iterator() {
        return numberList.iterator();
    }

    @Override
    public Object[] toArray() {
        return numberList.toArray();
    }

    @Override
    public boolean add(T o) {
        return numberList.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return numberList.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return numberList.addAll(c);
    }

    @Override
    public void clear() {
        numberList.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        return numberList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {

        return numberList.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {

        return numberList.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return numberList.toArray(a);
    }
}
