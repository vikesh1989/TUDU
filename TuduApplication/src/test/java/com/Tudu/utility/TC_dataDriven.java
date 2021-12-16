package com.Tudu.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TuduApp.pages.loginPage;
import com.TuduApp.pages.signupPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_dataDriven extends TestBase{
	WebDriver driver;
	loginPage lp;
	ExcelUtils util=new ExcelUtils();
	signupPage su;
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@Test(dataProvider="EnterUsernamePassword")
	public void Aimdek(String UserName,String Password) throws Throwable {
		lp = new loginPage(driver);
		driver.get("http://abc.shopomate.com/#/login");
		lp.login(UserName, Password);
		
		System.out.println(UserName +"======"+Password);
		//util.getScreenshot(driver);
		
	}
	
	@DataProvider
	public Object[][] EnterUsernamePassword(){
		
		readExcelData obj=new readExcelData("C:\\Users\\Vikesh\\Vikesh_eclipse\\TuduApplication\\TestData\\Business configuration.xlsx");
	
		int rowdata=obj.GetRowCount(0);
		Object data[][]=new Object[rowdata][2];
		for(int i=0;i<rowdata;i++) 
		{
			data [i][0]=obj.getData(0, i, 0);
			data [i][1]=obj.getData(0, i, 1);	
		}
		return data;
	}
	
	@DataProvider
	public Object[][] newSighnUpDetails(){
		
		readExcelData obj=new readExcelData("C:\\Users\\Vikesh\\Vikesh_eclipse\\TuduApplication\\TestData\\Registration.xlsx");
	
		int rowdata=obj.GetRowCount(0);
		Object data[][]=new Object[rowdata][8];
		for(int i=0;i<rowdata;i++) 
		{
			data [i][0]=obj.getData(0, i, 0);
			data [i][1]=obj.getData(0, i, 1);
			data [i][2]=obj.getData(0, i, 2);
			data [i][3]=obj.getData(0, i, 3);
			data [i][4]=obj.getData(0, i, 4);
			data [i][5]=obj.getData(0, i, 5);
			data [i][6]=obj.getData(0, i, 6);
			data [i][7]=obj.getData(0, i, 7);
		}
		return data;
	}

}
