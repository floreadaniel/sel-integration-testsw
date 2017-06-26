package com.sel.tests.utils;

import java.io.File;
import org.testng.Reporter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class TestHelper {

	public static final String REPORT_DIR="C:\\WORK\\Brownbag\\automated-testing-with-selenium-grid-and-jenkins\\report\\";
	public static String SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";
	public static String TARGET_SERVER_URL = "http://book.theautomatedtester.co.uk/";
	
	
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

}
