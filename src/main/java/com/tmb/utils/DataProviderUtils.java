package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {
	
	private DataProviderUtils() {
		
	}

	@DataProvider
	public static Object[] getData(Method m) {
		String testname=m.getName();
		
		List<Map<String, String>> list=ExcelUtils.getTestDetails("DATA");
		
		List<Map<String, String>> smalllist=new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testname)) {
				if (list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smalllist.add(list.get(i));
				}			
			}
		}
		return smalllist.toArray();		
	}
}