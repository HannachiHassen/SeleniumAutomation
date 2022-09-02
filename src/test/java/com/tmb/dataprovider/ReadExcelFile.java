package com.tmb.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.constans.FrameworkConstants;

public class ReadExcelFile {
	
	static List<Map<String,String>> list =  new ArrayList<>();
	public static List<Map<String,String>> smalllist= new ArrayList<>();

	@Test(dataProvider="getData")
	public void testWithExcel(Map<String, String> data) {
		System.out.println(data.get("username"));
		System.out.println(data.get("browser"));
	}
	//try with resources
	public static List<Map<String, String>> getTestDetails(String sheetname) {
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelfilepath());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet =workbook.getSheet(sheetname);			

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String,String> datamap = null;			

			for(int i=1;i<=lastrownum;i++) {
				datamap = new HashMap<>();
				for(int j=0; j<lastcolnum;j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					datamap.put(key, value);
				}
				list.add(datamap);
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		finally {
			try {
				if (Objects.nonNull(fs)) {
					fs.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(list);
		return list;
	}
	
	@DataProvider
	public static Object[] getData(Method m) {
		String testname=m.getName();
		if (list.isEmpty()) {
			list=getTestDetails(FrameworkConstants.getIterationdatasheet());
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testname) && 
				list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smalllist.add(list.get(i));
				}			
		}
		//list.removeAll(smalllist);
		return smalllist.toArray();		
	}

}
