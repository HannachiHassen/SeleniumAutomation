package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int counter = 0;
	int retryLimint = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryLimint) {
			System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
			counter++;
			return true;
		}
		return false;
	}
}
