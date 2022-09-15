package com.tmb.exceptions;

/**
 * Runtime Exception occurs browser invocation is incorrect.
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameworkException{

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public BrowserInvocationFailedException(String message) {
		super(message);
	}
	
	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public BrowserInvocationFailedException(String message,Throwable cause) {
		super(message,cause);
	}

}
