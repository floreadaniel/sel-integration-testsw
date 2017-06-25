package com.sel.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sel.tests.pageobjects.ChapterFirstPage;
import com.sel.tests.pageobjects.ChapterSecondPage;
import com.sel.tests.pageobjects.HomePage;
import com.sel.tests.utils.TestHelper;

public class TestBase {

	protected WebDriver driver;
	protected String baseUrl;
	protected HomePage homePage;
	protected ChapterSecondPage chapterSecond;
	protected ChapterFirstPage chapterFirstPage;

	ExtentReports report;
	ExtentTest testReporter; 
	// Method-1.
	@BeforeSuite
	public void setUp() {

		report=new ExtentReports(TestHelper.REPORT_DIR + "report.html");
		testReporter = report.startTest(this.getClass().getName());
		baseUrl = "http://book.theautomatedtester.co.uk/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		testReporter.log(LogStatus.INFO, "Browser started ");


	}

	// Method-2.
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshot_path=TestHelper.captureScreenshot(driver, result.getName());
			TestHelper.addScreenCapture("Test pic", screenshot_path);
			String image= testReporter.addScreenCapture(screenshot_path);
			testReporter.log(LogStatus.FAIL, "<p>" +  result.getName() + "<p>" +  image);
		} else {
			String screenshot_path=TestHelper.captureScreenshot(driver, result.getName());
			TestHelper.addScreenCapture("Test pic", screenshot_path);
			String image= testReporter.addScreenCapture(screenshot_path);
			testReporter.log(LogStatus.PASS, "<p>" +  result.getName() + "<p>" +  image);
		}

		report.endTest(testReporter);
		report.flush();
		driver.quit();
	}
	
}