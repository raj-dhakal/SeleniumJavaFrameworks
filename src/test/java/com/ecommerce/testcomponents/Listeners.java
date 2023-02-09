package com.ecommerce.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	@Override
	public void onFinish(ITestContext contextFinish) {
		extent.flush();
	

	}

	@Override
	public void onStart(ITestContext contextStart) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());


	}

	@Override
	public void onTestSkipped(ITestResult result) {
	

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	

	}

}
