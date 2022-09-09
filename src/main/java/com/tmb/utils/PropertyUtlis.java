package com.tmb.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constans.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.FrameworkException;
import com.tmb.exceptions.PropertyFileException;

public final class PropertyUtlis {

	private PropertyUtlis() {

	}

	private static Properties property= new Properties();
	private static final Map<String, String> CONFIGMAP= new HashMap<>();

	static {
		//try with resources
		try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath()); BufferedInputStream bfis=new BufferedInputStream(file)){
			property.load(file);
			
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces		
			}
			//property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new FrameworkException("Some IO Exception happened while reading Property File.");
		}			
	}
	
	// Hashmap ---read everything from properties file
	// Converting a property to hashmap needs some time	
	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileException("Property name "+ key +" is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
	//Hashtable -- little slow, thread safe
	public static String getValue(String key){
		
		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new PropertyFileException("Property name "+ key +" is not fournd. Please check config.properties");
		}
		return property.getProperty(key);		
	}
}
