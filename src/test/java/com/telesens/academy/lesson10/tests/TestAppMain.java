package com.telesens.academy.lesson10.tests;

import com.telesens.academy.lesson10.AppMain;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAppMain {
    @Test
    public void testGetHello (){
        System.out.println("Try test");
        String actual = AppMain.getHello();
        String expected = "Hello";
        Assert.assertEquals(actual,expected);
        //assert actual.equals(expected);
    }
}
