package com.sel.tests;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sel.tests.pageobjects.GmailAccount;
import com.sel.tests.pageobjects.GmailLoginPage;
import com.sel.tests.utils.TestHelper;

public class SendEmailTest extends AbstractTest{
	
	private GmailLoginPage loginPage;
	private GmailAccount accountPage;
	
	@Test(groups={"uitest"})
	public void testSendEmail() throws Exception {
		loginPage = PageFactory.initElements(driver, GmailLoginPage.class);
		driver.get(TestHelper.GMAIL_SERVER_URL);
		
		loginPage.setUsername("testjava29");
		TestHelper.takeScreenShot(driver,reporter, "Username");
		loginPage.next();
		
		loginPage.setPassword("123456781");
		TestHelper.takeScreenShot(driver,reporter, "Password");
		
		accountPage = loginPage.login();
		TestHelper.takeScreenShot(driver,reporter, "Account");
		
		accountPage.compose();
		TestHelper.takeScreenShot(driver,reporter, "AccountCompose");
		
		accountPage.setRecipients("floreadaniel19@gmail.com");
		accountPage.setSubject("important");
		accountPage.setBody("This is an important email");
		TestHelper.takeScreenShot(driver,reporter, "Write email");
		
		//accountPage.send();
		
	}
}
