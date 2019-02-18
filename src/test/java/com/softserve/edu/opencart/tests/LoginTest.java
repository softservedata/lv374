package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.EditAccountPage;
import com.softserve.edu.opencart.pages.shop.HomePage;

public class LoginTest extends TestRunner {

	@DataProvider//(parallel = true)
    public Object[][] validUsers() {
        // Read from ...
        return new Object[][] { 
            { UserRepository.getValid() },
            };
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
    public Object[][] newValidUsers() {
        // Read from ...
        return new Object[][] { 
            { UserRepository.generateNew() },
            };
    }

    @Test(dataProvider = "newValidUsers")
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
