package com.epam.javacourses2016.task14;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodoo on 13.11.16.
 */
public class NumberCollectionTest {

    @Test(enabled = true, dataProvider = "numbersForTest")
    public void testNearest(double[] array, double nubmer, double result) throws Exception {
        AbstractCollectionCreator collectionCreator = new MyCollectionCreator();
        AbstractCollectionCreator.NumberCollection<Double> collection = collectionCreator.createCollection(Double.class);

        List<Double> data = doubleToCollection(array);
        collection.addAll(data);

        Assert.assertEquals(collection.nearest(nubmer), result);
    }

    private List<Double> doubleToCollection(double[] array) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (double d : array) {
            arrayList.add(d);
        }
        return arrayList;
    }

    @DataProvider(name = "numbersForTest")
    public Object[][] numbersForTest() {
        return new Object[][]{
                {new double[]{1d, 2d, 3d, 4d, 5d}, 6, 5},
                {new double[]{-1d, -2d, -3d, -4d, -5d}, -6, -5},
                {new double[]{-2d, -1d, 0d, 2d, 3d}, 0.4, 0}
        };
    }
}