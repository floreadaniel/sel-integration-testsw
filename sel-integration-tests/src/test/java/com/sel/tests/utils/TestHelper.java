package com.sel.tests.utils;

import java.io.File;

import org.testng.Reporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestHelper {

	public static final String REPORT_DIR="C:\\WORK\\Brownbag\\automated-testing-with-selenium-grid-and-jenkins\\report\\";
	public static final String SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";
	public static final String TARGET_SERVER_URL = "http://book.theautomatedtester.co.uk/";
	public static final String TODO_TARGET_SERVER_URL= "http://todomvc.com/examples/angularjs/#/";
	public static final String GMAIL_SERVER_URL = "http://mail.google.com";
	public static final String WTA_SERVER_URL = "http://www.wtatennis.com/";
	
	public static class Step {
		String title;
		Runnable runnable;

		public Step(String title, Runnable runnable){
			super();
			this.title = title;
			this.runnable = runnable;
		}
	}
	public static void runTests(Step[] steps, WebDriver driver, ExtentReports report, String description) {

	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		String dest = REPORT_DIR + "Screenshots\\" + screenshotName + ".png";
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
			return e.getMessage();
		}

	}

	public static void addScreenCapture(String filename, String screenshot_path) {
		Reporter.log("<p>" +  filename + "<p><img src=\"" +  screenshot_path  + "\"></br>" );
	}
	
	public static void clearLocalStorage(WebDriver driver) {
	 ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
    }

	public static void takeScreenShot (WebDriver driver, ExtentTest reporter, String pictureDesc) {
		
		try {
			String screenshot_path=TestHelper.captureScreenshot(driver, reporter.getTest().getName()+ pictureDesc);
			TestHelper.addScreenCapture("Test pic", screenshot_path);
			String image= reporter.addScreenCapture(screenshot_path);
			reporter.log(LogStatus.INFO, "<p>" +  pictureDesc + "<p>" +  image);
		
		} catch	(Exception e) {
			reporter.log(LogStatus.ERROR,"Error while tacking the screenshot");
		}
	}
	
}
