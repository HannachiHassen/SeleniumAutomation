package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;

/**
 * Implements {@link IRetryAnalyzer}.<p>
 * Helps in rerunning the failed tests.<p>
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer{
	private int counter = 0;
	private int retryLimint = 1;

	/**
	 * Return true when needs to be retried and false otherwise.
	 * Maximum will retry for one time.
	 * Retry will happen if user desires to and set the value in the property file
	 */
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
			if (PropertyUtlis.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value=counter<retryLimint;		
				counter++;
				System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
			}
		return value;		
	}
}
