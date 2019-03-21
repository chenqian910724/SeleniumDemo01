package com.chenqian.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginE {
    WebDriver driver;
    WebDriverWait wait;
    long time= System.currentTimeMillis();
    @BeforeTest
    public void openfire(){
        System.setProperty("webdriver.chrome.driver","D:\\Netease\\SeleniumDemo2\\driver\\chromedriver.exe");
        driver=new ChromeDriver();

     //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void logE(){
        driver.get("http://mail.163.com");
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@id,'x-URS-iframe')]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'x-URS-iframe')]")));
        driver.findElement(By.name("email")).sendKeys("m15094008052");
        driver.findElement(By.name("password")).sendKeys("chenqian910724");
        driver.findElement(By.id("dologin")) .click();
        driver.switchTo().defaultContent();
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText("退出"))));
        String text = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");
       driver.findElement(By.linkText("退出")).click();



    }
    @AfterTest
    public void closedchrome()throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
