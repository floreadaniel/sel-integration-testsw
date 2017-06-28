package com.sel.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sel.tests.pageobjects.ChapterFirstPage;
import com.sel.tests.pageobjects.ChapterSecondPage;
import com.sel.tests.pageobjects.HomePage;
import com.sel.tests.utils.TestHelper;

public class MyTestGrid extends AbstractTest{
	
	protected HomePage homePage;
	protected ChapterSecondPage chapterSecond;
	protected ChapterFirstPage chapterFirstPage;
	
	@Test(groups= {"ignore"})
	public void testPageObject() throws Exception {
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		driver.get(TestHelper.TARGET_SERVER_URL);

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
