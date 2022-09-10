package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tmb.constants.FrameworkConstants;
/**
 * Holds the data provider for all the test cases in the framework.
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class DataProviderUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DataProviderUtils() {

	}

	private static List<Map<String, String>> list = new ArrayList<>();

	/**
	 * Acts as a data provider for all the test cases.
	 * Parallel=true indicates that each of the iteration will be ran in parallel 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 *  
	 * @see com.tmb.tests;
	 * @see com.tmb.listeners.AnnotationTransformer
	 */
	@DataProvider(parallel = false)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDatasheet());
		}

		List<Map<String, String>> smalllist = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testname)
					&& list.get(i).get("execute").equalsIgnoreCase("yes")) {
				smalllist.add(list.get(i));
			}
		}
		// list.removeAll(smalllist);
		return smalllist.toArray();
	}
}
