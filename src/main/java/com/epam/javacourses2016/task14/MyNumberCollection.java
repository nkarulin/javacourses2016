package com.epam.javacourses2016.task14;

import java.util.*;

/**
 * Created by Tatyana on 10.12.2016.
 */
public class MyNumberCollection<T extends Number> implements AbstractCollectionCreator.NumberCollection<T> {

    private List<T> list;


    public MyNumberCollection() {
        list = new ArrayList<>();
    }


    @Override
    public T nearest(T value) {
        T nearValue = null;
        double dif = value.doubleValue()*100000;

        for (T curr : list) {
            if (Math.abs(value.doubleValue() - curr.doubleValue()) < dif) {
                dif=Math.abs(value.doubleValue() - curr.doubleValue());
                nearValue = curr;
            }

        }
        return nearValue;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return list.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }
}
