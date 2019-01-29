package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChangeCurrency {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://taqc-opencart.epizy.com/");
        driver.findElement(By.cssSelector("a[href*='id=43']")).click();
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void forUSDTest(){
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='USD']")).click();
        char actual = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2")).getText().charAt(0);
        System.out.println(actual);
        Assert.assertEquals(actual,'$',"NotEquals");

    }


    @Test
    public void forEuroTest(){
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='EUR']")).click();
        char actual = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2")).getText().charAt(6);
        System.out.println(actual);
        Assert.assertEquals(actual,'€',"NotEquals");

    }

    @Test
    public void forPoundTest(){
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='GBP']")).click();
        char actual = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2")).getText().charAt(0);
        System.out.println(actual);
        Assert.assertEquals(actual,'£',"NotEquals");


    }

}
