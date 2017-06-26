package com.sel.tests.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private ExtentManager() {}
	
	private static ExtentReports reports;

	public synchronized static ExtentReports getInstance() {
		if (reports == null ) {
			reports=new ExtentReports(TestHelper.REPORT_DIR + new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date()) + "-report.html", true);
			reports.loadConfig(Reporter.class.getClassLoader().getResource("extent-config.xml"));
		}
		return reports;
	}
}
