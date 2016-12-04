package com.epam.javacourses2016.task14;

import java.util.Collection;

/**
 * На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
 * 1) Добавление/удаление числа.
 * 2) Поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
 */
public abstract class AbstractCollectionCreator {

    /**
     * @param required Тип, которым типизируется создаваемая коллекция.
     * @return Коллекция для хранения чисел с поддержкой операций добавления/удаления и поиска числа.
     */
    public static  <T extends Number> NumberCollection<T> createCollection(Class<T> required){
        return new MyCollection<T>();
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
}
