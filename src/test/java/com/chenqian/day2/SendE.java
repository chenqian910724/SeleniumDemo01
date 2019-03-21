package com.chenqian.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendE {
    WebDriver driver;
    WebDriverWait wait;
    long time= System.currentTimeMillis();
    @BeforeTest
    public void openfire(){
        System.setProperty("webdriver.chrome.driver","D:\\Netease\\SeleniumDemo2\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")));
        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        driver.findElement(By.xpath("//*[@aria-label=\"收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开\"]")).sendKeys("m15094008052@163.com");
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("这是主题");
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\Administrator\\Desktop\\吸烟.png");
        driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
        driver.findElement(By.xpath("/html/body")).sendKeys("这是正文");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()=\"发送\"]")).click();

    }
    @AfterTest
    public void closedchrome()throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
