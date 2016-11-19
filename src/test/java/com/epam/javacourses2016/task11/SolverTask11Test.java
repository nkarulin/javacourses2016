package com.epam.javacourses2016.task11;

import com.epam.javacourses2016.task8.SolverTask8;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class SolverTask11Test {
    @Test(enabled = true, dataProvider = "peoples")
    public void testEmulate(ArrayList<String> list, String result) throws Exception {
        SolverTask11 task11 = new SolverTask11();
        Assert.assertEquals(task11.emulate(list), result);
    }

    @Test(enabled = true, dataProvider = "linked-peoples")
    public void testEmulate1(LinkedList<String> list, String result) throws Exception {
        SolverTask11 task11 = new SolverTask11();
        Assert.assertEquals(task11.emulate(list), result);
    }

    @DataProvider(name = "peoples")
    private Object[][] peoples() {
        return new Object[][] {
                { new ArrayList<String>(){
                    {
                        add("Vanya");
                        add("Nikita");//
                        add("Pasha");//
                        add("Alex");//
                        add("Maxim");//
                        add("Anton");//
                        add("Petya");//
                        add("Dima");//
                    }
                },
                        "Vanya"
                },
                { new ArrayList<String>(){
                    {
                        add("Anton");//
                        add("Petya");//
                        add("Dima");
                        add("Vanya");//
                        add("Nikita");//
                    }

                },
                        "Dima"
                }


        };
    }

    @DataProvider(name = "linked-peoples")
    private Object[][] linkedPeoples() {
        return new Object[][] {
                { new LinkedList<String>(){
                    {
                        add("Vanya");
                        add("Nikita");
                        add("Pasha");
                        add("Alex");
                        add("Maxim");
                        add("Anton");
                        add("Petya");
                        add("Dima");
                    }

                },
                        "Vanya"
                },
                { new LinkedList<String>(){
                    {
                        add("Anton");
                        add("Petya");
                        add("Dima");
                        add("Vanya");
                        add("Nikita");
                    }

                },
                        "Dima"
                }


        };
    }

}