package com.chenqian.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistEmail {

//    WebDriver driver;
//    @BeforeTest
//    public void openchrome() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Netease\\aaa\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//    }
//    @Test
//    public void iframeTest() throws InterruptedException {
//        //iframe窗口的跳转
//        driver.get("E:\\7777\\webdriver_demo\\selenium_html\\index.html");
//        driver.findElement(By.id("user")).sendKeys("this is iframe");
//        Thread.sleep(3000);
//        //把控制权转交给iframe界面，，id或者属性值为aa的iframe窗口,下面一个方法是没有Id和属性值的情况
//        driver.switchTo().frame("aa");
//        //点击iframe窗口的Linktext为baidu的按钮
//        driver.findElement(By.linkText("baidu")).click();
//        //把控制权回到顶部页面
//        driver.switchTo().defaultContent();
//        Thread.sleep(3000);
//        driver.findElement(By.id("user")).clear();
//        driver.findElement(By.id("user")).sendKeys("this is another iframe");
//    }
//    @Test
//    public void iframeTest1() throws InterruptedException {
//        //iframe窗口的跳转，运行整个方法时，由于是testng来执行的脚本，是根据方法名的ASKI值来先后执行的，所以是先运行iframetest
//        driver.get("E:\\7777\\webdriver_demo\\selenium_html");
//        driver.findElement(By.id("user")).sendKeys("this is iframe");
//        //把控制权转交给iframe界面，如果没有id和属性值，把整个iframe当作一个元素来定位
//        WebElement element= driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
//        driver.switchTo().frame(element);
//        //点击iframe窗口的Linktext为baidu的按钮
//        driver.findElement(By.linkText("baidu")).click();
//        //把控制权回到顶部页面,任何界面回到顶部页面都是defaultContent方法，回到另一个页面都是frame方法，只能一级一级的跳
//        driver.switchTo().defaultContent();
//        Thread.sleep(3000);
//        driver.findElement(By.id("user")).clear();
//        driver.findElement(By.id("user")).sendKeys("this is another iframe");
//    }
//    @Test
//    public void selectTest() throws InterruptedException {
//        //下拉框选择,有如下三种方式获取定位，index,value,visibleText
//        driver.get("E:\\7777\\webdriver_demo\\selenium_html");
//        WebElement element = driver.findElement(By.id("moreSelect"));
//        Thread.sleep(3000);
//        Select select = new Select(element);
//        select.selectByIndex(3);
//        //select.selectByValue("xiaomi");       //value值
//        //select.selectByVisibleText("huawei");  //文本值
//    }
//
//    @Test
//    public void WindTest() throws InterruptedException {
//        //多窗口的处理
//        driver.get("E:\\7777\\webdriver_demo\\selenium_html");
//        Thread.sleep(30000);
//        driver.findElement(By.xpath("//*[@id=\"open\"]/a")).click();
//        //获取第1个页面的句柄
//        String handle1 = driver.getWindowHandle();
//        //for循环判定是否为第一页面句柄如果不是就控制权转交
//        for (String handles : driver.getWindowHandles()) {
//            if (handles.equals(handle1)) {
//                continue;
//            }
//            driver.switchTo().window(handles); //将控制权转交给这个页面
//        }
//        //下面是采用迭代器的方式实现for循环
///*        Set<String> allHandle=driver.getWindowHandles();
//        Iterator iterator=allHandle.iterator();
//        for (int i=0;i<allHandle.size();i++){
//            String handle=iterator.next().toString();
//            if (handle1.equals(handle));
//            continue;
//            driver.switchTo().window(handle);
//        }*/
//    }
//    @Test
//    public void moreSelectTest() {
//        //下拉框多选
//        driver.get("E:\\7777\\webdriver_demo\\selenium_html");
//        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
//        List<WebElement> list=element.findElements(By.tagName("option"));
//        Actions actions=new Actions(driver);
//        //按住shift键，点击第二个和第四个来执行
//        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(3)).perform();
//    }
//    @Test
//    public void upload() {
//        //文件上传,文件下载在另一个class中
//        driver.get("E:\\7777\\webdriver_demo\\selenium_html");
//        WebElement element = driver.findElement(By.id("load"));
//        element.sendKeys("D:\\testing\\LoadRunner.pdf");
//    }



    WebDriver driver;
    long time= System.currentTimeMillis();
    @BeforeTest
    public void openfire(){

        System.setProperty("webdriver.chrome.driver","D:\\Netease\\SeleniumDemo2\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void regist(){
        driver.get("http://mail.163.com");
//        List<WebElement> element =driver.findElements(By.tagName("iframe"));
//        element.size();
//        driver.switchTo().frame(element.get(0));   //去注册按钮在iframe中，driver转交给iframe控制权
        //*[@id="x-URS-iframe1552978641295.3027"]
        driver.findElement(By.xpath("//iframe[contains(@id,'x-URS-iframe')]"));

        List<WebElement> element =driver.findElements(By.xpath("//iframe[contains(@id,'x-URS-iframe')]"));
        element.size();
        driver.switchTo().frame(element.get(0));
        driver.findElement(By.id("changepage")).click();//点击之后跳转到新的页面，然后需要获取句柄
        String handle1=driver.getWindowHandle();    //获取当前页面的句柄
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles); //把控制权转交给第二个页面
        }
        driver.findElement(By.xpath("//*[@id=\"tabsUl\"]/li[1]/a")).click();
        driver.findElement(By.id("nameIpt")).sendKeys("jun"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("pw654321");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("pw654321");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(time/100));
        driver.findElement(By.id("vcodeIpt")).sendKeys("abcd");
        driver.findElement(By.id("sendMainAcodeStg")).click();
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("322143");
    //    driver.findElement(By.className("regForm-item-ct txt-tips")).click();
        driver.findElement(By.id("mainRegA")).click();
        String errorText=driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        Assert.assertEquals(errorText,"验证码不正确，请重新填写");
    }

}
