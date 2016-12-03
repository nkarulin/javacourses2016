package com.epam.javacourses2016.task14;

import java.util.*;

public class MyCollection<T extends Number> implements AbstractCollectionCreator.NumberCollection<T> {
    private List<T> myCollection;

    public MyCollection() {
        myCollection = new ArrayList<>();
    }

    @Override
    public T nearest(T value) {
        HashMap<Double, T> differences = new HashMap<>();
        for (T number : myCollection) {
            differences.put(Math.abs(number.doubleValue() - value.doubleValue()), number);
        }
        double min = Collections.min(differences.keySet());
        return differences.get(min);
    }

    @Override
    public int size() {
        return myCollection.size();
    }

    @Override
    public boolean isEmpty() {
        return myCollection.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return myCollection.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return myCollection.iterator();
    }

    @Override
    public Object[] toArray() {
        return myCollection.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return myCollection.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return myCollection.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return myCollection.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return myCollection.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return myCollection.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return myCollection.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return myCollection.retainAll(c);
    }

    @Override
    public void clear() {
        myCollection.clear();
    }
}
