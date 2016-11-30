package com.epam.javacourses2016.task14;

/**
 * Created by Рамиль on 30.11.2016.
 */
public class CollectionCreator<T extends Number> extends AbstractCollectionCreator {

    @Override
    <T extends Number> NumberCollection<T> createCollection(Class<T> required) {
        return new MyNumberCollection<T>();
    }
}
