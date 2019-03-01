package com.softserve.edu.opencart.tests.shpintal;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.UnsuccessfullRegisterPage;
import com.softserve.edu.opencart.pages.account.UnsuccessfullRegisterPageAlert;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("@Epic: UnsuccessfulRegistrationTests")
public class UnsuccessfulRegistrationTests extends ShpintalTestRunner {

    @DataProvider
    public Object[][] validUser() {
        // Read from ...
        return new Object[][]{
                {UserRepository.getValid()}
        };
    }

    /**
     * Negative test.
     * Used technique: Decision Table.
     * This test checks if user can be registered
     * without clicking on Privacy Policy check box.
     */
    @Description("@Description: This test checks if user can be registered without clicking on Privacy Policy check box.")
    @Test(dataProvider = "validUser")
    public void checkIfUserCanBeRegisteredWithoutClickOnPrivacyPolicy(IUser validUser) {
        logger.info("START TEST: checkIfUserCanBeRegisteredWithoutClickOnPrivacyPolicy("
                + validUser.toString() + ")");
        // Steps
        UnsuccessfullRegisterPageAlert unsuccessfullRegisterPageAlert = loadApplication()
                .gotoRegister()
                .userWithNoPrivacyPolicy(validUser);
//        Assert.assertTrue(unsuccessfullRegisterPage.getAlertMessageText()
//                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_PRIVACY_POLICY));
        // Check
        Assert.assertEquals(unsuccessfullRegisterPageAlert.getAlertMessageText(),
                unsuccessfullRegisterPageAlert.EXPECTED_WARNING_PRIVACY_POLICY);
        logger.info("DONE TEST: checkIfUserCanBeRegisteredWithoutClickOnPrivacyPolicy("
                + validUser.toString() + ")");
    }

    @DataProvider
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
    @Description("@Description: This test checks if user can be registered with first name longer than 32 symbols.")
    @Test(dataProvider = "userLastName33Length")
    public void checkIfUserWithLastNamesLength33Symbols(IUser userLastName33Length) throws Exception {
        logger.info("START TEST: checkIfUserWithLastNamesLength33Symbols("
                + userLastName33Length.toString() + ")");
        // Steps
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithFirstNameLength33Symbols(userLastName33Length);
        // Check
        Assert.assertEquals(unsuccessfullRegisterPage.getTextDangerText(),
                unsuccessfullRegisterPage.EXPECTED_WARNING_LAST_NAME);
        logger.info("DONE TEST: checkIfUserWithLastNamesLength33Symbols("
                + userLastName33Length.toString() + ")");
    }

    @DataProvider
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
    @Description("@Description: This test checks if user can be registered with empty fields.")
    @Test(dataProvider = "emptyUser")
    public void checkIfCanRegisterWithNoDataEntered(IUser emptyUser) {
        logger.info("START TEST: checkIfCanRegisterWithNoDataEntered("
                + emptyUser.toString() + ")");
        // Steps
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithNoData(emptyUser);
        // Check
        Assert.assertEquals(unsuccessfullRegisterPage.getTextDangerText(),
                unsuccessfullRegisterPage.EXPECTED_WARNING_FIRST_NAME);
        logger.info("DONE TEST: checkIfCanRegisterWithNoDataEntered("
                + emptyUser.toString() + ")");
    }

    @DataProvider
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
    @Description("This test checks if user can be registered with first name consists digits in it.")
    @Test(dataProvider = "userWithFirstNameConsistsDigits")
    public void checkIfCanRegisterWithFirstNameConsistsDigits(IUser userWithFirstNameConsistsDigits) throws NoElementException {
        logger.info("START TEST: checkIfCanRegisterWithFirstNameConsistsDigits("
                + userWithFirstNameConsistsDigits.toString() + ")");
        // Steps
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithFirstNameConsistsDigits(userWithFirstNameConsistsDigits);
        // Check
        Assert.assertTrue(unsuccessfullRegisterPage.getTextDangerText()
                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_FIRST_NAME_DIGITS), "There is no such element");
        logger.info("DONE TEST: checkIfCanRegisterWithFirstNameConsistsDigits("
                + userWithFirstNameConsistsDigits.toString() + ")");
    }
}
