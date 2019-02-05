package com.softserve.edu;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Class OpencartTest consists of tests for testing the registration page
 * for the site Opencart.
 * There are tests for checking if user can be registered:
 * 1)with no data entered, but clicked on Privacy Policy checkbox;
 * 2)with first name consists digits
 * 3)with first name length is longer than 32 symbols;
 * 4)with invalid email address entered (without a dot);
 * 5)with valid data entered;
 * 6)without agree to the Privacy Policy (no click on the Privacy Policy checkbox);
 */
public class OpencartTest {

    private WebDriver driver;
    private EmailRandomizer emailRandomizer = new EmailRandomizer();

    //"BeforeClass" annotation opens chrome browser before execution the all tests in the class.
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\juliaa_sha\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //"AfterClass" annotation closes chrome browser when the all tests in the class will be executed.
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //"BeforeMethod" annotation opens the main page before executing each test.
    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://localhost/index.php");
    }


    //"AfterMethod" annotation logs out the user after executing each test.
    @AfterMethod
    public void afterMethod() {
        driver.get("http://localhost/index.php?route=account/logout");
    }

    /**
     * Negative test.
     * Used technique: Decision Tables.
     * This test checks if user can be registered
     * with empty fields.
     */
    @Test
    public void checkIfCanRegisterWithNoDataEntered() throws Exception {

        //Click on "My Account" to open dropdown menu
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        Thread.sleep(1000);//For demonstration only

        //Click on "Register" label
        driver.findElement(By.cssSelector("a[href*='register']")).click();
        Thread.sleep(1000);//For demonstration only

        //Click on Privacy Policy checkbox
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(1000);//For demonstration only

        //Click on "Continue" button
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(1000);//For demonstration only

        //Check if actual result contains needed message
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'text-danger')]")).getText(),
                "First Name must be between 1 and 32 characters!",
                "Test skipped the First Name field or registered new user with no data entered");


    }

    //Current method is for using selectByVisibleText method.
    public Select getSelect(String parameter) {
        Select select = new Select(driver.findElement(By.cssSelector(parameter)));
        return select;
    }

    /**
     * Positive test.
     * Used technique: Decision Tables.
     * This test checks if user can be registered
     * with valid data entered in all fields.
     */
    @Test
    public void checkIfUserCanBeRegisteredWithValidDataEntered() throws Exception {

        //Click on "My Account" to open dropdown menu
        driver.findElement(By.cssSelector(".fa.fa-user")).click();

        //Click on "Register" label
        driver.findElement(By.cssSelector("a[href*='register']")).click();

        //Enter first name
        driver.findElement(By.cssSelector("#input-firstname")).click();
        driver.findElement(By.cssSelector("#input-firstname")).clear();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Anna");

        //Enter last name
        driver.findElement(By.cssSelector("#input-lastname")).click();
        driver.findElement(By.cssSelector("#input-lastname")).clear();
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Smith");
        Thread.sleep(1000);//For demonstration only

        //Enter email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys(emailRandomizer.getSaltString() + "@gmail.com");
        Thread.sleep(1000);//For demonstration only

        //Enter telephone
        driver.findElement(By.cssSelector("#input-telephone")).click();
        driver.findElement(By.cssSelector("#input-telephone")).clear();
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("+380 (98) 123 45 67");

        //Enter fax
        driver.findElement(By.cssSelector("#input-fax")).click();
        driver.findElement(By.cssSelector("#input-fax")).clear();
        driver.findElement(By.cssSelector("#input-fax")).sendKeys("11-22-33");
        Thread.sleep(1000);//For demonstration only

        //Enter company
        driver.findElement(By.cssSelector("#input-company")).click();
        driver.findElement(By.cssSelector("#input-company")).clear();
        driver.findElement(By.cssSelector("#input-company")).sendKeys("SoftServe");

        //Enter address 1
        driver.findElement(By.cssSelector("#input-address-1")).click();
        driver.findElement(By.cssSelector("#input-address-1")).clear();
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("SoftServe");
        Thread.sleep(1000);//For demonstration only

        //Enter address 2
        driver.findElement(By.cssSelector("#input-address-2")).click();
        driver.findElement(By.cssSelector("#input-address-2")).clear();
        driver.findElement(By.cssSelector("#input-address-2")).sendKeys("SoftServe 2");

        //Enter city
        driver.findElement(By.cssSelector("#input-city")).click();
        driver.findElement(By.cssSelector("#input-city")).clear();
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Lviv");
        Thread.sleep(1000);//For demonstration only

        //Enter post code
        driver.findElement(By.cssSelector("#input-postcode")).click();
        driver.findElement(By.cssSelector("#input-postcode")).clear();
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("79000");
        Thread.sleep(1000);//For demonstration only

        //Choose country
        driver.findElement(By.cssSelector("#input-country")).click();
        getSelect("#input-country").selectByVisibleText("Ukraine");
        Thread.sleep(1000);//For demonstration only

        //Choose region/state
        driver.findElement(By.cssSelector("#input-zone")).click();
        getSelect("#input-zone").selectByVisibleText("L'vivs'ka Oblast'");
        Thread.sleep(1000);//For demonstration only

        //Enter password
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Ss*Jj&1*2#3");

        //Enter password confirm
        driver.findElement(By.cssSelector("#input-confirm")).click();
        driver.findElement(By.cssSelector("#input-confirm")).clear();
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Ss*Jj&1*2#3");
        Thread.sleep(1000);//For demonstration only

        //Click on Privacy Policy checkbox
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(1000);//For demonstration only

        //Click on "Continue" button
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Actual result that we need
        String actual = driver.findElement(By.xpath("//div[contains(@id, 'content')]")).getText();

        //Check if actual result contains needed message
        Assert.assertTrue(actual.contains("Your Account Has Been Created!"),
                "An account has not been created.");
    }

    /**
     * Negative test.
     * Used technique: Decision Table.
     * This test checks if user can be registered
     * without clicking on Privacy Policy check box.
     */
    @Test
    public void checkIfUserCanBeRegisteredWithoutClickOnPrivacyPolicy() throws Exception {

        //Click on "My Account" to open dropdown menu
        driver.findElement(By.cssSelector(".fa.fa-user")).click();

        //Click on "Register" label
        driver.findElement(By.cssSelector("a[href*='register']")).click();

        //Enter first name
        driver.findElement(By.cssSelector("#input-firstname")).click();
        driver.findElement(By.cssSelector("#input-firstname")).clear();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Anna");

        //Enter last name
        driver.findElement(By.cssSelector("#input-lastname")).click();
        driver.findElement(By.cssSelector("#input-lastname")).clear();
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Smith");
        Thread.sleep(1000);//For demonstration only

        //Enter email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys(emailRandomizer.getSaltString() + "@gmail.com");
        Thread.sleep(1000);//For demonstration only

        //Enter telephone
        driver.findElement(By.cssSelector("#input-telephone")).click();
        driver.findElement(By.cssSelector("#input-telephone")).clear();
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("+380 (98) 123 45 67");

        //Enter fax
        driver.findElement(By.cssSelector("#input-fax")).click();
        driver.findElement(By.cssSelector("#input-fax")).clear();
        driver.findElement(By.cssSelector("#input-fax")).sendKeys("11-22-33");
        Thread.sleep(1000);//For demonstration only

        //Enter company
        driver.findElement(By.cssSelector("#input-company")).click();
        driver.findElement(By.cssSelector("#input-company")).clear();
        driver.findElement(By.cssSelector("#input-company")).sendKeys("SoftServe");

        //Enter address 1
        driver.findElement(By.cssSelector("#input-address-1")).click();
        driver.findElement(By.cssSelector("#input-address-1")).clear();
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("SoftServe");
        Thread.sleep(1000);//For demonstration only

        //Enter address 2
        driver.findElement(By.cssSelector("#input-address-2")).click();
        driver.findElement(By.cssSelector("#input-address-2")).clear();
        driver.findElement(By.cssSelector("#input-address-2")).sendKeys("SoftServe 2");

        //Enter city
        driver.findElement(By.cssSelector("#input-city")).click();
        driver.findElement(By.cssSelector("#input-city")).clear();
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Lviv");
        Thread.sleep(1000);//For demonstration only

        //Enter post code
        driver.findElement(By.cssSelector("#input-postcode")).click();
        driver.findElement(By.cssSelector("#input-postcode")).clear();
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("79000");

        //Choose country
        driver.findElement(By.cssSelector("#input-country")).click();
        getSelect("#input-country").selectByVisibleText("Ukraine");
        Thread.sleep(1000);//For demonstration only

        //Choose region/state
        driver.findElement(By.cssSelector("#input-zone")).click();
        getSelect("#input-zone").selectByVisibleText("L'vivs'ka Oblast'");
        Thread.sleep(1000);//For demonstration only

        //Enter password
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Ss*Jj&1*2#3");

        //Enter password confirm
        driver.findElement(By.cssSelector("#input-confirm")).click();
        driver.findElement(By.cssSelector("#input-confirm")).clear();
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Ss*Jj&1*2#3");
        Thread.sleep(1000);//For demonstration only

        //Click on "Continue" button
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Actual result that we need
        String actual = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();

        //Check if actual result contains needed message
        Assert.assertTrue(actual.contains("Warning: You must agree to the Privacy Policy!"),
                "Test accepted registration without agree to the Privacy Policy");
    }

    /**
     * Negative test.
     * Used technique: Decision Table.
     * This test checks if user can be registered
     * with invalid email address entered.
     */
    @Test
    public void checkIfUserCanBeRegisteredWithInvalidEmailEntered() throws Exception {

        //Click on "My Account" to open dropdown menu
        driver.findElement(By.cssSelector(".fa.fa-user")).click();

        //Click on "Register" label
        driver.findElement(By.cssSelector("a[href*='register']")).click();

        //Enter first name
        driver.findElement(By.cssSelector("#input-firstname")).click();
        driver.findElement(By.cssSelector("#input-firstname")).clear();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Anna");

        //Enter last name
        driver.findElement(By.cssSelector("#input-lastname")).click();
        driver.findElement(By.cssSelector("#input-lastname")).clear();
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Smith");
        Thread.sleep(1000);//For demonstration only

        //Enter email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys("Utre@emailcom");
        Thread.sleep(1000);//For demonstration only

        //Enter telephone
        driver.findElement(By.cssSelector("#input-telephone")).click();
        driver.findElement(By.cssSelector("#input-telephone")).clear();
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("+380 (98) 123 45 67");

        //Enter fax
        driver.findElement(By.cssSelector("#input-fax")).click();
        driver.findElement(By.cssSelector("#input-fax")).clear();
        driver.findElement(By.cssSelector("#input-fax")).sendKeys("11-22-33");
        Thread.sleep(1000);//For demonstration only

        //Enter company
        driver.findElement(By.cssSelector("#input-company")).click();
        driver.findElement(By.cssSelector("#input-company")).clear();
        driver.findElement(By.cssSelector("#input-company")).sendKeys("SoftServe");

        //Enter address 1
        driver.findElement(By.cssSelector("#input-address-1")).click();
        driver.findElement(By.cssSelector("#input-address-1")).clear();
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("SoftServe");
        Thread.sleep(1000);//For demonstration only

        //Enter address 2
        driver.findElement(By.cssSelector("#input-address-2")).click();
        driver.findElement(By.cssSelector("#input-address-2")).clear();
        driver.findElement(By.cssSelector("#input-address-2")).sendKeys("SoftServe 2");

        //Enter city
        driver.findElement(By.cssSelector("#input-city")).click();
        driver.findElement(By.cssSelector("#input-city")).clear();
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Lviv");
        Thread.sleep(1000);//For demonstration only

        //Enter post code
        driver.findElement(By.cssSelector("#input-postcode")).click();
        driver.findElement(By.cssSelector("#input-postcode")).clear();
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("79000");

        //Choose country
        driver.findElement(By.cssSelector("#input-country")).click();
        getSelect("#input-country").selectByVisibleText("Ukraine");
        Thread.sleep(1000);//For demonstration only

        //Choose region/state
        driver.findElement(By.cssSelector("#input-zone")).click();
        getSelect("#input-zone").selectByVisibleText("L'vivs'ka Oblast'");
        Thread.sleep(1000);//For demonstration only

        //Enter password
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Ss*Jj&1*2#3");

        //Enter password confirm
        driver.findElement(By.cssSelector("#input-confirm")).click();
        driver.findElement(By.cssSelector("#input-confirm")).clear();
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Ss*Jj&1*2#3");
        Thread.sleep(1000);//For demonstration only

        //Click on Privacy Policy checkbox
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        //Click on "Continue" button
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Actual result that we need
        String actual = driver.findElement(By.xpath("//div[contains(@class, 'text-danger')]")).getText();

        //Check if actual result contains needed message
        Assert.assertTrue(actual.contains("E-Mail Address does not appear to be valid!"),
                "Test accepted invalid email address");

    }

    /**
     * Negative test.
     * Used technique: Equivalence Partition.
     * This test checks if user can be registered
     * with first name longer than 32 symbols.
     */
    @Test
    public void checkIfUserCanBeRegisteredWithFirstNamesLengthMoreThan32Symbols() throws Exception {

        //Click on "My Account" to open dropdown menu
        driver.findElement(By.cssSelector(".fa.fa-user")).click();

        //Click on "Register" label
        driver.findElement(By.cssSelector("a[href*='register']")).click();

        //Enter first name
        driver.findElement(By.cssSelector("#input-firstname")).click();
        driver.findElement(By.cssSelector("#input-firstname")).clear();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("AnnaAnnaAnnaAnnaAnnaAnnaAnnaAnnaa");

        //Enter last name
        driver.findElement(By.cssSelector("#input-lastname")).click();
        driver.findElement(By.cssSelector("#input-lastname")).clear();
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Smith");
        Thread.sleep(1000);//For demonstration only

        //Enter email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys(emailRandomizer.getSaltString() + "@gmail.com");
        Thread.sleep(1000);//For demonstration only

        //Enter telephone
        driver.findElement(By.cssSelector("#input-telephone")).click();
        driver.findElement(By.cssSelector("#input-telephone")).clear();
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("+380 (98) 123 45 67");

        //Enter fax
        driver.findElement(By.cssSelector("#input-fax")).click();
        driver.findElement(By.cssSelector("#input-fax")).clear();
        driver.findElement(By.cssSelector("#input-fax")).sendKeys("11-22-33");
        Thread.sleep(1000);//For demonstration only

        //Enter company
        driver.findElement(By.cssSelector("#input-company")).click();
        driver.findElement(By.cssSelector("#input-company")).clear();
        driver.findElement(By.cssSelector("#input-company")).sendKeys("SoftServe");

        //Enter address 1
        driver.findElement(By.cssSelector("#input-address-1")).click();
        driver.findElement(By.cssSelector("#input-address-1")).clear();
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("SoftServe");
        Thread.sleep(1000);//For demonstration only

        //Enter address 2
        driver.findElement(By.cssSelector("#input-address-2")).click();
        driver.findElement(By.cssSelector("#input-address-2")).clear();
        driver.findElement(By.cssSelector("#input-address-2")).sendKeys("SoftServe 2");

        //Enter city
        driver.findElement(By.cssSelector("#input-city")).click();
        driver.findElement(By.cssSelector("#input-city")).clear();
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Lviv");
        Thread.sleep(1000);//For demonstration only

        //Enter post code
        driver.findElement(By.cssSelector("#input-postcode")).click();
        driver.findElement(By.cssSelector("#input-postcode")).clear();
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("79000");

        //Choose country
        driver.findElement(By.cssSelector("#input-country")).click();
        getSelect("#input-country").selectByVisibleText("Ukraine");
        Thread.sleep(1000);//For demonstration only

        //Choose region/state
        driver.findElement(By.cssSelector("#input-zone")).click();
        getSelect("#input-zone").selectByVisibleText("L'vivs'ka Oblast'");
        Thread.sleep(1000);//For demonstration only

        //Enter password
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Ss*Jj&1*2#3");

        //Enter password confirm
        driver.findElement(By.cssSelector("#input-confirm")).click();
        driver.findElement(By.cssSelector("#input-confirm")).clear();
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Ss*Jj&1*2#3");
        Thread.sleep(1000);//For demonstration only

        //Click on Privacy Policy checkbox
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        //Click on "Continue" button
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Actual result that we need
        String actual = driver.findElement(By.xpath("//div[contains(@class, 'text-danger')]")).getText();

        //Check if actual result contains needed message
        Assert.assertTrue(actual.contains("First Name must be between 1 and 32 characters!"),
                "Test accepted first name longer than 32 symbols");
    }

    /**
     * Negative test.
     * Used technique: Equivalence Partition.
     * This test checks if user can be registered
     * with first name consists digits in it.
     */
    @Test
    public void checkIfUserCanBeRegisteredWithFirstNameConsistsDigits() throws Exception {

        //Click on "My Account" to open dropdown menu
        driver.findElement(By.cssSelector(".fa.fa-user")).click();

        //Click on "Register" label
        driver.findElement(By.cssSelector("a[href*='register']")).click();

        //Enter first name
        driver.findElement(By.cssSelector("#input-firstname")).click();
        driver.findElement(By.cssSelector("#input-firstname")).clear();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Anna123");
        Thread.sleep(1000);//For demonstration only

        //Enter last name
        driver.findElement(By.cssSelector("#input-lastname")).click();
        driver.findElement(By.cssSelector("#input-lastname")).clear();
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Smith");

        //Enter email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys(emailRandomizer.getSaltString() + "@gmail.com");
        Thread.sleep(1000);//For demonstration only

        //Enter telephone
        driver.findElement(By.cssSelector("#input-telephone")).click();
        driver.findElement(By.cssSelector("#input-telephone")).clear();
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("+380 (98) 123 45 67");

        //Enter fax
        driver.findElement(By.cssSelector("#input-fax")).click();
        driver.findElement(By.cssSelector("#input-fax")).clear();
        driver.findElement(By.cssSelector("#input-fax")).sendKeys("11-22-33");
        Thread.sleep(1000);//For demonstration only

        //Enter company
        driver.findElement(By.cssSelector("#input-company")).click();
        driver.findElement(By.cssSelector("#input-company")).clear();
        driver.findElement(By.cssSelector("#input-company")).sendKeys("SoftServe");

        //Enter address 1
        driver.findElement(By.cssSelector("#input-address-1")).click();
        driver.findElement(By.cssSelector("#input-address-1")).clear();
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("SoftServe");
        Thread.sleep(1000);//For demonstration only

        //Enter address 2
        driver.findElement(By.cssSelector("#input-address-2")).click();
        driver.findElement(By.cssSelector("#input-address-2")).clear();
        driver.findElement(By.cssSelector("#input-address-2")).sendKeys("SoftServe 2");

        //Enter city
        driver.findElement(By.cssSelector("#input-city")).click();
        driver.findElement(By.cssSelector("#input-city")).clear();
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Lviv");
        Thread.sleep(1000);//For demonstration only

        //Enter post code
        driver.findElement(By.cssSelector("#input-postcode")).click();
        driver.findElement(By.cssSelector("#input-postcode")).clear();
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("79000");

        //Choose country
        driver.findElement(By.cssSelector("#input-country")).click();
        getSelect("#input-country").selectByVisibleText("Ukraine");
        Thread.sleep(1000);//For demonstration only

        //Choose region/state
        driver.findElement(By.cssSelector("#input-zone")).click();
        getSelect("#input-zone").selectByVisibleText("L'vivs'ka Oblast'");
        Thread.sleep(1000);//For demonstration only

        //Enter password
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Ss*Jj&1*2#3");

        //Enter password confirm
        driver.findElement(By.cssSelector("#input-confirm")).click();
        driver.findElement(By.cssSelector("#input-confirm")).clear();
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Ss*Jj&1*2#3");
        Thread.sleep(1000);//For demonstration only

        //Click on Privacy Policy checkbox
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        //Click on "Continue" button
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //Actual result that we need
        String actual = driver.findElement(By.xpath("//div[contains(@class, 'text-danger')]")).getText();

        //Check if actual result contains needed message
        Assert.assertTrue(actual.contains("First Name cannot contain digits"),
                "Test accepted first name with digits in it.");
    }
}
