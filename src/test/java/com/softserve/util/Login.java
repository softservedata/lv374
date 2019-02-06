package com.softserve.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Login {

    public void login(WebDriver driver) throws InterruptedException {
        driver.get("http://localhost/opencart/upload/index.php?route=account/logout");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("Open@cart.com");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("opencart" + Keys.ENTER);
    }

}
