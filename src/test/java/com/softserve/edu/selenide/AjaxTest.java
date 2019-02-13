package com.softserve.edu.selenide;

//import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byCssSelector;
//import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static org.testng.Assert.assertTrue;

//import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

public class AjaxTest {
 
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
        		this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10;
        //
        open("https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/paging/");
    }
 
    @Test
    public void AjaxIframePage() throws Exception {
    	executeJavaScript("arguments[0].scrollIntoView(true);", $("#using-paging-with-other-data-processing-plugins"));
    	switchTo().frame($("#grid-paging-remote-paging-demo-pane-preview iframe"));
    	//switchTo().innerFrame(frames)
    	$(byXpath("//td[text()='Nevada']")).waitUntil(text("Nevada"), 4000);
    	//Thread.sleep(3000);
    	SelenideElement tdNevadaFirstData = $(byXpath("//td[text()='Nevada']/preceding-sibling::td[2]"));
        System.out.println("tdNevadaFirstData.getText() = " + tdNevadaFirstData.getText());
        //
    	//$(byText("Incoming Tests")).click();
    	//$(".login a[href*='login']").click();
        //$("#username").setValue("username");
        //$("#password").setValue("Hello");
        //takeScreenShot("complex-form.png");
        //$("#password").shouldHave(text("Hello"));
        //$("#password").shouldHave(value("Hello")); // Assert
        //assertTrue($$("#paymentScheduleTable").size() == 0);
    	//
    	Thread.sleep(2000);
    } 
 
}
