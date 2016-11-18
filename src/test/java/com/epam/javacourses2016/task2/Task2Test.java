package com.epam.javacourses2016.task2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class Task2Test {

    @Test(enabled = true, dataProvider = "folders")
    public void testTask2(File[] files) {
        //TODO: make some smart test
    }

    @DataProvider(name = "folders")
    private Object[][] files() {
    return null;
    }
}

