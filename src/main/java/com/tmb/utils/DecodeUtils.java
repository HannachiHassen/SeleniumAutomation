package com.tmb.utils;

import java.util.Base64;

/**
 * Helps to decode the base64 encoded string.
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class DecodeUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DecodeUtils() {	}
	
	/**
	 * Accepts and base64 string,decode and return to the caller
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param encodedString Base64 encoded string
	 * @return String Decoded base64 string
	 */
	public static String getDecodedString(String encodedString) {		
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));		
	}
}
