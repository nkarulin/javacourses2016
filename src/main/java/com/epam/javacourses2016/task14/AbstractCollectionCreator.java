package com.epam.javacourses2016.task14;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
 *       1) Добавление/удаление числа.
 *       2) Поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
 */
public abstract class AbstractCollectionCreator {

    /**
     * @param required Тип, которым типизируется создаваемая коллекция.
     * @return Коллекция для хранения чисел с поддержкой операций добавления/удаления и поиска числа.
     */
    public static  <T extends Number> NumberCollection<T> createCollection(Class<T> required){
        return new MyNumberCollection<T>();
    }

    /**
     * Коллекция для хранения чисел.
     */
    interface NumberCollection<T extends Number> extends Collection<T> {

        /**
         * @param value Эталонное значение.
         * @return Число, наиболее близкое к заданному.
         */
        T nearest(T value);
    }

    private static class MyNumberCollection<T extends Number> implements NumberCollection{

        private int size = 0;
        private Number[] elements = {};

        public MyNumberCollection() {
        }

        @Override
        public Number nearest(Number value) {
            Double min = Math.abs(value.doubleValue() - elements[0].doubleValue());
            Number nearest = elements[0];
            for(Number num: elements){
                Double difference = Math.abs(value.doubleValue() - num.doubleValue());
                if (difference < min) {
                    min = difference;
                    nearest = num;
                }
            }
            return nearest;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return (size == 0);
        }

        @Override
        public boolean contains(Object o) {
                return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return elements;
        }

        @Override
        public boolean add(Object o) {
            size++;
            elements = Arrays.copyOf(elements, size);
            elements[size - 1] = (Number) o;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            if (o == null) {
                for (int index = 0; index < size; index++)
                    if (elements[index] == null) {
                        fastRemove(index);
                        return true;
                    }
            } else {
                for (int index = 0; index < size; index++)
                    if (o.equals(elements[index])) {
                        fastRemove(index);
                        return true;
                    }
            }
            return false;
        }

        private void fastRemove(int index) {
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(elements, index+1, elements, index,
                        numMoved);
            elements[--size] = null; // clear to let GC do its work
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }
    }
}
