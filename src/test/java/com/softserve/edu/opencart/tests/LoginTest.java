package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.db.service.LoginService;
import com.softserve.edu.opencart.pages.account.EditAccountPage;
import com.softserve.edu.opencart.pages.account.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.tools.ListUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("@Epic: Login_Test")
@Feature("@Feature: Login_Application_Test")
public class LoginTest extends TestRunner {

	@DataProvider//(parallel = true)
    public Object[][] validUsers() {
        // Read from ...
        return new Object[][] { 
            { UserRepository.getValid() },
            };
    }

    @DataProvider // (parallel = true)
    public Object[][] validCsvUsers() {
        return ListUtils.toMultiArray(UserRepository.fromCsv());
    }

    @DataProvider // (parallel = true)
    public Object[][] validExcelUsers() {
        return ListUtils.toMultiArray(UserRepository.fromExcel());
    }

	@Description("@Description: class LoginTest; checkLoginReport()")
	@Severity(SeverityLevel.BLOCKER)
	@Story("@Story: check_Login_Report")
    //@Test(dataProvider = "validUsers")
	//@Test(dataProvider = "validCsvUsers")
	//@Test(dataProvider = "validExcelUsers")
    public void checkLoginReport(IUser validUser) {
		logger.info("START TEST: checkLoginReport("
					+ validUser.toString() + ")");
        //
        // Precondition
        // Steps
    	EditAccountPage editAccountPage = loadApplication()
        		.gotoLogin()
        		.successLogin(validUser)
        		.gotoEditAccountPage();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstnameText(),
        		validUser.getFirstname());
        //
        // Return to previous state
        // Steps
        HomePage homePage = editAccountPage
        		.continueValidatorMyAccountPage()
        		.gotoLogout()
        		.continueHomePage();
        //
        // Check
        Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.IPHONE_IMAGE));
        //
        // Return to previous state
		//Assert.assertTrue(false);
		logger.info("DONE TEST: checkLoginReport("
				+ validUser.toString() + ")");
    }
	
    //@Test(dataProvider = "validUsers")
    public void checkLogin(IUser validUser) {
        //
        // Precondition
        // Steps
    	EditAccountPage editAccountPage = loadApplication()
        		.gotoLogin()
        		.successLogin(validUser)
        		.gotoEditAccountPage();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstnameText(),
        		validUser.getFirstname());
        //
        // Return to previous state
        // Steps
        HomePage homePage = editAccountPage
        		.continueValidatorMyAccountPage()
        		.gotoLogout()
        		.continueHomePage();
        //
        // Check
        Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.IPHONE_IMAGE));
        //
        // Return to previous state
    }
    
    @DataProvider//(parallel = true)
    public Object[][] invalidUsers() {
        // Read from ...
        return new Object[][] { 
            { UserRepository.getInvalid() },
            };
    }

    @Test(dataProvider = "invalidUsers")
    public void checkFailedLogin(IUser invalidUser) {
        //
        // Precondition
        // Steps
        UnsuccessfulLoginPage unsuccessfulLoginPage = loadApplication()
                .gotoLogin()
                .unsuccessfullLogin(invalidUser);
        //
        // Check
        Assert.assertTrue(unsuccessfulLoginPage.getAlertMessageText()
                .contains(UnsuccessfulLoginPage.EXPECTED_WARNING_LOGIN));
        //
        // Steps
        for (int i = 0; i < 5; i++) {
            unsuccessfulLoginPage = unsuccessfulLoginPage
                    .unsuccessfullLogin(invalidUser);
        }
        // Check
        Assert.assertTrue(unsuccessfulLoginPage.getAlertMessageText()
                .contains(UnsuccessfulLoginPage.EXPECTED_WARNING_LOCK));
        //
        // Return to previous state
        LoginService loginService = new LoginService();
        System.out.println("TOTTAL: " + loginService.getLoginAttemptCount(invalidUser));
        //
        loginService.unlockBannedUser(invalidUser);
        //
        // Steps
        unsuccessfulLoginPage = unsuccessfulLoginPage
                    .unsuccessfullLogin(invalidUser);
        //
        // Check
        Assert.assertTrue(unsuccessfulLoginPage.getAlertMessageText()
                .contains(UnsuccessfulLoginPage.EXPECTED_WARNING_LOGIN));
        //
        // Steps
        HomePage homePage = unsuccessfulLoginPage
                .gotoHomePage();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.IPHONE_IMAGE));
        //
        // Return to previous state
    }

    //@Test(dataProvider = "validUsers")
    public void examiteLogin(IUser validUser) {
        //
        // Precondition
        // Steps
    	EditAccountPage editAccountPage = loadApplication()
        		.gotoRegister()
        		.gotoMyAccountPage(validUser) // Check
        		.gotoEditAccountPage();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstnameText(),
        		validUser.getFirstname());
        //
        // Return to previous state
        // Steps
        HomePage homePage = editAccountPage
        		.continueValidatorMyAccountPage()
        		.gotoLogout()
        		.continueHomePage();
        //
        // Check
        Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.IPHONE_IMAGE));
        //
        editAccountPage = homePage
        		.gotoLogin()
        		.successLogin(validUser)
        		.gotoMyAccountPage(validUser) // Check
        		.gotoEditAccountPage();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstnameText(),
        		validUser.getFirstname());
        //
        // Return to previous state
        // Steps
        homePage = editAccountPage
        		.continueValidatorMyAccountPage()
        		.gotoLogout()
        		.continueHomePage();
        //
        // Check
        Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.IPHONE_IMAGE));
        //
        // Return to previous state
    }
   
	@DataProvider//(parallel = true)
    public Object[][] newValidUsers() {
        // Read from ...
        return new Object[][] { 
            { UserRepository.generateNew() },
            };
    }

    //@Test(dataProvider = "newValidUsers")
    public void checkRegister(IUser newValidUser) {
        //
        // Precondition
    	System.out.println("\nCreate new User:\n" + newValidUser);
        // Steps
    	EditAccountPage editAccountPage = loadApplication()
        		.gotoRegister()
        		.successfullRegisterUser(newValidUser)
        		.continueMyAccountPage()
        		.gotoEditAccountPage();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstnameText(),
        		newValidUser.getFirstname());
        //
        // Steps
        HomePage homePage = editAccountPage
        		.continueValidatorMyAccountPage()
        		.gotoLogout()
        		.continueHomePage();
        //
        // Check
        Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.IPHONE_IMAGE));
        //
        // Steps
        editAccountPage = homePage
        		.gotoLogin()
        		.successLogin(newValidUser)
        		.gotoEditAccountPage();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstnameText(),
        		newValidUser.getFirstname());
        //
        // Return to previous state
        // Steps
        homePage = editAccountPage
        		.continueValidatorMyAccountPage()
        		.gotoLogout()
        		.continueHomePage();
        //
        // Check
        Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.IPHONE_IMAGE));
        //
        // Return to previous state
    }
}
