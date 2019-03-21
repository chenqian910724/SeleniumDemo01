package com.chenqian.day3;

import org.testng.annotations.*;

public class Concurrency
{
    @BeforeTest
    public void beforetest(){ System.out.println("This is a befortest");}
    @BeforeMethod
    public void beforemethod1(){
        System.out.println("This is a beformethod1");
    }
    @AfterMethod
    public void afteremethod1(){
        System.out.println("This is a aftermethod1");
    }
    @Test
    public void testTest1(){
        System.out.println("1111111111111111");
    }
    @Test
    public void testTest2(){
        System.out.println("22222222222222222");
    }
    @Test
    public void testTest3(){
        System.out.println("33333333333333");
    }
    @Test
    public void testTest4(){
        System.out.println("44444444444444444");
    }
    @AfterTest
    public void aftertest(){ System.out.println("This is a aftertest");}
}
