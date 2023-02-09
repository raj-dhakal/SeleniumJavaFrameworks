package com.ecommerce.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") +"//reports//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Raj Dhakal");
		return extent;
	}

}
