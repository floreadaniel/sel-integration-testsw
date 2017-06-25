package com.sel.tests.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenRecorder {
   public static void takeScreenShot(WebDriver driver, ExtentTest test, LogStatus status) {
	    
	  String basedir = TestHelper.REPORT_DIR + "\\screenshots\\" + test.getTest().getName();
	  try {
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File (basedir));
	} catch (WebDriverException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
   }
}
