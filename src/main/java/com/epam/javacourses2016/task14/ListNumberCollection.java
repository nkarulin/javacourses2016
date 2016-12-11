package com.epam.javacourses2016.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListNumberCollection<T extends Number> extends CollectionCreator implements AbstractCollectionCreator.NumberCollection<T> {
    private List<T> list;

    public ListNumberCollection() {
        list = new ArrayList<>();
    }

    public T nearest(T value) {
        Iterator iterator = list.iterator();
        T min = (T) iterator.next();

        while (iterator.hasNext()) {
            T elem = (T) iterator.next();
            if (Math.abs(elem.doubleValue() - value.doubleValue()) < Math.abs(min.doubleValue() - value.doubleValue())) {
                min = elem;
            }
        }
        return min;
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
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public boolean add(T o) {
        return list.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return list.addAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return list.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return list.contains(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }
}
