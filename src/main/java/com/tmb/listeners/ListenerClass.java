package com.tmb.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.reports.ExtentLogger;
import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.ELKUtils;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 * 
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 *  
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class ListenerClass implements ITestListener, ISuiteListener{

	/**
	 * Initialise the reports with the file name
	 * @see com.tmb.reports.ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
		System.out.println("before suite in listener");
	}

	/**
	 * Terminate the reports
	 * @see com.tmb.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
		System.out.println("after suite in listener");
	}

	/**
	 * Starts a test node for each TestNG test
	 * @see com.tmb.reports.ExtentReport
	 * @see com.tmb.annotations.FrameworkAnnotation
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
		ExtentReport.addDevices(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).device());
		System.out.println("before method in listener");
	}

	/**
	 * Marks the test as pass and logs it in the report
	 * @see com.reports.ExtentLogger
	 */	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is Passed");
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "pass");
		System.out.println("after method in listener : pass");
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 * @see com.reports.ExtentLogger
	 * @see com.tmb.utils.ScreenshotUtils
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "fail");
		System.out.println("after method in listener : fail and I am attaching screenshots here");
	}

	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.reports.ExtentLogger
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "skip");
		System.out.println("after method in listener : skipped and ignored");
	}
	
    
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * For now, we are not using this.
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}
}
