package com.TuduApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.Logs.Log;
import com.TestBase.TestBase;
import com.Tudu.utility.ExcelUtils;
 
public class loginPage extends TestBase {
	
	@FindBy (xpath="//input[@id='email']")
	WebElement username;
	
	@FindBy (id="password")
	WebElement password;
	
	@FindBy (xpath="//button[@class='btn login-button mt-4']")
	WebElement submitButton;
	
	@FindBy (id="mat-checkbox-1-input")
	WebElement rememberMeCheckbox;
	
	@FindBy (xpath="//div[@class='forgot-password']/a")
	WebElement forgotPasswordLink;
	
	@FindBy (xpath="//a[@routerlinkactive='router-link-active']/b")
	WebElement signUpLink;
	
		public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		@DataProvider(name="Login")
		public static Object[][] getsignUpData() {
			Object data[][] =ExcelUtils.getRegisterData("SetUp");
			return data;
		}

	public void login(String uname, String pwd) throws Throwable {
		
		username.sendKeys(uname);
		Log.info("Username Entered");
		password.clear();
		password.sendKeys(pwd);
		Log.info("Username Entered");
				
		submitButton.click();
		Log.info("Cliked on submit button");
		Thread.sleep(8000);
		
		}
	
	public void Uname(String uname) {
		username.sendKeys(uname);
		Log.info("Username Entered");
		
	}
	
	public void pwd(String Password) {
		password.sendKeys(Password);
		Log.info("password Entered");
		
	}
	public void submit() throws InterruptedException {
		submitButton.click();
		Log.info("Cliked on submit button");
		Thread.sleep(8000);
		
	}
	
	public void forgetPassword() {
		
		forgotPasswordLink.click();
		Log.info("Open Forget Password page");
		
	}
	
	public void signUp() {
		
		signUpLink.click();
		Log.info("Open sign up page");
	}
		
}
