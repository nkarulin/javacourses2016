package com.epam.javacourses2016.task14;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by kodoo on 13.11.16.
 */
public class NumberCollectionTest {

    @Test(enabled = true, dataProvider = "numbers")
    public void testNearest(Number[] numbers, Number value, Number result) throws Exception {
        AbstractCollectionCreator.NumberCollection<Number> collection = AbstractCollectionCreator.createCollection(Number.class);
        for (Number n: numbers) collection.add(n);
        Number min = collection.nearest(value);
        Assert.assertEquals(min, result);
    }

    @DataProvider(name = "numbers")
    public Object[][] collection() {
        return new Object[][]{
                {new Number[]{1, 2, 6, 1, 4}, 5, 6},
                {new Number[]{1, 1, 1, 1, 3}, 2, 1},
                {new Number[]{1.0, 2.7, 6.8, 1.1, 4.4}, 5.0, 4.4},
        };
    }

}