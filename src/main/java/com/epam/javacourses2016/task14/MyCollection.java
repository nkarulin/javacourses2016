package com.epam.javacourses2016.task14;

import java.util.*;

public class MyCollection<T extends Number> extends AbstractCollection<T> implements AbstractCollectionCreator.NumberCollection<T> {
    private List<T> elementData;

    public MyCollection() {
        elementData = new ArrayList<>();
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
    public Iterator<T> iterator() {
        return elementData.iterator();
    }

    @Override
    public int size() {
        return elementData.size();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return elementData.addAll(c);
    }

    @Override
    public boolean add(T t) {
        return elementData.add(t);
    }
}