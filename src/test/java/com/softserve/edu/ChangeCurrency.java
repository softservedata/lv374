package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChangeCurrency {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void befoteTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://taqc-opencart.epizy.com/");
    }

//    @AfterMethod
//    public void afterTest(){
//        driver.quit();
//    }

    @Test
    public void forUSDTest(){
        driver.findElements(By.className("caption")).get(0).findElement(By.tagName("a")).click();
        driver.findElements(By.className("btn-group")).get(0).click();
        driver.findElements(By.className("dropdown-menu")).get(0).findElements(By.tagName("li")).get(2).click();
        String usd = driver.findElements(By.className("list-unstyled")).get(9).findElement(By.tagName("h2")).getText();
        char actual = usd.charAt(0);
        System.out.println(actual);
        Assert.assertEquals(actual,'$',"NotEquals");

    }


    @Test
    public void forEuroTest(){
        driver.findElements(By.className("caption")).get(0).findElement(By.tagName("a")).click();
        driver.findElements(By.className("btn-group")).get(0).click();
        driver.findElements(By.className("dropdown-menu")).get(0).findElements(By.tagName("li")).get(0).click();
        String euro = driver.findElements(By.className("list-unstyled")).get(9).findElement(By.tagName("h2")).getText();
        char actual = euro.charAt(6);
        System.out.println(actual);
        Assert.assertEquals(actual,'€',"NotEquals");

    }

    @Test
    public void forPoundTest(){
        driver.findElements(By.className("caption")).get(0).findElement(By.tagName("a")).click();
        driver.findElements(By.className("btn-group")).get(0).click();
        driver.findElements(By.className("dropdown-menu")).get(0).findElements(By.tagName("li")).get(1).click();
        String pound = driver.findElements(By.className("list-unstyled")).get(9).findElement(By.tagName("h2")).getText();
        char actual = pound.charAt(0);
        System.out.println(actual);
        Assert.assertEquals(actual,'£',"NotEquals");


    }

}
