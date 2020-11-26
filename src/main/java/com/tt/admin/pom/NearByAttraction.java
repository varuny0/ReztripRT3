package com.tt.admin.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class NearByAttraction extends BaseTest{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	 String result=this.getClass().getSimpleName();
	 
	 
	  
	 @FindAll({ @FindBy(xpath = "//a[contains(text(), 'Nearby Attractions')]"),

		})
		private WebElement Click_NearByAttractionLink;
	 
	 @FindAll({ @FindBy(xpath = "//input[@value='Add New']"),

		})
		private WebElement Click_NearBy_AddNew;

	 @FindAll({ @FindBy(xpath = "//input[@name='name' and @size='40']"),

		})
		private WebElement Enter_NearBy_EnterName;
	 
	 @FindAll({ @FindBy(xpath = "//input[@name='category']"),

		})
		private WebElement Enter_NearBy_Category;

	 @FindAll({ @FindBy(xpath = "//textarea[@name='description']"),

		})
		private WebElement Enter_NearBy_Description	;


	 @FindAll({ @FindBy(xpath = "//input[@name= 'tt_img_loader_file_0' and@type = 'file']"),

		})
		private WebElement Upload_NearBy_Image	;


	 @FindAll({ @FindBy(xpath = "//select[@name='selectedCountry']"),

		})
		private WebElement Select_NearBy_Country	;

	 @FindAll({ @FindBy(xpath = "//*[@id='abc']/tbody/tr[8]/td[2]/textarea[@name='address1']"),

		})
		private WebElement Enter_NearBy_Address;


	 @FindAll({ @FindBy(xpath = "//input[@name= 'city']"),

		})
		private WebElement Enter_NearBy_City;
	 
	 @FindAll({ @FindBy(xpath = "//input[@name='zipCode']"),

		})
		private WebElement Enter_NearBy_ZipCode;


	 @FindAll({ @FindBy(xpath = "//a[contains(text(),'Find Lat/Long')]"),

		})
		private WebElement Click_NearBy_LatLong;


	 @FindAll({ @FindBy(xpath = "//input[@value='Save']"),

		})
		private WebElement Click_NearBy_Save;
	 
	


            public void createNearByAttraction
            (String EnterName,String NearBy_Category,
            		String NearBy_Description,String roomImagePath,String Country,
            		String NearBy_Address,String NearBy_City,String NearBy_ZipCode)
            {

	 try {
			SeleniumRepo.waitForElementPresent(Click_NearByAttractionLink);
			if(SeleniumRepo.isElementPresent(Click_NearByAttractionLink)) {
				Click_NearByAttractionLink.click();
				test.log(Status.PASS, "Clcik on NearByAttraction Link");
				logger.info("Clcik on NearByAttraction Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearByAttraction Link");
				logger.error("Failed to Clcik on NearByAttraction Link");
			}
			


			SeleniumRepo.waitForElementPresent(Click_NearBy_AddNew);
			if(SeleniumRepo.isElementPresent(Click_NearBy_AddNew)) {
				Click_NearBy_AddNew.click();
				test.log(Status.INFO, "Clcik on NearBy_AddNew Link");
				logger.info("Clcik on NearBy_AddNew Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearBy_AddNew Link");
				logger.error("Failed to Clcik on NearBy_AddNew Link");
			}


			SeleniumRepo.waitForElementPresent(Enter_NearBy_EnterName);
			if(Enter_NearBy_EnterName.isDisplayed()) {
				Enter_NearBy_EnterName.click();
				Enter_NearBy_EnterName.clear();
				Enter_NearBy_EnterName.sendKeys(EnterName);
				test.log(Status.INFO, "Enter_NearBy_Name");
				logger.info("Enter_NearBy_Name successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Name");
				logger.error("Failed to Enter_NearBy_Name");}


			SeleniumRepo.waitForElementPresent(Enter_NearBy_Category);
			if(Enter_NearBy_Category.isDisplayed()) {
				Enter_NearBy_Category.click();
				Enter_NearBy_Category.clear();
				Enter_NearBy_Category.sendKeys(NearBy_Category);
				test.log(Status.INFO, "Enter_NearBy_Category)");
				logger.info("Enter_NearBy_Category) successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Category)");
				logger.error("Failed to Enter_NearBy_Category)");}



			SeleniumRepo.waitForElementPresent(Enter_NearBy_Description);
			if(Enter_NearBy_Description.isDisplayed()) {
				Enter_NearBy_Description.click();
				Enter_NearBy_Description.clear();
				Enter_NearBy_Description.sendKeys(NearBy_Description);
				test.log(Status.INFO, "Enter_NearBy_Description)");
				logger.info("Enter_NearBy_Description successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Description)");
				logger.error("Failed to Enter_NearBy_Description)");}

			SeleniumRepo.waitForElementPresent(Upload_NearBy_Image);
			if (SeleniumRepo.isElementPresent(Upload_NearBy_Image)) {
				Upload_NearBy_Image.sendKeys(System.getProperty("user.dir") + roomImagePath);
				test.log(Status.INFO, "Room Image Path is entered successfully");
				logger.info("Room Image Path is entered successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter Room Image Path");
				logger.error("Failed to Enter Room Image Path");
			}

			SeleniumRepo.waitForElementPresent(Select_NearBy_Country);
			if(Select_NearBy_Country.isDisplayed())
			{
				SeleniumRepoDropdown.selectDropDownText(Select_NearBy_Country, Country);
				test.log(Status.INFO, "Select Country");
				logger.info("Country is Select successfully");
			} else {
				test.log(Status.FAIL, "Failed to Select Country");
				logger.error("Failed to  Select Country");
				}
			

			SeleniumRepo.waitForElementPresent(Enter_NearBy_Address);
			if(Enter_NearBy_Address.isDisplayed())
			{
				Enter_NearBy_Address.click();
				Enter_NearBy_Address.clear();
				Enter_NearBy_Address.sendKeys(NearBy_Address);
				test.log(Status.INFO, "Enter_NearBy_Address)");
				logger.info("Enter_NearBy_Address successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_Address)");
				logger.error("Failed to Enter_NearBy_Address)");
				}

			SeleniumRepo.waitForElementPresent(Enter_NearBy_City);
			if(Enter_NearBy_City.isDisplayed()) 
			{
				Enter_NearBy_City.click();
				Enter_NearBy_City.clear();
				Enter_NearBy_City.sendKeys(NearBy_City);
				test.log(Status.INFO, "Enter_NearBy_City)");
				logger.info("Enter_NearBy_City successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_City)");
				logger.error("Failed to Enter_NearBy_City)");
				}



			SeleniumRepo.waitForElementPresent(Enter_NearBy_ZipCode);
			if(Enter_NearBy_ZipCode.isDisplayed()) 
			{
				Enter_NearBy_ZipCode.click();
				Enter_NearBy_ZipCode.clear();
				Enter_NearBy_ZipCode.sendKeys(NearBy_ZipCode);
				test.log(Status.INFO, "Enter_NearBy_ZipCode)");
				logger.info("Enter_NearBy_ZipCode successfully");
			} else {
				test.log(Status.FAIL, "Failed to Enter_NearBy_ZipCode)");
				logger.error("Failed to Enter_NearBy_ZipCode)");
				}


			//SeleniumRepo.waitForElementPresent(Click_NearBy_LatLong);
			if(Click_NearBy_LatLong.isEnabled())
			{
				Click_NearBy_LatLong.click();
				SeleniumRepo.waitForPageLoaded();
				test.log(Status.INFO, "Clcik on NearBy_LatLong Link");
				logger.info("Clcik on NearBy_LatLong Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearBy_LatLong Link");
				logger.error("Failed to Clcik on NearBy_LatLong Link");
			}


			SeleniumRepo.waitForElementPresent(Click_NearBy_Save);
			if(SeleniumRepo.isElementPresent(Click_NearBy_Save)) 
			{
				Click_NearBy_Save.click();
				test.log(Status.INFO, "Clcik on NearBy_Save Link");
				logger.info("Clcik on NearBy_Save Link successfully");
			} else {
				test.log(Status.FAIL, "Failed to Clcik on NearBy_Save Link");
				logger.error("Failed to Clcik on NearBy_LatLong Link");
			}


			
		} catch (Exception e) 
	 {
			logger.error("Unable to create NearBy Attraction for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create NearBy Attraction  for selected property because of this execption" + e);
			e.printStackTrace();
		}




}
}