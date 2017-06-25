package com.sel.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sel.tests.pageobjects.HomePage;
import com.sel.tests.TestBase;

public class MyTest extends TestBase {

	@Test
	public void testPageObject() throws Exception {
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		driver.get(baseUrl);

		chapterSecond = homePage.clickChapterSecond();
		chapterSecond.clickbut2();
		chapterSecond.clickRandom();
		String data = chapterSecond.getTest();
		homePage = chapterSecond.clickIndex();

		chapterFirstPage = homePage.clickChapterFirst();
		chapterFirstPage.clickSecondAjaxButton();
		chapterFirstPage.clickSecondAjaxButton1(data);
		chapterFirstPage.selectDropDown("Selenium Core");
		chapterFirstPage.verifyButton();
		
	}
}