package com.softserve.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProduct {

    public void addProductToCart(String product, WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath(product)).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#button-cart")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@class='img-responsive']/..")).click();
    }

}
