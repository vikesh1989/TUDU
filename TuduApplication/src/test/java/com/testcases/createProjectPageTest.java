package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		hp.displayCtreatebutton();
		hp.ValidateWarningClose();
		Thread.sleep(5000);
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

	@Test(priority=4,groups= {"vikesh2"},description="Verifing new project creation",dataProvider = "createproject", dataProviderClass = createProjectPage.class)		
	public void NewProject(String Pname, String Pdesc, String searchValue,String Ptype) throws Throwable {
				
		
		cp.validateProjectName(Pname); 
		cp.validateProjectDescription(Pdesc);
		Thread.sleep(2000);
		cp.validateClientDetailDropdown(); 
		cp.validateClientDetailSelectValue();
		Thread.sleep(2000);
		cp.validateProjectManagerOwner(); 
		cp.validateProjectManagerOwnerSelect();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(2000);
		
		cp.validateSelectMembers();
		cp.validatselectMemberSearchValue(searchValue);
		cp.validateselectMemberSearchFirstValue();
		Thread.sleep(2000);
		cp.validateProjectType(Ptype);
		cp.validateDepartmentCostCenter();Thread.sleep(2000);
		cp.validateDepartmentCostCenterValue();
		Thread.sleep(2000);
		cp.validateAddProjectBtn();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void teardown() {
		Log.endTestCase("createProjectPageTest");
		driver.close();
	}

}
