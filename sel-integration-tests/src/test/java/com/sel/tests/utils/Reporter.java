package com.sel.tests.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class Reporter {
	private static ExtentReports extentReport;

	public synchronized static ExtentReports getInstance() {
		if (extentReport == null) {
			extentReport = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) +".html", true);
			extentReport.loadConfig(Reporter.class.getClassLoader().getResource("extent-config.xml"));
		}
		return extentReport;
	}
}
