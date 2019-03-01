package com.softserve.edu.opencart.tests.shpintal;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.EditAccountPage;
import com.softserve.edu.opencart.pages.account.SuccessRegisterPage;
import com.softserve.edu.opencart.pages.shop.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("@Epic: SuccessfulRegistrationTests")
public class SuccessfulRegistrationTests extends ShpintalTestRunner {

    @DataProvider//(parallel = true)
    public Object[][] newValidUsers() {
        // Read from ...
        return new Object[][]{
                {UserRepository.generateNew()}
        };
    }

    /**
     * Positive test.
     * Used technique: Decision Tables.
     * This test checks if user can be registered
     * with valid data entered in all fields.
     */
    @Description("@Description:  This test checks if user can be registered with valid data entered in all fields.")
    @Test(dataProvider = "newValidUsers")
    public void checkIfUserCanBeRegisteredWithValidDataEntered(IUser newValidUser) {
        logger.info("START TEST: checkIfUserCanBeRegisteredWithValidDataEntered("
                + newValidUser.toString() + ")");
        //
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
        logger.info("DONE TEST: checkIfUserCanBeRegisteredWithValidDataEntered("
                + newValidUser.toString() + ")");
    }

    /**
     * Positive test.
     * Used technique: Decision Tables.
     * This test checks if user can be registered
     * with valid data entered in all fields.
     */
    // @Test(dataProvider = "newValidUsers")
    public void checkIfUserCanBeRegisteredWithValidDataEntered1(IUser newValidUser) {
        SuccessRegisterPage successRegisterPage = loadApplication()
                .gotoRegister()
                .successfullRegisterUser(newValidUser);

        Assert.assertTrue(successRegisterPage.getSuccessfulCreatedLableText().trim().toLowerCase()
                .contains(SuccessRegisterPage.EXPECTED_RESULT_SUCCESS_REGISTER_PAGE));
    }

}
