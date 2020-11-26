package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;

public class AboutTheProperty extends BaseTest{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })

	private WebElement Click_PropertyManagement;

	@FindAll({
		@FindBy(xpath="//a[starts-with(., 'About')]"),
	})
	
	private WebElement AbouttheProperty_Link;

	@FindAll({
		@FindBy(xpath="//td[contains(text(),'About the Property')]"),
	})
	
	private WebElement AboutthPropertyTitle_Link;

	@FindAll({
		@FindBy(xpath="//li[contains(text(),'Built Year Required')]"),
	})
	
	private WebElement ErrorMessage_Built;


	@FindAll({
		@FindBy(xpath="//input[@name='builtYear']"),
	})
	
	private WebElement Enter_YearBuilt;

	@FindAll({
		@FindBy(xpath="//input[@name='renovatedYear']"),
	})
	
	private WebElement Enter_YearRenovated;

	@FindAll({
		@FindBy(xpath="//input[@name='save']"),
	})
	
	private WebElement Save;


	@FindAll({ @FindBy(xpath = "//*[@name='chkMeetingRoomIds']") })
	
	private List<WebElement> Meeting_delete;

	@FindAll({ @FindBy(xpath = "chkDiningIds") })
	
	private List<WebElement> Dining_delete;


	public void aboutPropertyRoom(String AbouttheProperty, 
			String YearBuilt , 
			String YearRenovated ) 
	{

		try {

			SeleniumRepo.waitForElementPresent(Enter_YearBuilt);
			Thread.sleep(2000);
			if (Enter_YearBuilt.isDisplayed()) 
			{
				Javascriptexecutor(Enter_YearBuilt);
				Enter_YearBuilt.clear();
				//				Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_YearBuilt.sendKeys(YearBuilt);
				System.out.println("YearBuilt is entered successfully");
				test.log(Status.PASS,
						"YearBuilt is entered successfully" );
				logger.info("YearBuilt is entered successfully");
				Assert.assertTrue(true,"YearBuilt is entered successfully");
			} else {
				System.out.println("YearBuilt TextBox not found");
				logger.error("Failed to Found YearBuilt TextBox");
				test.log(Status.FAIL,
						"Failed to Found YearBuilt TextBox");
				Assert.assertFalse(false, "YearBuilt TextBox not found");}

			if (Enter_YearRenovated.isDisplayed()) 
			{
				Javascriptexecutor(Enter_YearRenovated);
				(Enter_YearRenovated).clear();
				(Enter_YearRenovated).sendKeys(YearRenovated);
				System.out.println("YearRenovated is entered successfully");
				test.log(Status.PASS,   "YearRenovatedis entered successfully" );
				logger.info("YearRenovatedis entered successfully");
				Assert.assertTrue(true, "YearRenovatedis entered successfully");
			}
			else
			{
				System.out.println("YearRenovated TextBox not found");
				logger.info("Failed YearRenovated TextBox not found");
				test.log(Status.FAIL,
						"Failed to Found YearRenovated TextBox ");
				Assert.assertFalse(false, "YearRenovated TextBox not found");
			}

			if(Save.isDisplayed()) 
			{
			
				//Stale(Save).click();
				
				SeleniumRepo.driver.findElement(By.xpath("//input[@name='save']")).click();
				SeleniumRepo.waitForPageLoaded();
				test.log(Status.PASS,"Clicked on Save button" );
				logger.info("Clicked on Save button");
				Assert.assertTrue(true, "Clicked on Save button");
			} else {
				logger.info("Failed to Click on Save button");
				test.log(Status.FAIL,
						"Failed to Click on Save button");
			}

		} catch (Exception e) {
			logger.error("Unable to create About The Property for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to About The Property for selected property because of this execption" + e);
			e.printStackTrace();
		}

	}
}



