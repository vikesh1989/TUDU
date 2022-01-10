package com.TuduApp.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import com.Logs.Log;
import com.TestBase.TestBase;


public class confirmPasswordPage extends TestBase{
	
	public static Workbook  book;
	public static Sheet  sheet;
	
	@FindBy(xpath="//input[@formcontrolname='oldPassword']")
	WebElement oldPassword;
	
	@FindBy(xpath="//input[@formcontrolname='newPassword']")
	WebElement newPassword;
	
	@FindBy(xpath="//input[@formcontrolname='confirmPassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement passwordSubmitBtn;
	
	public confirmPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateOldPwd(String OldPassword) {
		oldPassword.sendKeys(OldPassword);
		Log.info("Old Password entered");
		
	}
	
	public void ValidateNewPwd(String NewPassword) {
		newPassword.sendKeys(NewPassword);
		Log.info("New Password entered");
	}
	
	public void ValidateConfirmPwd(String ConfirmPassword) {
		confirmPassword.sendKeys(ConfirmPassword);
		Log.info("confirm Password entered");
	}
	public void validatePasswordSubmitBtn() {
		passwordSubmitBtn.click();
	}
	
	@DataProvider(name="Password")
	public static Object[][] pwdchange() {
		Object data[][] =getRegisterData("ChangePassword");
		return data;
	}
      
	public static String Register_Data_File="C:\\Users\\Vikesh\\git\\MYtudu\\TuduApplication\\TestData\\password.xlsx";
		
	
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

}
