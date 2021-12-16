package com.Tudu.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TuduApp.pages.loginPage;
import com.TuduApp.pages.signupPage;

public class ExcelDemo  {
	
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider="test")
	public void tescase(String fName, String lName, String orgName, String claimUrl, String orgEmail,
			String workEmail, String website, String signUpPassword) {
		
		System.out.println(fName + lName + orgName +claimUrl +orgEmail +workEmail +website +signUpPassword );
	}
	
	
	@DataProvider(name="test")
public Object[][] newsheet() throws IOException {
	
	XSSFWorkbook workbook=new XSSFWorkbook("C:\\Users\\Vikesh\\Vikesh_eclipse\\TuduApplication\\TestData\\Registration.xlsx");
	XSSFSheet sheet=workbook.getSheetAt(0);
	int rowcount=sheet.getPhysicalNumberOfRows();
	XSSFRow row=sheet.getRow(0);
	int ColCount=row.getLastCellNum();
	Object[][] data=new Object[rowcount][ColCount];
	
	for(int i=0;i<rowcount;i++) {
		
		row=sheet.getRow(i+1);
		for(int j=0;j<ColCount;j++) {
			
			XSSFCell cell=row.getCell(j);
			data[i][j]=formatter.formatCellValue(cell);
			
			//System.out.println(data[i][j]);
		}
		
	}
		return data;
	}

	
}
