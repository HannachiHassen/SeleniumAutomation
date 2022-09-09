package com.tmb.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForExcelException extends RuntimeException{
	
	public InvalidPathForExcelException(String message) {
		super(message);
	}
	
	public InvalidPathForExcelException(String message, Throwable cause) {
		super(message, cause);
	}

}
