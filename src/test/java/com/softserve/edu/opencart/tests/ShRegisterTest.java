package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.*;
import com.softserve.edu.opencart.pages.shop.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShRegisterTest extends ShpintalTestRunner {

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

    /**
     * Negative test.
     * Used technique: Decision Table.
     * This test checks if user can be registered
     * without clicking on Privacy Policy check box.
     */
    //@Test(dataProvider = "newValidUsers")
    public void checkIfUserCanBeRegisteredWithoutClickOnPrivacyPolicy(IUser newValidUser) {
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithNoPrivacyPolicy(newValidUser);
//        Assert.assertTrue(unsuccessfullRegisterPage.getAlertMessageText()
//                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_PRIVACY_POLICY));
        Assert.assertEquals(unsuccessfullRegisterPage.getAlertMessageText(),
                unsuccessfullRegisterPage.EXPECTED_WARNING_PRIVACY_POLICY);

    }

    @DataProvider//(parallel = true)
    public Object[][] userLastName33Length() {
        // Read from ...
        return new Object[][]{
                {UserRepository.userLastName33Length()}
        };
    }

    /**
     * Negative test.
     * Used technique: Boundary value.
     * This test checks if user can be registered
     * with first name longer than 32 symbols.
     */
    //@Test(dataProvider = "userLastName33Length")
    public void checkIfUserWithLastNamesLength33Symbols(IUser userLastName33Length) throws Exception {
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithFirstNameLength33Symbols(userLastName33Length);

        Assert.assertEquals(unsuccessfullRegisterPage.getTextDangerText(),
                unsuccessfullRegisterPage.EXPECTED_WARNING_LAST_NAME);
    }

        @DataProvider//(parallel = true)
    public Object[][] emptyUser() {
        // Read from ...
        return new Object[][]{
                {UserRepository.emptyUser()}
        };
    }

    /**
     * Negative test.
     * Used technique: Decision Tables.
     * This test checks if user can be registered
     * with empty fields.
     */
    //@Test(dataProvider = "emptyUser")
    public void checkIfCanRegisterWithNoDataEntered(IUser emptyUser) {
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithNoData(emptyUser);

        Assert.assertEquals(unsuccessfullRegisterPage.getTextDangerText(),
                unsuccessfullRegisterPage.EXPECTED_WARNING_FIRST_NAME);
    }

    @DataProvider//(parallel = true)
    public Object[][] userWithFirstNameConsistsDigits() {
        // Read from ...
        return new Object[][]{
                {UserRepository.userWithFirstNameConsistsDigits()}
        };
    }

    /**
     * Negative test.-
     * Used technique: Equivalence Partition.
     * This test checks if user can be registered
     * with first name consists digits in it.
     */
    @Test(dataProvider = "userWithFirstNameConsistsDigits")
    public void checkIfCanRegisterWithFirstNameConsistsDigits(IUser userWithFirstNameConsistsDigits){
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithFirstNameConsistsDigits(userWithFirstNameConsistsDigits);

        Assert.assertTrue(unsuccessfullRegisterPage.getTextDangerText()
                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_FIRST_NAME_DIGITS));
    }

    @DataProvider//(parallel = true)
    public Object[][] userBadEmail() {
        // Read from ...
        return new Object[][]{
                {UserRepository.userBadEmail()}
        };
    }
    // @Test(dataProvider = "userBadEmail")!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void lalala(IUser userBadEmail) {
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithBadEmail(userBadEmail);
        Assert.assertTrue(unsuccessfullRegisterPage.getEmailAlertText()
                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_BAD_EMAIL));
    }
}
