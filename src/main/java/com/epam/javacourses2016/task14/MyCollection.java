package com.epam.javacourses2016.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Elarion on 25.11.2016.
 */
public class MyCollection<T extends Number> implements AbstractCollectionCreator.NumberCollection<T> {
    List<T> elementData;

    public MyCollection() {
        elementData = new ArrayList<T>();
    }

    @Override
    public T nearest(T value) {
        int index = 0;
        double difference = Math.abs(elementData.get(index).doubleValue() - value.doubleValue());
        double tempDifference = difference;

        for (int i = 0; i < elementData.size(); i++) {

            tempDifference = Math.abs(elementData.get(i).doubleValue() - value.doubleValue());
            if (difference > tempDifference) {
                difference = tempDifference;
                index = i;
            }
        }

        return (T) elementData.get(index);
    }

    @Override
    public int size() {
        return elementData.size();
    }

    @Override
    public boolean isEmpty() {
        return elementData.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elementData.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return elementData.iterator();
    }

    @Override
    public Object[] toArray() {
        return elementData.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) elementData.toArray();
    }

    @Override
    public boolean add(T t) {
        return elementData.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return elementData.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elementData.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return elementData.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elementData.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return elementData.retainAll(c);
    }

    @Override
    public void clear() {
        for (T element : elementData) {
            element = null;
        }
    }
}