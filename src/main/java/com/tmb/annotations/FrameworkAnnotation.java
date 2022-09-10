package com.tmb.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.tmb.enums.CategoryType;
import com.tmb.enums.DeviceType;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.tests;
 * @see com.tmb.enums.CategoryType
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {
	
	/**
	 * Store the authors who created the tests in String[]
	 * Manadatory to enter atleast a value
	 * @author Hassen
	 * Sep 10, 2022
	 * @return String Array author names 
	 */
	public String[] author();
	
	/**
	 * Stores the category in form of Enum Array. Include the possible values in {@link com.tmb.enums.CategoryType}
	 * @author Hassen
	 * Sep 10, 2022
	 * @return Enum Array of CategoryType[] contains category names
	 */
	public CategoryType[] category();
	
	/**
	 * Stores the device in form of Enum Array. Include the possible values in {@link com.tmb.enums.DeviceType}
	 * @author Hassen
	 * Sep 10, 2022
	 * @return Enum Array DeviceType[] contains device names
	 */
	public DeviceType[] device();

}
