package com.chenqian.day1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class JStest {
    WebDriver driver;
    @Test
    public void jsOPen() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Netease\\SeleniumDemo2\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //直接在下面操作value的值，执行js脚本,在id为search=key的地方把value的值输入“selenium怎么学”
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(5000);
        driver.quit();
    }
}
