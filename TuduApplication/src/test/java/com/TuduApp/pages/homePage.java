package com.TuduApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.Logs.Log;
import com.TestBase.TestBase;
import com.Tudu.utility.ExcelUtils;

public class homePage extends TestBase{
		
		@FindBy(xpath="//mat-icon[text()='close']")
		WebElement warningClose;
	
	
		@FindBy (xpath="//input[@class='issue-search-box']")
		WebElement searchProject;

		@FindBy(xpath="//span[text()='Create Project']")
		WebElement createProject;
		
		@FindBy(name="search")
		WebElement headerSearchBar;
		

		@FindBy(name="quickcreate")
		WebElement quickCreateSearch;
		
		@FindBy(id="morebtn")
		WebElement addQuickCreatebtn;
		

		@FindBy(xpath="//span[text()=' Add Projects']")
		WebElement addQuickCreateAddProject;
		
		@FindBy(xpath="//span[text()=' Add Task']")
		WebElement addQuickCreateAddTask;
		
		@FindBy(xpath="//span[text()=' Add Files']")
		WebElement adddQuickCreateAddFiles;
		
		@FindBy(xpath="//span[text()=' Add User']")
		WebElement addQuickCreateAddUser;
		
		@FindBy(xpath="//span[text()=' Import Timesheet']")
		WebElement addQuickCreateImportTimesheet;
		
				
		@FindBy(xpath="//li[text()=' Projects ']")
		WebElement project;
			
			@FindBy(xpath="//a[text()='View All Projects']")
			WebElement projectViewAllProject;
		
			@FindBy(xpath="//a[text()='Create Project']")
			WebElement projectCreateCProject;
		
		@FindBy(xpath="//li[text()=' Timesheet ']")
		WebElement timesheet;
		
			@FindBy(xpath="//a[text()='Create Timesheet']")
			WebElement timesheetCreateTimesheet;
		
			@FindBy(xpath="//a[text()='Weekly']")
			WebElement timesheetWeekly;
			
			@FindBy(xpath="//a[text()='Monthly']")
			WebElement timesheetMonthly;
			
			@FindBy(xpath="//a[text()='Generics']")
			WebElement timesheetGenerics;
			
			@FindBy(xpath="//a[text()='Pending Timesheet Submissions']")
			WebElement timesheetPendingTimesheetsubmission;
			
			@FindBy(xpath="//a[text()='Pending Timesheet Approvals']")
			WebElement timesheetPendingTimesheetApprovals;
			
			@FindBy(xpath="//a[text()='Pending Timesheet Creations']")
			WebElement timesheetPendingTimesheetCreations;
		
		@FindBy(xpath="//li[text()=' Workflow ']")
		WebElement workflow;
			
			@FindBy(xpath="//a[text()='Create Workflow ']")
			WebElement workflowCreateWorkflow;
		
		@FindBy(xpath="//li[text()=' App Settings ']")
		WebElement appSettings;	
		
			@FindBy(xpath="//a[text()='Organization']")
			WebElement appSettingsOrganization;
			
			@FindBy(xpath="//a[text()='Manage User']")
			WebElement appSettingsManageUser;
			
			@FindBy(xpath="//a[text()='Manage Role']")
			WebElement appSettingsManageRole;
			
			@FindBy(xpath="//a[text()='Department']")
			WebElement appSettingsDepartment;
			
			@FindBy(xpath="//a[text()='Client']")
			WebElement appSettingsClient;
		
		@FindBy(xpath="//div[@class='notification-icon-container mat-menu-trigger']")
		WebElement notifcationIcon;
		
		@FindBy(xpath="//div[@class='cursor-pointer mat-menu-trigger']")
		WebElement userProfile;
		
			@FindBy(xpath="//div[@class=\"mat-menu-content\"]/button[1]")
			WebElement userProfilprofile;
			
			@FindBy(xpath="//span[text()='Change Password']")
			WebElement userProfileChangePassword;
			
			@FindBy(xpath="//span[text()='Logout']")
			WebElement userProfileLogout;
		
		
		public homePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void ValidateWarningClose() {
			warningClose.click();
			Log.info("Waring pop up message of trial get closed");
			
		}
		
		/*Same name method we can't call it with header search
		 * 
		 * @DataProvider(name="searchProject") public static Object[][] getsignUpData()
		 * { Object data[][] =ExcelUtils.getRegisterData("SearchProject"); return data;
		 * 
		} */
		
