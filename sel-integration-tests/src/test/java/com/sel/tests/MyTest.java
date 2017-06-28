package com.sel.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sel.tests.pageobjects.ChapterFirstPage;
import com.sel.tests.pageobjects.ChapterSecondPage;
import com.sel.tests.pageobjects.HomePage;
import com.sel.tests.utils.TestHelper;

public class MyTest extends AbstractTest {
	private HomePage homePage;
	private ChapterSecondPage chapterSecond;
	private ChapterFirstPage chapterFirstPage;

	@Test(groups= {"uitest"})
	public void testPageObject() throws Exception {
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		driver.get(TestHelper.TARGET_SERVER_URL);

		TestHelper.takeScreenShot(driver, reporter, "Homepage");
		chapterSecond = homePage.clickChapterSecond();
		
		TestHelper.takeScreenShot(driver, reporter, "Second chapter");
		chapterSecond.clickbut2();
		chapterSecond.clickRandom();
		String data = chapterSecond.getTest();
		assertEquals(data, "Index", "Wrong number of items");
		homePage = chapterSecond.clickIndex();
		TestHelper.takeScreenShot(driver, reporter, "Homepage again");
		
		chapterFirstPage = homePage.clickChapterFirst();
		chapterFirstPage.clickSecondAjaxButton();
		chapterFirstPage.clickSecondAjaxButton1(data);
		chapterFirstPage.selectDropDown("Selenium Core");
		chapterFirstPage.verifyButton();
		TestHelper.takeScreenShot(driver, reporter, "First chapter");
	}
}