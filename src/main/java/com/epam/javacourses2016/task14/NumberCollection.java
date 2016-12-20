package com.epam.javacourses2016.task14;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by GiulioRM on 12/13/2016.
 */
public class NumberCollection<TNumber extends Number>
        implements  AbstractCollectionCreator.NumberCollection<TNumber>{

    private List<TNumber> numbers;

    public NumberCollection () {
        this.numbers = new ArrayList<TNumber>();
    }

    @Override
    public TNumber nearest(TNumber value) {
        double min = Double.MAX_VALUE;
        TNumber minValue = null;
        for(TNumber number : numbers) {
            double abs = Math.abs(number.doubleValue() - value.doubleValue());
            if (abs < min) {
                min = abs;
                minValue = number;
            }
        }
        return minValue;
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
    public Iterator<TNumber> iterator() {
        return numbers.iterator();
    }

    @Override
    public void forEach(Consumer<? super TNumber> action) {
        numbers.forEach(action);
    }

    @Override
    public Object[] toArray() {
        return numbers.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return numbers.toArray(a);
    }

    @Override
    public boolean add(TNumber tNumber) {
        return numbers.add(tNumber);
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
    public boolean addAll(Collection<? extends TNumber> c) {
        return numbers.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return numbers.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super TNumber> filter) {
        return numbers.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return numbers.retainAll(c);
    }

    @Override
    public void clear() {
        numbers.clear();
    }

    @Override
    public Spliterator<TNumber> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Stream<TNumber> stream() {
        return numbers.stream();
    }

    @Override
    public Stream<TNumber> parallelStream() {
        return numbers.parallelStream();
    }
}
