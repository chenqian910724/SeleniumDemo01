package com.chenqian.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestNg {
    WebDriver driver;
    @Test
    public void openchrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Netease\\SeleniumDemo2\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://www.sina.com.cn/");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"新浪首页");
    }

    @AfterTest
    public void closedchrome()throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
