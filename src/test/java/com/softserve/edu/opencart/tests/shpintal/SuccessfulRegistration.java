package com.softserve.edu.opencart.tests.shpintal;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.EditAccountPage;
import com.softserve.edu.opencart.pages.account.SuccessRegisterPage;
import com.softserve.edu.opencart.pages.shop.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class SuccessfulRegistration extends ShpintalTestRunner {
    @DataProvider//(parallel = true)
    public Object[][] newValidUsers() {
        // Read from ...
        return new Object[][]{
                //{UserRepository.generateNew()},
                {UserRepository.userBadEmail()}
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

    /**
     * Positive test.
     * Used technique: Decision Tables.
     * This test checks if user can be registered
     * with valid data entered in all fields.
     */
    //@Test(dataProvider = "newValidUsers")
    public void checkIfUserCanBeRegisteredWithValidDataEntered(IUser newValidUser) {
        SuccessRegisterPage successRegisterPage = loadApplication()
                .gotoRegister()
                .successfullRegisterUser(newValidUser);

        Assert.assertTrue(successRegisterPage.getSuccessfulCreatedLableText().trim().toLowerCase()
                .contains(SuccessRegisterPage.EXPECTED_RESULT_SUCCESS_REGISTER_PAGE));
    }
}
