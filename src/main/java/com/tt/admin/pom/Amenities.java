package com.tt.admin.pom;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;

public class Amenities extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({
		@FindBy(xpath="//a[contains(text(), 'Amenities')]"),
	})
	
	private WebElement Click_Amenities;

	@FindAll({
		@FindBy(xpath="//a[contains(text(),'+ Add an amenity')]"),
	})
	
	private WebElement Click_Add_Amenity;

	@FindAll({
		@FindBy(xpath="//input[@name = 'name']"),
	})
	
	private WebElement Enter_Amenity_Name;

	@FindAll({
		@FindBy(xpath="//input[@name='type']"),
	})
	
	private List<WebElement> Select_Type;

	@FindAll({
		@FindBy(xpath="//input[@value='Save']"),
	})
	
	private WebElement Save;
	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"),

	})
	private WebElement property_Management;

	public void addAmenity
	(String Amenity_Name,String Type)throws Exception  
	{
		try 
		{
			if (Click_Amenities.isDisplayed()) 
			{
				Javascriptexecutor(Click_Amenities);
				ExplicitWait(Click_Add_Amenity);
				System.out.println("PropertyManagement element Expanded and Amenities element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and Amenities element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and Amenities element  found");
			} 
			else 
			{
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(Click_Amenities);
				if(Click_Amenities.isDisplayed())
				{
					Javascriptexecutor(Click_Amenities);
					ExplicitWait(Click_Add_Amenity);
					System.out.println("Amenities element found");
					test.log(Status.INFO, "Amenities  element found");
					Assert.assertTrue(true, "Amenities element found");
				}
				else
				{
					logger.info("Amenities element not  found");
					test.log(Status.FAIL, "Amenities element not  found");
				}
			}
			
			Thread.sleep(4000);
			
			String body=SeleniumRepo.driver.findElement(By.tagName("body")).getText();
			if(body.contains(Amenity_Name))
			{
				test.log(Status.INFO,Amenity_Name+" Amenitiy  already present and going to be delete");
				logger.info(Amenity_Name+" Amenitiy  already present and going to be delete");
				
				System.out.println("Amenity "+Amenity_Name+" is present and going to delete the amenitys");
				System.out.println("//*[contains(text(),'"+Amenity_Name+"')]/following-sibling::td[2]/a");
				WebElement delete=	SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+Amenity_Name+"')]/following-sibling::td[2]/a"));

				//Thread.sleep(4000);
				try 
				{
					Javascriptexecutor(delete);
					Thread.sleep(2000);
					Alert alert =SeleniumRepo.driver.switchTo().alert();
					String alertText = alert.getText();
					System.out.println("Alert data: " + alertText);
					alert.accept();
				}
				catch (UnhandledAlertException f) 
				{
					try {
						Alert alert =SeleniumRepo.driver.switchTo().alert();
						String alertText = alert.getText();
						System.out.println("Alert data: " + alertText);
						alert.accept();
					}
					catch (NoAlertPresentException e) 
					{
						e.printStackTrace();
						Assert.assertEquals(false, true);
					}
				}
				SeleniumRepo.waitForPageLoaded();
				System.out.println("Amenity "+Amenity_Name+" deleted successfully");
				test.log(Status.INFO,"Amenity "+Amenity_Name+" deleted successfully");
				logger.info("Amenity "+Amenity_Name+" deleted successfully");
			}
			else
			{
				System.out.println(Amenity_Name+" duplicate amenity is not there hence creating new amenity");
				test.log(Status.INFO, Amenity_Name+" duplicate amenity is not there hence creating new amenity");
				logger.info(Amenity_Name+" duplicate amenity is not there hence creating new amenity");
					
			}

			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")));
			Thread.sleep(1000);
			
			if (SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")).isDisplayed()) 
			{
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'+ Add an amenity')]")));
				ExplicitWait(Enter_Amenity_Name);
				System.out.println("Adding new Amenity");
				logger.info("Clicked on Add Amenities Link");
				test.log(Status.PASS,
						"Clicked on Add Amenities Link" );
				Assert.assertTrue(true, 
						"Clicked on Add Amenities Link");
			} else {
				System.out.println("Add Amenities Link not found");
				logger.error("Failed to Click on Add Amenities Link");
				test.log(Status.FAIL,
						"Failed to Click on Add Amenities Link");
				Assert.assertFalse(false, 
						"Add Amenities Link not found");
			}

			if (Enter_Amenity_Name.isDisplayed())
			{
				Enter_Amenity_Name.click();
				Enter_Amenity_Name.clear();
				//			Enter_YearBuilt.sendKeys(YearBuilt+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				Enter_Amenity_Name.sendKeys(Amenity_Name);
				System.out.println("Amenity_Name is entered successfully");
				logger.info("Amenity_Name is entered successfully");
				test.log(Status.PASS,
						"Amenity_Name is entered successfully" );
				Assert.assertTrue(true,
						"Amenity_Name is entered successfully");
			} else {
				System.out.println("Amenity_Name TextBox not found");
				logger.error("Failed to Found Amenity_Name TextBox");
				test.log(Status.FAIL,
						"Failed to Found Amenity_Name TextBox");
				Assert.assertFalse(false,
						"Amenity_Name TextBox not found");
			}

			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Select_Type, Type);
				System.out.println("Charge Frequency is Selected succesfully");
				logger.info("Charge Frequency is Selected succesfully");
				test.log(Status.PASS,
						"Charge Frequency is Selected succesfully" );
				Assert.assertTrue(true,
						"Charge Frequency is Selected succesfully");
			} catch (Exception e) {
				System.out.println("Charge Frequency is not Selected");
				logger.error("Failed to Select Charge Frequency");
				test.log(Status.FAIL,
						"Failed to Select Charge Frequency");
				Assert.assertFalse(false,
						"Charge Frequency is not Selected");
				e.printStackTrace();}

			try {
				Save.click();
				SeleniumRepo.waitForPageLoaded();
				System.out.println("saved");
				logger.info("Clicked on Save button");
				test.log(Status.PASS,
						"Clicked on Save button" );
				Thread.sleep(4000);

			} catch (Exception e1) {
				System.out.println("Not saved");
				logger.error("Failed to Click on Save button");
				test.log(Status.FAIL,
						"Failed to Click on Save button");
				e1.printStackTrace();
				Assert.assertEquals(false, true);
			}

		} catch (Exception e) 
		{
			logger.error("Unable to create Amenties for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to Amenties type for selected property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}	


}	

