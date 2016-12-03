package com.epam.javacourses2016.task14;

public class MyCollectionCreator extends AbstractCollectionCreator {
    @Override
    <T extends Number> NumberCollection<T> createCollection(Class<T> required) {
        return new MyCollection<>();
    }
}
