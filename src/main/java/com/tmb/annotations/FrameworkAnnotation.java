package com.tmb.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.tmb.enums.CategoryType;
import com.tmb.enums.DeviceType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {
	
	public String[] author();
	public CategoryType[] category();
	public DeviceType[] device();

}
