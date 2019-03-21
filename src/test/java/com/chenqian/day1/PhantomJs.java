package com.chenqian.day1;


import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomJs {
    PhantomJSDriver driver;
@Test
    public void pjs() throws InterruptedException {
    System.setProperty("phantomjs.binary.path","D:\\Netease\\SeleniumDemo2\\driver\\phantomjs.exe");
    driver=new PhantomJSDriver();
    driver.get("https://www.baidu.com");
    String title=driver.getTitle();
    System.out.println(title);
    driver.quit();
}
}
