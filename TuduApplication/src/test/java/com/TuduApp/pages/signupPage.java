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


	
public class signupPage extends TestBase{
	
	public static Workbook  book;
	public static Sheet  sheet;
	
	
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@formcontrolname='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@formcontrolname='orgName']")
	WebElement organizationName;
	
	@FindBy(xpath="//input[@formcontrolname='orgurl']")
	WebElement claimYourUrl;
	
	@FindBy(xpath="//input[@formcontrolname='orgEmail']")
	WebElement organizationEmail;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement workEmail;
	
	@FindBy(xpath="//input[@formcontrolname='website']")
	WebElement websiteUrl;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement signUpPassword;
	
	@FindBy(xpath="//button[text()='Create My Account']")
	WebElement createMyAccount;
	
	@FindBy(xpath="//b[text()=' Sign In']")
	WebElement SignIn;
	
	
	public signupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void signUpFirstName(String fName) {
		firstName.sendKeys(fName);
		Log.info("First name entered - " + fName);
		
	}
	
	public void signUpLastName(String lName) {
		lastName.sendKeys(lName);
		Log.info("Last name entered - " + lName);
	}
	
	public void signUporganizationName(String orgName) {
		organizationName.sendKeys(orgName);
		Log.info("Organization name entered - " + orgName);
	}
	
	public void signUpclaimYourUrl(String claimUrl) {
		claimYourUrl.sendKeys(claimUrl);
		Log.info("Claim Url entered - " + claimUrl);
	}
	
	public void signUporganizationEmail(String orgEmail) {
		organizationEmail.sendKeys(orgEmail);
		Log.info("Organization Email entered - " + orgEmail);
	}
	
	
	public void signUpWorkEmail(String WorkEmail) {
		workEmail.sendKeys(WorkEmail);
		Log.info("Work Email entered - " + WorkEmail);
	}
	
	public void signUpwebsiteUrl(String website) {
		websiteUrl.sendKeys(website);
		Log.info("Website name entered - " + website);
	}
	
	public void signUpPassword(String SignUpPassword) {
		signUpPassword.sendKeys(SignUpPassword);
		Log.info("SignUp Password entered - " + SignUpPassword);
	}
	
	public void createMyAccount() {
		createMyAccount.click();
		Log.info("Clicked on Create MyAccount button");
	}
	
	public void SignIn() {
		SignIn.sendKeys();
		Log.info("Clicked on Sign In button");
	}
	
	
	@DataProvider(name="signup")
	public static Object[][] getsignUpData() {
		//Object data[][] =ExcelUtils.getRegisterData("RegisterData");
		Object data[][] =getRegisterData("RegisterData");
		return data;
	}	
	
	  
		public static String Register_Data_File="C:\\Users\\Vikesh\\git\\MYtudu\\TuduApplication\\TestData\\SignUp.xlsx";
			
		
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

