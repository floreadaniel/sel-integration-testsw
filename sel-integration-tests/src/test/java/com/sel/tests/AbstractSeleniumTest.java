package com.sel.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentTest;

public class AbstractSeleniumTest {
	private WebDriver driver;
	private ExtentTest reporter;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
		switch (result.getStatus()) {
		case ITestResult.FAILURE:
			//failed
			break;
		default:
			//passed
			break;
		}
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public ExtentTest getReporter() {
		return reporter;
	}
	public void setReporter(ExtentTest reporter) {
		this.reporter = reporter;
	}

	
}
