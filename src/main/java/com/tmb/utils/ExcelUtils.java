package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constans.FrameworkConstants;

public class ExcelUtils {

	private ExcelUtils() {
		
	}
	//try with resources
	public static List<Map<String, String>> getTestDetails(String sheetname) {		
		FileInputStream fs = null;
		XSSFWorkbook workbook;
		List<Map<String,String>> list = null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelfilepath());
			workbook= new XSSFWorkbook(fs);
			XSSFSheet sheet =workbook.getSheet(sheetname);			
					
			int lastrownum=sheet.getLastRowNum();
			int lastcolnum=sheet.getRow(0).getLastCellNum();
			
			Map<String,String> datamap = null;
			list = new ArrayList<>();
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
		return list;					
	}
}