		public void displayCtreatebutton() {			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElements(warningClose));
			Log.info("Waring close button is visible" );	
		}
		public void validateSearchProject(String search) {
			
			searchProject.sendKeys(search);
			Log.info("entered value on project search bar");
		}
		@DataProvider(name="searchProject")
		public static Object[][] getsignUpData() {
			Object data[][] =ExcelUtils.getRegisterData("searchProject");
			return data;
		}
		
		public void validateCreateProject() {			
			createProject.click();
			Log.info("Create project page open");
		}
		
		/*
		 * @DataProvider(name="HeaderSearch") public static Object[][] getsignUpData() {
		 * Object data[][] =ExcelUtils.getRegisterData("HeaderSearch"); return data; }
		 */
		
		public void validateheaderSearchBar(String search) {
			
			headerSearchBar.sendKeys(search);
			Log.info("entered value on main search bar");
		}
		
		public void validateQuickCreateSearch(String search) {
			quickCreateSearch.sendKeys(search);
			Log.info("entered value on Quick search bar");
			
		}
		
		public void validateAddQuickCreatebtn() {			
			addQuickCreatebtn.click();
			Log.info("open Quick create pop up menu");
		}	
		
			public void ValidateAddQuickCreateAddProject() {			
				addQuickCreateAddProject.click();
				Log.info("open Quick create pop up menu navigate to add project");
			}
		
			public void ValidateAddQuickCreateAddTask() {			
				addQuickCreateAddTask.click();
				Log.info("open Quick create pop up menu navigate to add task");
			}

			public void ValidateAddQuickCreateAddFiles() {	
				adddQuickCreateAddFiles.click();
				Log.info("open Quick create pop up menu navigate to add files");
			}

			public void ValidateAddQuickCreateAddUser() {				
				addQuickCreateAddUser.click();
				Log.info("open Quick create pop up menu navigate to add users");
			}
		
			public void ValidateAddQuickCreateImportTimesheet() {				
				addQuickCreateImportTimesheet.click();
				Log.info("open Quick create pop up menu navigate to Import Timesheet");
			}
			
		
		public void validateProject() {
			project.click();
			Log.info("Clicked on Project menu button");
		}
		
			public void validateProjectViewAllProject(){
		 	
				projectViewAllProject.click();
				Log.info("Clicked on Project menu > View all project button");
			}
		
			public void validateProjectCreateCProject() {
				
				projectCreateCProject.click();
				Log.info("Clicked on Project menu > Create project button");
			}
		
		public void validateTimesheet() {
			timesheet.click();
			Log.info("Clicked on Timesheet menu button");
		}
			
			public void validateTimesheetCreateTimesheet() {
				timesheetCreateTimesheet.click();
				Log.info("Clicked on Timesheet menu > Create Timesheet button");
			}
			
			public void validateTimesheetWeekly() {
				timesheetWeekly.click();
				Log.info("Clicked on Timesheet menu > Timesheet Weekly button");
			}
			
			public void validateTimesheetMonthly() {
				timesheetMonthly.click();
				Log.info("Clicked on Timesheet menu > Timesheet Monthly button");
			}
			
			public void validateTimesheetGenerics() {
				timesheetGenerics.click();
				Log.info("Clicked on Timesheet menu > Timesheet Generics button");
			}
			
			public void validateTimesheetPendingTimesheetsubmission() {
				timesheetPendingTimesheetsubmission.click();
				Log.info("Clicked on Timesheet menu >Pending Timesheet submission button");
			}
			
			public void validateTimesheetPendingTimesheetApprovals() {
				timesheetPendingTimesheetApprovals.click();
				Log.info("Clicked on Timesheet menu >Pending Timesheet Approvals button");
			}
			
			public void validateTimesheetPendingTimesheetCreations() {				
				timesheetPendingTimesheetCreations.click();
				Log.info("Clicked on Timesheet menu >Pending Timesheet Creations button");
			}
			
		
		public void validateWorkflow() {
			workflow.click();
			Log.info("Clicked on Workflow menu button");
		}
		
			public void validateWorkflowCreateWorkflow() {
				workflowCreateWorkflow.click();
				Log.info("Clicked on Workflow menu >Create Workflow button");
				
			}
					
		public void validateAppSettings() {
			appSettings.click();
			Log.info("Clicked on App Setting menu button");
		}
			
			public void validateAppSettingsOrganization() {
			appSettingsOrganization.click();
			Log.info("Clicked on App Setting menu > Organization button");
			}
			
			public void validateAppSettingsManageUser() {
				appSettingsManageUser.click();
				Log.info("Clicked on App Setting menu > Manage User button");
			}
			
			public void validateAppSettingsManageRole() {
				appSettingsManageRole.click();
				Log.info("Clicked on App Setting menu > Manage Role button");
			}
			
			public void validateAppSettingsDepartment() {
				appSettingsDepartment.click();
				Log.info("Clicked on App Setting menu > Department button");
			}
			
			public void validateAppSettingsClient() {
				appSettingsClient.click();
				Log.info("Clicked on App Setting menu > Client button");
			}
					
		public void validateNotifcationIcon() {
			notifcationIcon.click();
			Log.info("Clicked on NotifcationIcon");
		}
		
		public void validateUserProfile() {
			userProfile.click();
			Log.info("Clicked on User profile Icon");
		}
		
			public void validateUserProfilprofile() {				
				userProfilprofile.click();
				Log.info("Clicked on User profile Icon > Profile button");
			}
			
			public void validateUserProfileChangePassword() {
				userProfileChangePassword.click();
				Log.info("Clicked on User profile Icon > Change Password button");
			}
			
			public void validateUserProfileLogout() {
				userProfileLogout.click();
				Log.info("Clicked on User profile Icon > Logout button");
			}
		
}
