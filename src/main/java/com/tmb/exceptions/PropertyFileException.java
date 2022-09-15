package com.tmb.exceptions;

/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.constants.FrameworkConstants
 * @see com.tmb.utils.PropertyUtlis
 */
@SuppressWarnings("serial")
public class PropertyFileException extends FrameworkException{

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public PropertyFileException(String message) {
		super(message);
	}
	
	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public PropertyFileException(String message, Throwable cause) {
		super(message, cause);
	}
}
