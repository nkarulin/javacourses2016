package com.epam.javacourses2016.task14;

/**
 * Created by Elarion on 25.11.2016.
 */
class MyCollectionCreator extends AbstractCollectionCreator {
    @Override
    <T extends Number> NumberCollection<T> createCollection(Class<T> required) {
        return new MyCollection<>();
    }
}