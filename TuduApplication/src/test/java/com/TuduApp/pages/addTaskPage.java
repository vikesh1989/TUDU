package com.TuduApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addTaskPage {
	
	@FindBy(xpath="//mat-select[@placeholder='Project']")
	WebElement projectDropdown;


		@FindBy (xpath="//span[contains(text(),'testing ')]")
		WebElement selectProjectValue;
	
	@FindBy (xpath="//mat-select[@formcontrolname='taskType']")
	WebElement issueType;	
	
		@FindBy (xpath="//span[contains(text(),'Bug')]/i")
		WebElement issueTypeSelectValue;
		
	@FindBy (xpath="//input[@formcontrolname='taskName']") //sendkeys
	WebElement issueName;
	
	@FindBy (xpath="//p[@data-placeholder='Enter Task Description...']") //sendkeys
	WebElement taskDescription;
	
	@FindBy (xpath="//span[text()='Assigned To']") //
	WebElement assignedTo;
	
	@FindBy (xpath="//input[@formcontrolname='startDate']") //
	WebElement startDate;
	
	@FindBy (xpath="//span[text()='Assigned To']") ////span[text()=' 3.1 ']
	WebElement release;
	
		@FindBy (xpath="//span[text()=' 3.1 ']") 
		WebElement releaseselectValue;
	
	@FindBy (xpath="//input[@formcontrolname='endDate']") 
	WebElement estimatedTime;
	
	@FindBy (xpath="//input[@formcontrolname='endDate']") 
	WebElement priority;
	
		@FindBy (xpath="//span[contains(text(),'HIGH')]") 
		WebElement prioritySelectValue;
	
	
	@FindBy (xpath="//input[@formcontrolname='endDate']") 
	WebElement difficult;
		
		@FindBy (xpath="//span[contains(text(),'HIGH')]") 
		WebElement difficultSelectValue;
	
	@FindBy (xpath="//input[@formcontrolname='endDate']") 
	WebElement createBtn;
	
	public addTaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateProjectDropdown() {
		projectDropdown.click();
	}
		public void ValidateSelectProjectValue() {
			selectProjectValue.click();
		}
		
				
		
}
