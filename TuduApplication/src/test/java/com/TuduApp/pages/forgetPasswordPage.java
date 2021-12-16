package com.TuduApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.Logs.Log;
import com.TestBase.TestBase;
import com.Tudu.utility.ExcelUtils;

public class forgetPasswordPage extends TestBase{
	
	@FindBy(xpath="//input[@placeholder='Work Email']")
	WebElement workEmail;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitbtn;
	
		
	public forgetPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void forgotPwdWorkEmail(String WorkEmail) {
		workEmail.sendKeys(WorkEmail);
		Log.info("Entered email address you registered with Tudu" + WorkEmail);
		
	}
	
	public void forgotPwdSubmitBtn() {
		submitbtn.click();
		Log.info("Clicked on forgot password > Submit button");
				
	}
	@DataProvider(name="forgotPwd")
	public static Object[][] getsignUpData() {
		Object data[][] =ExcelUtils.getRegisterData("ForgotPassword");
		return data;
	}

}
