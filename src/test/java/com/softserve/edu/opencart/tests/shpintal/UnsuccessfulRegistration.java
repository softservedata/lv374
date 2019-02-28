package com.softserve.edu.opencart.tests.shpintal;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.UnsuccessfullRegisterPage;
import com.softserve.edu.opencart.pages.account.UnsuccessfullRegisterPageAlert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnsuccessfulRegistration extends ShpintalTestRunner {

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
    @Test(dataProvider = "validUser")
    public void checkIfUserCanBeRegisteredWithoutClickOnPrivacyPolicy(IUser validUser) {
        UnsuccessfullRegisterPageAlert unsuccessfullRegisterPageAlert = loadApplication()
                .gotoRegister()
                .userWithNoPrivacyPolicy(validUser);
//        Assert.assertTrue(unsuccessfullRegisterPage.getAlertMessageText()
//                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_PRIVACY_POLICY));
        Assert.assertEquals(unsuccessfullRegisterPageAlert.getAlertMessageText(),
                unsuccessfullRegisterPageAlert.EXPECTED_WARNING_PRIVACY_POLICY);

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
    @Test(dataProvider = "userLastName33Length")
    public void checkIfUserWithLastNamesLength33Symbols(IUser userLastName33Length) throws Exception {
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithFirstNameLength33Symbols(userLastName33Length);

        Assert.assertEquals(unsuccessfullRegisterPage.getTextDangerText(),
                unsuccessfullRegisterPage.EXPECTED_WARNING_LAST_NAME);
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
    @Test(dataProvider = "emptyUser")
    public void checkIfCanRegisterWithNoDataEntered(IUser emptyUser) {
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithNoData(emptyUser);

        Assert.assertEquals(unsuccessfullRegisterPage.getTextDangerText(),
                unsuccessfullRegisterPage.EXPECTED_WARNING_FIRST_NAME);
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
    @Test(dataProvider = "userWithFirstNameConsistsDigits")
    public void checkIfCanRegisterWithFirstNameConsistsDigits(IUser userWithFirstNameConsistsDigits) {
        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
                .gotoRegister()
                .userWithFirstNameConsistsDigits(userWithFirstNameConsistsDigits);

        Assert.assertTrue(unsuccessfullRegisterPage.getTextDangerText()
                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_FIRST_NAME_DIGITS));
    }
}
