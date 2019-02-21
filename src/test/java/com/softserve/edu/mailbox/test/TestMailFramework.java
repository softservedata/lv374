package com.softserve.edu.mailbox.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.mailbox.data.MailUser;
import com.softserve.edu.mailbox.pages.MailLoginPage;
import com.softserve.edu.mailbox.pages.boxes.IncomesLettersPage;

public class TestMailFramework extends MailTestRunner {

	@DataProvider
	public Object[][] testData() {
		return new Object[][] { { MailUser.getValidUser() }, };
	}

	@Test(dataProvider = "testData")
	public void loginLogoutTest(MailUser user) {
		IncomesLettersPage mainPage = loadMailApplication().successfullLogin(user);
		MailLoginPage login = mainPage.openSettings().logout();
		login.clearLoginField();
	}

}
