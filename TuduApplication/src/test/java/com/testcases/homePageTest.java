package com.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Logs.Log;
import com.TestBase.TestBase;
import com.TuduApp.pages.homePage;
import com.TuduApp.pages.loginPage;


public class homePageTest extends TestBase {

	loginPage lp;
	homePage hp;

	@BeforeMethod
	public void setup() throws Throwable {
		invoke();
		Log.startTestCase("homePageTest");
	}

	public void pageObj() throws Throwable {
		lp=new loginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//driver.manage().timeouts().pageLoadTimeout(10,)	
		hp=new homePage(driver);

	}
	@Test(enabled=false)
	public void homeSearchProject(String searchProject) throws Throwable {

		lp=new loginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));

		hp=new homePage(driver);

		hp.validateSearchProject(searchProject);
		String homePageURL=driver.getCurrentUrl();
		System.out.println("Home Page URL is - " +homePageURL);
	}

	@Test(enabled=false)
	public void homeCreateProject() throws Throwable {

		pageObj();
		hp.validateCreateProject();
		String createProjectURL=driver.getCurrentUrl();
		System.out.println("Home Page URL is - " +createProjectURL);
	}

	@Test(groups= {"vikesh2"},description="Verifing Header search",dataProvider = "HeaderSearch", dataProviderClass = homePage.class)
	public void homeHeaderSearchBar(String headerSearch) throws Throwable {
		pageObj();
		hp.ValidateWarningClose();
		hp.validateheaderSearchBar(headerSearch);

	}
	/*
	 * @Test 
	 * public void homeQuickSearch() throws Throwable { 
	 * pageObj();
	 * 
	 * hp.ValidateWarningClose(); hp.validateQuickCreateSearch("new search");
	 * hp.validateAddQuickCreatebtn();
	 * 
	 * }
	 */

	@Test	(enabled=false)
	public void homeAddQuickCreatebtn() throws Throwable {

		pageObj();
		hp.ValidateWarningClose();
		hp.validateAddQuickCreatebtn();
		hp.ValidateAddQuickCreateImportTimesheet();
		//hp.ValidateAddQuickCreateAddProject();

	}

	@Test(enabled=false)
	public void homeProject() throws Throwable {
		pageObj();
		hp.ValidateWarningClose();
		hp.validateProject();
		Thread.sleep(3000);
		hp.validateProjectCreateCProject();
	}

	@Test(enabled=false)
	public void homeTimesheet() throws Throwable {
		pageObj();
		hp.ValidateWarningClose();
		hp.validateTimesheet();	
		Thread.sleep(3000);
		hp.validateTimesheetMonthly();
	}

	@Test(enabled=false)
	public void homeWorkflow() throws Throwable {
		pageObj();
		hp.ValidateWarningClose();
		hp.validateWorkflow();
		hp.validateWorkflowCreateWorkflow();
	}


	@Test(enabled=false)
	public void homeAppSettings() throws Throwable {
		pageObj();
		hp.ValidateWarningClose();
		hp.validateAppSettings();
		hp.validateAppSettingsClient();

	}

	@Test(enabled=false)
	public void homeNotifcationIcon() throws Throwable {
		pageObj();
		hp.ValidateWarningClose();
		hp.validateNotifcationIcon();

	}

	@Test(enabled=false)
	public void homeUserProfile() throws Throwable {
		pageObj();
		hp.ValidateWarningClose();
		hp.validateUserProfile();
		Thread.sleep(3000);
		hp.validateUserProfileChangePassword();
	}
	
	@AfterMethod
	public void teardown() {
		Log.endTestCase("homePageTest");
		driver.close();
	}


}
