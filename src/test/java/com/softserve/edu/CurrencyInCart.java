package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CurrencyInCart {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void befoteTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://taqc-opencart.epizy.com/");
        driver.findElements(By.tagName("button")).get(7).click();
        driver.findElement(By.className("list-inline")).findElement(By.xpath("//a[@title='Shopping Cart']/..")).click();
    }

    @Test
    public void usdInCart() {
        driver.findElements(By.className("btn-group")).get(0).click();
        driver.findElements(By.className("dropdown-menu")).get(0).findElements(By.tagName("li")).get(2).click();
        String price = driver.findElement(By.className("table-responsive")).
                findElements(By.tagName("tbody")).get(0).findElements(By.tagName("td")).get(4).getText();
        char usd = price.charAt(0);
        Assert.assertEquals(usd, '$', "Not Equals");
    }

    @Test
    public void euroInCart() {
        driver.findElements(By.className("btn-group")).get(0).click();
        driver.findElements(By.className("dropdown-menu")).get(0).findElements(By.tagName("li")).get(0).click();
        String price1 = driver.findElement(By.className("table-responsive")).
                findElements(By.tagName("tbody")).get(0).findElements(By.tagName("td")).get(4).getText();
        char euro = price1.charAt(6);
        Assert.assertEquals(euro, '€', "Not Equals");
    }

    @Test
    public void pundInCart() {
        driver.findElements(By.className("btn-group")).get(0).click();
        driver.findElements(By.className("dropdown-menu")).get(0).findElements(By.tagName("li")).get(1).click();
        String price2 = driver.findElement(By.className("table-responsive")).
                findElements(By.tagName("tbody")).get(0).findElements(By.tagName("td")).get(4).getText();
        char pound = price2.charAt(0);
        Assert.assertEquals(pound, '£', "Not Equals");
    }


}

