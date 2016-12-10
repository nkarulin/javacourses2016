package com.epam.javacourses2016.task14;

import java.util.*;

/**
 * Created by Vasya on 25.11.2016.
 */
public class CollectionForNumber<T extends Number> implements AbstractCollectionCreator.NumberCollection<T> {
    private List<T> numbers;

    public CollectionForNumber(List<T> numbers) {
        this.numbers = new ArrayList<T>();
        this.numbers.addAll(numbers);
    }

    public CollectionForNumber(Class<T> required) {
        this.numbers = new <T>ArrayList();
    }

    /**
     * @param value Эталонное значение.
     * @return Число, наиболее близкое к заданному.
     */
    @Override
    public T nearest(T value) {
        T prev = this.numbers.get(0);
        T next;
        for (int i=1; i<numbers.size();i++) {
            next = numbers.get(i);
            if (Math.abs(value.doubleValue() - next.doubleValue()) < Math.abs(value.doubleValue() - prev.doubleValue())) {
                prev = next;
            }
        }
        return prev;
    }


    @Override
    public int size() {
        return numbers.size();
    }


    @Override
    public boolean isEmpty() {
        return numbers.isEmpty();
    }


    @Override
    public boolean contains(Object o) {
        return numbers.contains(o);
    }


    @Override
    public Iterator<T> iterator() {
        return numbers.iterator();
    }


    @Override
    public Object[] toArray() {
        return numbers.toArray();
    }


    @Override
    public <T1> T1[] toArray(T1[] a) {
        return numbers.toArray(a);
    }


    @Override
    public boolean add(T t) {
        return numbers.add(t);
    }


    @Override
    public boolean remove(Object o) {
        return numbers.remove(o);
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return numbers.containsAll(c);
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        return numbers.addAll(c);
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        return numbers.removeAll(c);
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return numbers.retainAll(c);
    }


    @Override
    public void clear() {
        numbers.clear();
    }
}