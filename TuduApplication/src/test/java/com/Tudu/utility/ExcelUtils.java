package com.Tudu.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import com.TestBase.TestBase;
import com.TuduApp.pages.loginPage;
import com.TuduApp.pages.signupPage;

public class ExcelUtils extends TestBase {
	
	public static Workbook  book;
	public static Sheet  sheet;
	loginPage lp;
	signupPage su;
	
	 
	public static String Register_Data_File="C:\\Users\\Vikesh\\Vikesh_eclipse\\TuduApplication\\TestData\\Registration.xlsx";
		
	
	public static Object[][] getRegisterData(String SheetName) {
		FileInputStream file=null;
	    
		try {
			file=new FileInputStream(Register_Data_File);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Data Reading");
		sheet=book.getSheet(SheetName);
		Object data[][]= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
				//System.out.println(data[i][j]);				
			}			
		}
		return data;
	}		
	
	public void pageObj() throws Throwable {
		lp = new loginPage(driver);
		lp.signUp();
		
		su = new signupPage(driver);
			
	}
	
	@BeforeTest
	public void setup() throws Throwable {

		invoke();
		pageObj();
		
	}
	
	
	
	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		System.out.println(path);
		return path;
	}
	
	 				
}


