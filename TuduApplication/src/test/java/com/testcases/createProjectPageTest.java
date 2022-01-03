package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Logs.Log;
import com.TestBase.TestBase;
import com.TuduApp.pages.createProjectPage;
import com.TuduApp.pages.homePage;
import com.TuduApp.pages.loginPage;

public class createProjectPageTest extends TestBase{

	loginPage lp;
	homePage hp;
	createProjectPage cp;

	@BeforeMethod
	public void setup() throws Throwable {
		invoke();
		pageObj();
		Log.startTestCase("createProjectPageTest");

	}
	public void pageObj() throws Throwable {
		lp=new loginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		hp=new homePage(driver);
		hp.ValidateWarningClose();
		Thread.sleep(4000);
		hp.validateCreateProject();
		cp=new createProjectPage(driver);

	}

	@Test(enabled=false)
	public void createNewProject() throws Throwable {
		pageObj();
		String month="FEB 2020";
		cp.validateStartDate();
		while(true) {
			String value=driver.findElement(By.xpath("//button[@aria-label='Choose month and year']/span")).getText();
			if(value.equals(month)) {
				break;
			}else
			{
				driver.findElement(By.xpath("//*[@id='mat-datepicker-0']/mat-calendar-header/div/div/button[2]")).click();
			}
		}
		driver.findElement(By.xpath("//*[@id='mat-datepicker-0']/div/mat-month-view/table/tbody/tr[3]/td[4]/div")).click();

	}

	@Test(groups= {"vikesh2"},description="Verifing new project creation",dataProvider = "createproject", dataProviderClass = createProjectPage.class)		
	public void NewProject(String Pname, String Pdesc, String searchValue,String Ptype) throws Throwable {
				
		cp.validateProjectName(Pname);
		cp.validateProjectDescription(Pdesc);
		
		cp.validateProjectType(Ptype);

	}
	
	@AfterMethod
	public void teardown() {
		Log.endTestCase("createProjectPageTest");
		driver.close();
	}

}
