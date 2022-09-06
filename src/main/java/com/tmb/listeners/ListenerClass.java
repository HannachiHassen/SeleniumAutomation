package com.tmb.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public final class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("before suite in listener");
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after suite in listener");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
		ExtentReport.addDevices(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).device());
		System.out.println("before method in listener");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is Passed");
		System.out.println("after method in listener : pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after method in listener : fail and I am attaching screenshots here");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
		System.out.println("after method in listener : skipped and ignored");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
}
