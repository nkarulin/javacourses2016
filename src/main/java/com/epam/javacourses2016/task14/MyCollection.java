package com.epam.javacourses2016.task14;

import java.util.*;

public class MyCollection<T extends Number> extends AbstractCollection<T> implements AbstractCollectionCreator.NumberCollection<T> {
    private List<T> numbers;

    public MyCollection() {
        numbers = new ArrayList<T>();
    }

    @Override
    public Number nearest(Number value) {
        ListIterator iterator = numbers.listIterator();
        T nearest = (T) iterator.next();

        while(iterator.hasNext()){
            T num = (T) iterator.next();
            if(Math.abs(value.doubleValue()-nearest.doubleValue())>Math.abs(value.doubleValue()-num.doubleValue())){
                nearest = num;
            }
        }


        return nearest;
    }

    @Override
    public boolean remove(Object o) {
        return numbers.remove(o);
    }

    @Override
    public boolean add(T t) {
        return numbers.add(t);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Iterator<T> iterator() {
        return numbers.iterator();
    }
}
