package com.epam.javacourses2016.task14;

public class CollectionCreator<T extends Number> extends AbstractCollectionCreator{

    private ListNumberCollection<T> myList;

    @Override
    <T extends Number> NumberCollection<T> createCollection(Class<T> required) {
        return new ListNumberCollection<T>();
    }
}
