package com.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	public static String getValue(String key) throws Exception {
		String value="";
		Properties property= new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
		property.load(file);		
		value=property.getProperty(key);
		if (Objects.isNull(value)) {
			throw new Exception("Property name "+ key +" is not fournd. Please check config.properties");
		}
		return value;		
	}
}
