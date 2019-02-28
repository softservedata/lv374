package com.softserve.edu.opencart.tests.shpintal;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.*;
import com.softserve.edu.opencart.pages.shop.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShRegisterTest extends ShpintalTestRunner {

    @DataProvider//(parallel = true)
    public Object[][] userBadEmail() {
        // Read from ...
        return new Object[][]{
                {UserRepository.userBadEmail()}
        };
    }
    //@Test(dataProvider = "userBadEmail")
//    public void lalala(IUser userBadEmail) {
//        UnsuccessfullRegisterPage unsuccessfullRegisterPage = loadApplication()
//                .gotoRegister()
//                .userWithBadEmail(userBadEmail);
//        Assert.assertTrue(unsuccessfullRegisterPage.getToolTipText()
//                .contains(unsuccessfullRegisterPage.EXPECTED_WARNING_BAD_EMAIL));
//    }
}
