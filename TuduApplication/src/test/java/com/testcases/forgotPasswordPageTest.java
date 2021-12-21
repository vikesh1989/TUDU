package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Logs.Log;
import com.TestBase.TestBase;
import com.TuduApp.pages.forgetPasswordPage;
import com.TuduApp.pages.loginPage;


public class forgotPasswordPageTest extends TestBase {
	
	loginPage lp;
	forgetPasswordPage fPwd;
	
	@BeforeMethod
	public void setup() throws Throwable {
	invoke();
	Log.startTestCase("forgotPasswordPageTest");
		
	}
	
	@Test (groups= {"vikesh2"},dataProvider = "forgotPwd", dataProviderClass = forgetPasswordPage.class)
	public void forgotPwdWorkEmail(String WorkEmail) {
		lp = new loginPage(driver);
		lp.forgetPassword();
		fPwd = new forgetPasswordPage(driver);
		
		fPwd.forgotPwdWorkEmail(WorkEmail);	
	}
	@Test(enabled=false)
	public void fogotPwdSubmit() {
		
		lp = new loginPage(driver);
		lp.forgetPassword();
		fPwd = new forgetPasswordPage(driver);
		fPwd.forgotPwdSubmitBtn();
		
	}
	
	@AfterMethod
	public void teardown() {
		Log.endTestCase("forgotPasswordPageTest");
		driver.close();
	}
}
