package com.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Logs.Log;
import com.TestBase.TestBase;
import com.TuduApp.pages.loginPage;
import com.TuduApp.pages.signupPage;

public class signUpTest extends TestBase {

	loginPage lp;
	signupPage su;
	

	@BeforeMethod
	public void setup() throws Throwable {

		invoke();
		pageObj();
		Log.startTestCase("signUpTest");
	}

	public void pageObj() throws Throwable {
		lp = new loginPage(driver);
		lp.signUp();
		
		su = new signupPage(driver);
	
	}

		
	@Test(groups= {"vikesh2"},dataProvider = "signup", dataProviderClass = signupPage.class)
	
		public void signUpDetails(String fName, String lName, String orgName, String claimUrl, String orgEmail,
			String workEmail, String website, String signUpPassword) throws Throwable {
		 	 
		 su.signUpFirstName(fName);	
		 su.signUpLastName(lName);
		 su.signUporganizationName(orgName);
		 su.signUpclaimYourUrl(claimUrl); 
		 su.signUporganizationEmail(orgEmail);
		 su.signUpWorkEmail(workEmail); 
		 su.signUpwebsiteUrl(website);
		 su.signUpPassword(signUpPassword);
		 
		}
	
	@AfterMethod
	public void teardown() {
		Log.endTestCase("signUpTest");
		driver.close();
	}

	
}
