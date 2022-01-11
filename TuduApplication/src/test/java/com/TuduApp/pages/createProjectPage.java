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


public class createProjectPage extends TestBase{
	
	public static Workbook  book;
	public static Sheet  sheet;

	@FindBy (xpath="//input[@formcontrolname='projectName']")
	WebElement projectName;
	
	@FindBy (xpath="//input[@formcontrolname='projectCode']")
	WebElement projectCode;
	
	@FindBy (xpath="//textarea[@formcontrolname='projectDescription']")
	WebElement projectDescription;
	
	@FindBy (xpath="//mat-select[@placeholder='Client Details']") //Click
	WebElement clientDetailDropdown;
	
		@FindBy (xpath="//mat-option[@class='mat-option ng-star-inserted mat-active'][1]") ////first dropdown value
		WebElement clientDetailSelectValue;
	
	@FindBy (xpath="//input[@formcontrolname='startDate']")
	WebElement startDate;
	
	@FindBy (xpath="//input[@formcontrolname='endDate']")
	WebElement endDate;
	
	@FindBy (xpath="//mat-select[@placeholder='Project Manager/Owner*']") //click as dropdown
	WebElement projectManagerOwner;
		
		@FindBy (xpath="//mat-option[@class='mat-option ng-star-inserted'][2]") //first dropdown value
		WebElement projectManagerOwnerSelect;
	
	//@FindBy (xpath="//div[@class='multiselect-dropdown']/div/span") //Click with checkbox
	@FindBy (xpath="//div[@class=\"cuppa-dropdown\"]//div")
	WebElement selectMembers;
	
		//@FindBy (xpath="//li[@class='filter-textbox ng-star-inserted']/input") //checkbox value search
		@FindBy (xpath="//div[@class='list-filter ng-star-inserted']/input")
		WebElement selectMembersSearchValue;
	
		//@FindBy (xpath="//li[@class='multiselect-item-checkbox ng-star-inserted']") //first checkbox value select
		@FindBy (xpath="//li[@class='pure-checkbox ng-star-inserted']")
		WebElement selectMembersSearchFirstValue;
		
	@FindBy (xpath="//span[text()='Invite New User']") 
	WebElement inviteNewUser;
	
	@FindBy (xpath="//input[@placeholder='Project Type']")
	WebElement projectType;
	
	@FindBy (xpath="//mat-select[@placeholder='Department(Cost Center)']") //click as dropdown
	WebElement departmentCostCenter;
	
		@FindBy (xpath="//mat-option[@class='mat-option ng-star-inserted'][1]") //dropdown First value
		WebElement departmentCostCenterValue;
	
	@FindBy (xpath="//span[text()=' Add Project']")
	WebElement addProjectBtn;
	
	@FindBy (xpath="//span[text()='Cancel']")
	WebElement canceltBtn;
	
	
	public createProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validateProjectName(String Pname) {
		projectName.sendKeys(Pname);
		Log.info("Entered value on project Name - " + Pname);
	}
	public void validateProjectCode(String Pcode) {
		projectCode.sendKeys(Pcode);
		Log.info("Entered value on project code - " + Pcode);
	}
	public void validateProjectDescription(String Pdesc) {
		projectDescription.sendKeys(Pdesc);
		Log.info("Entered value on project Description - " + Pdesc);
	}
	
	public void validateClientDetailDropdown() {
		clientDetailDropdown.click();
		Log.info("Click on Client details dropdown"); 
	}
		public void validateClientDetailSelectValue() {
			clientDetailSelectValue.click();
			Log.info("Value selected on Client details");
		}
	public void validateStartDate() {
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("Document.getElementById('mat-input-22').value='12/8/2021'");
		//js.executeScript("document.getElementsByClassName('mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-touched ng-dirty')[1].setAttribute('value','12/9/2021')"," ");
		
		
		startDate.click();
	}
	public void validatEndDate(String eDate) {
		endDate.sendKeys(eDate);
	}
	public void validateProjectManagerOwner() {
		projectManagerOwner.click();
		Log.info("Click on Project Manager/Owner dropdown");
	}
		public void validateProjectManagerOwnerSelect() {
			projectManagerOwnerSelect.click();
			Log.info("Value selected on Project Manager/Owner");
		}
	
	public void validateSelectMembers() {
		selectMembers.click();
		Log.info("Click on Select Member dropdown");
	}
		public void validatselectMemberSearchValue(String searchValue) {
			selectMembersSearchValue.sendKeys(searchValue);
			Log.info("Entered value to search on Select Member" + searchValue);
			}
		public void validateselectMemberSearchFirstValue() {
			selectMembersSearchFirstValue.click();
			Log.info("Value selected on Select Member");
			}
	public void validateInviteNewUser() {
		inviteNewUser.click();
		Log.info("Invite user link clicked");
	}
	public void validateProjectType(String Ptype) {
		projectType.sendKeys(Ptype);
		Log.info("Entered value on project Type - " + Ptype);
	}
	public void validateDepartmentCostCenter() {
		departmentCostCenter.click();
		Log.info("Click on Department Cost Center dropdown");
	}
		public void validateDepartmentCostCenterValue() {
			departmentCostCenterValue.click();
			Log.info("Value selected on Department Cost Center");
		}
	public void validateAddProjectBtn() {
		addProjectBtn.click();
		Log.info("Add Project button clicked");
	}
	public void validateCanceltBtn() {
		canceltBtn.click();
		Log.info("Cancel button on Create Project clicked");
	}
	
	@DataProvider(name="createproject")
	public static Object[][] CreateProjectData() {
		Object data[][] =getRegisterData("CreateProject");
		return data;
	}	
	
	public static String Register_Data_File="C:\\Users\\Vikesh\\git\\MYtudu\\TuduApplication\\TestData\\NewProject.xlsx";
	
	
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
