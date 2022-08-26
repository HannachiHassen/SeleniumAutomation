package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties property= new Properties();
	private static final Map<String, String> CONFIGMAP= new HashMap<String, String>();

	static {
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
			property.load(file);
			
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));				
			}
			
			//property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	// Hashmap ---read everything from properties file
	// Converting a property to hashmap needs some time	
	public static String get(String key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
			throw new Exception("Property name "+ key +" is not fournd. Please check config.properties");
		}
		return CONFIGMAP.get(key);
	}
	
	//Hashtable -- little slow, thread safe
	public static String getValue(String key) throws Exception {
		
		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new Exception("Property name "+ key +" is not fournd. Please check config.properties");
		}
		return property.getProperty(key);		
	}
}