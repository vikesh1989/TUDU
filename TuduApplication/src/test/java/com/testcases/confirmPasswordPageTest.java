package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Logs.Log;
import com.TestBase.TestBase;
import com.Tudu.utility.ExcelUtils;
import com.TuduApp.pages.confirmPasswordPage;
import com.TuduApp.pages.homePage;
import com.TuduApp.pages.loginPage;

public class confirmPasswordPageTest extends TestBase{
	
	loginPage lp;
	homePage hp;
	confirmPasswordPage cpp;
	ExcelUtils eu=new ExcelUtils();
	
	@BeforeMethod
	public void setup() throws Throwable {
		invoke();
		Log.startTestCase("confirmPasswordPageTest");
	}
	
	public void pageObj() throws Throwable {
		lp=new loginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		hp=new homePage(driver);
		hp.displayCtreatebutton();
		cpp=new confirmPasswordPage(driver);
				
	}
	
	@Test(priority=5,description="Verifing change password functionality",dataProvider = "Password", dataProviderClass = confirmPasswordPage.class)
	public void changePassword(String OldPassword,String NewPassword,String ConfirmPassword) throws Throwable {
		
		pageObj();
		hp.ValidateWarningClose();
		hp.validateUserProfile();
		Thread.sleep(3000);
		hp.validateUserProfileChangePassword();
		Thread.sleep(3000);
		
		cpp.ValidateOldPwd(OldPassword);
	    cpp.ValidateNewPwd(NewPassword);
		cpp.ValidateConfirmPwd(ConfirmPassword);
		cpp.validatePasswordSubmitBtn();
		Thread.sleep(2000);
		
	}

	@AfterMethod
	public void teardown() {
		Log.endTestCase("confirmPasswordPageTest");
		driver.close();
	}
	
	
}
