package com.tmb.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForPropertyFileException extends InvalidPathForFilesException {

	public InvalidPathForPropertyFileException(String message) {
		super(message);
	}

	public InvalidPathForPropertyFileException(String message, Throwable casue) {
		super(message, casue);
	}
}
