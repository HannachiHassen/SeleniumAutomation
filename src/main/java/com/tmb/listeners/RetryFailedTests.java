package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;

public class RetryFailedTests implements IRetryAnalyzer{
	private int counter = 0;
	private int retryLimint = 1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		try {
			if (PropertyUtlis.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value=counter<retryLimint;		
				counter++;
				System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;		
	}
}
