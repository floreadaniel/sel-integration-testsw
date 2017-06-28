package com.sel.tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sel.tests.utils.ExtentManager;
import com.sel.tests.utils.TestHelper;
import com.sel.tests.utils.WebDriverFactory;

public abstract class AbstractTest {
	protected WebDriver driver;
	protected ExtentTest reporter;

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws MalformedURLException {
		reporter = ExtentManager.getInstance().startTest(this.getClass().getName());
		driver = WebDriverFactory.createDriver( System.getProperty("env"));
		reporter.log(LogStatus.INFO, "Browser started ");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
		try {
			String screenshot_path=TestHelper.captureScreenshot(driver, reporter.getTest().getName());
			TestHelper.addScreenCapture("Test pic", screenshot_path);
			String image= reporter.addScreenCapture(screenshot_path);

			switch (result.getStatus()) {
			case ITestResult.FAILURE:
				reporter.log(LogStatus.FAIL, "<p>" +  reporter.getTest().getName() + "<p>" +  image);
				break;
			default:
				reporter.log(LogStatus.PASS, "<p>" +  reporter.getTest().getName() + "<p>" +  image);
				break;
			}
		} catch	(Exception e) {
			reporter.log(LogStatus.ERROR,"Error while tacking the screenshot");
		}
		ExtentManager.getInstance().endTest(reporter);
		ExtentManager.getInstance().flush();
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ExtentTest getReporter() {
		return reporter;
	}
}
