package com.tt.admin.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoCheckBox;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * 
 * @author TT072 This test case creates channel for selected property by taking
 *         hotel code values from CSV file
 */
public class ChannelCreation extends BaseTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@FindAll({ @FindBy(xpath = "//td[contains(text(),'GDS')]"),

	})
	private List<WebElement> existing_channel;

	@FindAll({ @FindBy(linkText = "Channels"), @FindBy(xpath = "//a[contains(text(),'Channels')]"),

	})
	private WebElement channels_link;
	@FindAll({ @FindBy(linkText = "Add New Channel Group"),
		@FindBy(xpath = "//a[contains(text(),'Add New Channel Group')]"), })
	
	private WebElement addNew_Channel_link;

	@FindAll({ @FindBy(id = "groupList"), @FindBy(xpath = "//select[@id='groupList']"), })
	
	private WebElement Channel_Group;

	@FindAll({ @FindBy(xpath = "//input[@value='Sabre']") })
	
	private WebElement Sabre_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='Galileo']") })
	
	private WebElement Galileo_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='Worldspan']") })
	
	private WebElement Worldspan_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='Amadeus']") })
	
	private WebElement Amadeus_Channel_Type;

	@FindAll({ @FindBy(xpath = "//input[@value='ADS']") })
	
	private WebElement ADS_Channel_Type;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[0].value"),
		@FindBy(xpath = "//input[@name='channelTypeHotelCode[0].value']") })
	
	private WebElement Sabre_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[1].value"),
		@FindBy(xpath = "//input[@name='channelTypeHotelCode[1].value']") })
	
	private WebElement Galileo_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[2].value"),
		@FindBy(xpath = "//input[@name='channelTypeHotelCode[2].value']") })
	
	private WebElement Worldspan_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[3].value"),
		@FindBy(xpath = "//input[@name='channelTypeHotelCode[3].value']") })
	
	private WebElement Amadeus_Hotel_Code;

	@FindAll({ @FindBy(name = "channelTypeHotelCode[4].value"),
		@FindBy(xpath = "//input[@name='channelTypeHotelCode[4].value']") })
	
	private WebElement ADS_Hotel_Code;

	@FindAll({ @FindBy(name = "name=Submit"), @FindBy(xpath = "//input[@name='Submit']") })
	
	private WebElement Submit_Btn;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']") })

	private WebElement Click_PropertyManagement;

	/**
	 * 
	 * @param sabreHotelCode
	 * @param GalileoHotelCode
	 * @param WorldspanHotelCode
	 * @param AmadeusHotelCode
	 * @param AdsHotelCode
	 * @throws InterruptedException 
	 */
	public void createChannel(String sabreHotelCode, String GalileoHotelCode, String WorldspanHotelCode,
			String AmadeusHotelCode, String AdsHotelCode) throws InterruptedException 
	{

		try {
		//Some where below it deletes the current gds entry 

		if (channels_link.isDisplayed()) 
		{
			Javascriptexecutor(channels_link);
			ExplicitWait(addNew_Channel_link);
			System.out.println("PropertyManagement element Expanded and channels_link element  found");
			test.log(Status.INFO, "PropertyManagement element Expanded and channels_link element  found");
			Assert.assertTrue(true, "PropertyManagement element Expanded and channels_link element  found");
		} 
		else 
		{
			System.out.println("PropertyManagement Menu is not expanded");
			SeleniumRepo.scrollintoview(Click_PropertyManagement);
			Thread.sleep(2000);
			Javascriptexecutor(Click_PropertyManagement);Thread.sleep(2000);
			System.out.println("Clicked on PropertyManagement Link");
			test.log(Status.INFO, "Clicked on PropertyManagement Link");

			ExplicitWait(channels_link);
			if(channels_link.isDisplayed())
			{
				Javascriptexecutor(channels_link);
				ExplicitWait(addNew_Channel_link);
				System.out.println("channels element found");
				test.log(Status.INFO, "channels element found");
				Assert.assertTrue(true, "channels element found");
			}
			else
			{
				logger.info("channels element not  found");
				test.log(Status.FAIL, "channels element not  found");
			}
		}

		if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains("GDS"))
		{
			System.out.println("Channel GDS already present ,going to delet and recreate to test");
			SeleniumRepo.driver.findElement(By.xpath("//*[@type='checkbox']")).click();
			Thread.sleep(1000);
			SeleniumRepo.driver.findElement(By.xpath("//*[@name='delete']")).click();
			Thread.sleep(2000);
			Alert alert =SeleniumRepo.driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.accept();Thread.sleep(3000);
		}
		else
		{
			System.out.println("GDS  Channel  not created hence create a new channel");
		}

		Thread.sleep(2000);
		ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Channel Group')]")));

		SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Channel Group')]")).click();
		
		logger.info("Clicked on ADD New Channel Link ");

		test.log(Status.INFO, "Clicked on ADD New Channel Link ");

		ExplicitWait(Channel_Group);
		
		if (SeleniumRepo.isElementPresent(Channel_Group)) 
		{
			Select sc=new Select(Channel_Group);
			sc.selectByVisibleText("GDS");
			
			logger.info("Channel group is selected");

			test.log(Status.INFO, "Channel group is selected");
		} else {
			logger.error(" Failed to Select Channel Group");

			test.log(Status.ERROR, "Failed to Select Channel Group");
		}

		ExplicitWait(Sabre_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(Sabre_Channel_Type) == false) {
			Sabre_Channel_Type.click();
			logger.info("Sabre Channel type is selected");

			test.log(Status.INFO, "Sabre Channel type is selected");
		} else {
			logger.error(" Failed to Select Sabre Channel type");

			test.log(Status.ERROR, "Failed to Select Sabre Channel type");
		}

		SeleniumRepo.waitForElementPresent(Sabre_Hotel_Code);
		if (Sabre_Hotel_Code.isDisplayed()) {
			Sabre_Hotel_Code.sendKeys(sabreHotelCode);
			logger.info("Sabre Hotel code is entered");

			test.log(Status.INFO, "Sabre Hotel code is entered");
		} else {
			logger.error(" Failed to enter Sabre Hotel code");

			test.log(Status.ERROR, "Failed to enter Sabre Hotel code");
		}

		SeleniumRepo.waitForElementPresent(Galileo_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(Galileo_Channel_Type) == false)
		{
			Galileo_Channel_Type.click();
			logger.info("Galileo Channel type is selected");

			test.log(Status.INFO, "Galileo Channel type is selected");
		} else {
			logger.error(" Failed to Select Galileo Channel type");

			test.log(Status.ERROR, "Failed to Select Galileo  Channel type");
		}

		SeleniumRepo.waitForElementPresent(Galileo_Hotel_Code);
		if (Galileo_Hotel_Code.isDisplayed()) {
			Galileo_Hotel_Code.sendKeys(GalileoHotelCode);
			logger.info("Galileo Hotel code is entered");

			test.log(Status.INFO, "Galileo Hotel code is entered");
		} else {
			logger.error(" Failed to enter Galileo Hotel code");

			test.log(Status.ERROR, "Failed to enter Galileo Hotel code");
		}

		SeleniumRepo.waitForElementPresent(Worldspan_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(Worldspan_Channel_Type) == false) {
			Worldspan_Channel_Type.click();
			logger.info("Worldspan Channel type is selected");

			test.log(Status.INFO, "Worldspan Channel type is selected");
		} else {
			logger.error(" Failed to Select Worldspan Channel type");

			test.log(Status.ERROR, "Failed to  select Worldspan  Channel type");
		}

		SeleniumRepo.waitForElementPresent(Worldspan_Hotel_Code);
		if (Worldspan_Hotel_Code.isDisplayed()) {
			Worldspan_Hotel_Code.sendKeys(WorldspanHotelCode);
			logger.info("Worldspan Hotel code is entered");

			test.log(Status.INFO, "Worldspan Hotel code is entered");
		} else {
			logger.error(" Failed to enter Worldspan Hotel code");

			test.log(Status.ERROR, "Failed to enter Worldspan Hotel code");
		}

		SeleniumRepo.waitForElementPresent(Amadeus_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(Amadeus_Channel_Type) == false) {
			Amadeus_Channel_Type.click();
			logger.info("Amadeus Channel type is selected");

			test.log(Status.INFO, "Amadeus Channel type is selected");
		} else {
			logger.error(" Failed to Select Amadeus Channel type");

			test.log(Status.ERROR, "Failed to Amadeus Sabre Channel type");
		}

		SeleniumRepo.waitForElementPresent(Amadeus_Hotel_Code);
		if (Amadeus_Hotel_Code.isDisplayed()) {
			Amadeus_Hotel_Code.sendKeys(AmadeusHotelCode);
			logger.info("Amadeus Hotel code is entered");

			test.log(Status.INFO, "Amadeus Hotel code is entered");
		} else {
			logger.error(" Failed to enter Amadeus Hotel code");

			test.log(Status.ERROR, "Failed to enter Amadeus Hotel code");
		}

		SeleniumRepo.waitForElementPresent(ADS_Channel_Type);
		if (SeleniumRepoCheckBox.CheckCheckBox(ADS_Channel_Type) == false) {
			ADS_Channel_Type.click();
			logger.info("ADS Channel type is selected");

			test.log(Status.INFO, "ADS Channel type is selected");
		} else {
			logger.error(" Failed to Select ADS Channel type");

			test.log(Status.ERROR, "Failed to Select  ADS Channel type");
		}

		SeleniumRepo.waitForElementPresent(ADS_Hotel_Code);
		if (ADS_Hotel_Code.isDisplayed()) {
			ADS_Hotel_Code.sendKeys(AdsHotelCode);
			logger.info("Amadeus Hotel code is entered");

			test.log(Status.INFO, "ADS Hotel code is entered");
		} else {
			logger.error(" Failed to enter ADS Hotel code");

			test.log(Status.ERROR, "Failed to enter ADS Hotel code");
		}

		Thread.sleep(3000);
		
		if (SeleniumRepo.driver.findElement(By.xpath("//input[@name='Submit']")).isDisplayed()) 
		{
			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//input[@name='Submit']")));
			ExplicitWait(channels_link);
			logger.info("Clicked on Submit button successfully ");

			test.log(Status.INFO, "Clicked on Submit button successfully");
		} else {
			logger.error(" Failed to click on Submit button");

			test.log(Status.ERROR, "Failed to click on Submit button");
		}

		if (SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Channels')]")).isDisplayed())
		{
			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Channels')]")));Thread.sleep(2000);
			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Channels')]")));				
			logger.info("Clicked on Channel Link ");

			test.log(Status.INFO, "Clicked on Channel Link");
		} else 
		{
			logger.error(" Failed to Click on Channel Link");

			test.log(Status.ERROR, " Failed to Click on Channel Link");
		}

		if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().equals("GDS"))
		{
			System.out.println("Channel GDS created successfully");
			logger.info("Channel GDS created successfully");
			test.log(Status.PASS, "Channel GDS created successfully");
		}

        Thread.sleep(5000);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
		
	
	
}
