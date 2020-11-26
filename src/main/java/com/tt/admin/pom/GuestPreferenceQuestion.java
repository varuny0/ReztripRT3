package com.tt.admin.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;


public class GuestPreferenceQuestion extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//*[contains(text(), 'Guest Preference Questions')]"),
	})

	public WebElement Click_GuestPQ;

	@FindAll({ @FindBy(xpath = "//div[contains(., 'Rooms')]"),})
	public WebElement Click_Room_link;

	@FindAll({ @FindBy(xpath = "//li//a[contains(@href,'addEditGuestPreferences.do?')]") 
	})

	public WebElement Click_AddNewGuestPQ;

	@FindAll({ @FindBy(xpath = "//input[@value='Save']"), 
	})

	public WebElement Click_SaveGuestPQ;

	@FindAll({ @FindBy(xpath = "//*[text()='Guest Preference Questions']/following-sibling::ul/li[1]/a"), 
	})

	public WebElement List_All;

	@FindAll({ @FindBy(xpath = "//font[@color='red' and ./li[contains(.,'Required field Question.')]]"), 
	})

	public WebElement Check_ErrorReqGuestPQ;

	@FindAll({ @FindBy(xpath = "//font[@color='red' and ./li[contains(.,'Required field Question Label.')]]"), 
	})

	public WebElement Check_ErrorReqGuestPQLabel;

	@FindAll({ @FindBy(xpath = "//font[@color='red' and ./li[contains(.,'Options Label can not be blank.')]]"),
	})

	public WebElement Check_ErrorOptionsGuestPQLabel;

	@FindAll({ @FindBy(xpath = "//select[@id='selectionType']"), 
	})

	public WebElement Select_GuestPType;

	@FindAll({ @FindBy(xpath = "//input[@id='maxOptionsAllowed']"), 
	})

	public WebElement Select_MaxOptionsAllowed;

	@FindAll({ @FindBy(xpath = "//input[@id='questionText']"),
	})


	public WebElement Enter_FieldQuestion;

	@FindAll({ @FindBy(xpath = "//input[@id='questionLabel']"),
	})

	public WebElement Enter_FieldQuestionLabel;

	@FindAll({ @FindBy(xpath = "//input[@id='optionLabel']"),
	})

	public WebElement Enter_FieldQuestion_1_Label;

	@FindAll({ @FindBy(xpath = "//input[@id='optionTextIndex_1']"),
	})

	public WebElement Enter_FieldQuestion_1_Guest_Options;

	@FindAll({ @FindBy(xpath = "//a[contains(@href,'manageGuestPreferences.do?')]"), 
	})

	public WebElement Click_ListAll;

	@FindAll({ @FindBy(xpath = "//*[@id='update']"), 
	})

	public WebElement Update;

	@FindAll({ @FindBy(xpath = "//*[text()='Delete']") })

	public List<WebElement> Delete;

	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Guest Preference Questions')]"), 
	})

	public WebElement GPQ_Title;

	@FindAll({ @FindBy(xpath = "//*[text()='OK']"),

	})
	public WebElement Delete_OK;



	public void delete() throws InterruptedException 
	{
		if (List_All.isDisplayed()) 
		{
			Javascriptexecutor(List_All);
			ExplicitWait(GPQ_Title);
			System.out.println("Guest Preference Questions element Expanded and List All element  found");
			test.log(Status.INFO, "Guest Preference Questions element Expanded and List All element  found");
			Assert.assertTrue(true, "Guest Preference Questions element Expanded and List All element  found");
		} 
		else 
		{
			System.out.println("Guest Preference Questions Menu is not expanded");
			Javascriptexecutor(Click_GuestPQ);
			System.out.println("Clicked on Guest Preference Questions Link");
			test.log(Status.INFO, "Clicked on Guest Preference Questions Link");

			ExplicitWait(List_All);

			if(List_All.isDisplayed())
			{
				Javascriptexecutor(List_All);
				System.out.println("Clicked on List all");
				ExplicitWait(GPQ_Title);
				Thread.sleep(2000);
				System.out.println("List All element found");
				test.log(Status.INFO, "List All  element found");
				Assert.assertTrue(true, "List All element found");
			}
			else
			{
				logger.info("List All element not  found");
				test.log(Status.FAIL, "List All element not  found");
			}
		}


		if(SeleniumRepo.driver.findElement(By.tagName("BODY")).getText().contains("There are no guest preference questions to display."))
		{
			test.log(Status.INFO, " There are no guest preference questions");
			System.out.println( "There are no guest preference questions");
		}
		else
		{

			List<WebElement> lst=SeleniumRepo.driver.findElements(By.xpath("//*[text()='Delete']"));
			int size=	lst.size();
			System.out.println("There are "+lst.size()+" guest preference questions");
			System.out.println("need to delete the questions");


			for(int i=0;i<=lst.size()-1;i++)		
			{
				System.out.println("enter into for loop");
				ExplicitWait(lst.get(i));
				System.out.println("element found");
				Thread.sleep(1000);
				Javascriptexecutor(lst.get(i));
				System.out.println("after clik");
				Thread.sleep(2000);
				Javascriptexecutor(Delete_OK);
				System.out.println("deleted");

				ExplicitWait(GPQ_Title);
			}
		}
	}




	public void creatGuestPQ
	(String GuestPType, String MaxOptions, String FieldQuestion,
			String FieldQuestionLabel,
			String FieldQuestion_1_Label, String FieldQuestion_1_Guest_Options) throws InterruptedException
	{

		Thread.sleep(4000);


		try
	{

	List<WebElement> delete=SeleniumRepo.driver.findElements(By.xpath("//*[contains(text(),'"+FieldQuestion+"')]/following-sibling::td[4]/a"));
	for(WebElement del:delete)
	{
		System.out.println(FieldQuestion+" questions are "+delete.size());
		Javascriptexecutor(del);

		System.out.println("Clicked on Delete successfully");

		Javascriptexecutor(Delete_OK);

		System.out.println("Clicked on Ok Delete successfully");

		ExplicitWait(GPQ_Title);
	}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		System.out.println("There are no guest preference questions to display.");
	}

		if (Click_AddNewGuestPQ.isDisplayed()) 
		{
			Javascriptexecutor(Click_AddNewGuestPQ);
			SeleniumRepo.waitForPageLoaded();
			ExplicitWait(Click_SaveGuestPQ);
			System.out.println("Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			test.log(Status.INFO, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
			Assert.assertTrue(true, "Guest Preference Questions element Expanded and AddNewGuestPQ element  found");
		} 
		else 
		{
			System.out.println("Guest Preference Questions Menu is not expanded");
			Javascriptexecutor(Click_GuestPQ);
			System.out.println("Clicked on Guest Preference Questions Link");
			test.log(Status.INFO, "Clicked on Guest Preference Questions Link");

			ExplicitWait(Click_AddNewGuestPQ);
			if(Click_AddNewGuestPQ.isDisplayed())
			{
				Javascriptexecutor(Click_AddNewGuestPQ);

				ExplicitWait(Click_SaveGuestPQ);
				System.out.println("AddNew element found");
				test.log(Status.INFO, "AddNew element found");
				Assert.assertTrue(true, "AddNewelement found");
			}
			else
			{
				logger.info("AddNew element not  found");
				test.log(Status.FAIL, "AddNew element not  found");
			}
		}

		if (Click_SaveGuestPQ.isDisplayed()) 
		{
			Click_SaveGuestPQ.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("SaveGuestPQ Button  found");
			ExplicitWait(Check_ErrorReqGuestPQ);

			test.log(Status.PASS, 
					"Clicked on SaveGuestPQ Button ");
			Assert.assertTrue(true, "Clicked on SaveGuestPQ Button ");
		} else {
			System.out.println("SaveGuestPQ Button  not found");
			test.log(Status.FAIL,
					" SaveGuestPQ Button  not found");
			Assert.assertFalse(false, "SaveGuestPQ Button  not found");
		}

		if (Check_ErrorReqGuestPQ.isDisplayed())
		{
			System.out.println("ErrorReqGuestPQ is Displayed");
			test.log(Status.PASS, 
					"ErrorReqGuestPQ is Displayed ");
			Assert.assertTrue(true, "ErrorReqGuestPQ is Displayed ");
		} else {
			System.out.println("ErrorReqGuestPQ is Not Displayed");
			test.log(Status.FAIL, 
					" ErrorReqGuestPQ is Not Displayed");
			Assert.assertFalse(false, "ErrorReqGuestPQ is Not Displayed");
		}

		if (Check_ErrorReqGuestPQLabel.isDisplayed()) 
		{
			System.out.println("ErrorReqGuestPQLabel is Displayed");
			test.log(Status.PASS,
					"ErrorReqGuestPQLabel is Displayed ");
			Assert.assertTrue(true, "ErrorReqGuestPQLabel is Displayed ");
		} else {
			System.out.println("ErrorReqGuestPQLabel is Not Displayed");
			test.log(Status.FAIL, 
					" ErrorReqGuestPQLabel is Not Displayed");
			Assert.assertFalse(false, "ErrorReqGuestPQLabel is Not Displayed");
		}

		if (Check_ErrorOptionsGuestPQLabel.isDisplayed()) 
		{
			System.out.println("ErrorOptionsGuestPQLabel is Displayed");
			test.log(Status.PASS,
					"ErrorOptionsGuestPQLabel is Displayed ");
			Assert.assertTrue(true, "ErrorOptionsGuestPQLabel is Displayed ");
		} else {
			System.out.println("ErrorOptionsGuestPQLabel is Not Displayed");
			test.log(Status.FAIL,
					" ErrorOptionsGuestPQLabel is Not Displayed");
			Assert.assertFalse(false, "ErrorOptionsGuestPQLabel is Not Displayed");
		}
		ExplicitWait(Select_GuestPType);

		if (Select_GuestPType.isEnabled()) 
		{
			
			Thread.sleep(2000);
			SeleniumRepoDropdown.selectDropDownValue(Select_GuestPType, GuestPType);
			System.out.println("ErrorOptionsGuestPQLabel is Selected");
			test.log(Status.PASS, "ErrorOptionsGuestPQLabel is Selected ");
			Assert.assertTrue(true, "ErrorOptionsGuestPQLabel is Selected ");
		} else {
			System.out.println("ErrorOptionsGuestPQLabel is Not Selected");
			test.log(Status.FAIL,
					" ErrorOptionsGuestPQLabel is Not Selected");
			Assert.assertFalse(false, "ErrorOptionsGuestPQLabel is Not Selected");
		}

		if (Select_MaxOptionsAllowed.isEnabled()) 
		{
			Select_MaxOptionsAllowed.click();
			Select_MaxOptionsAllowed.clear();
			Select_MaxOptionsAllowed.sendKeys(MaxOptions);
			System.out.println("MaxOptions is Entered");
			test.log(Status.PASS,
					"MaxOptions is Entered ");
			Assert.assertTrue(true, "MaxOptions is Entered ");
		} else {
			System.out.println("MaxOptions is Not Entered");
			//test.log(Status.FAIL,s" MaxOptions is Not Entered");
			Assert.assertFalse(false, "MaxOptions is Not Entered");
		}

		if (Enter_FieldQuestion.isDisplayed())
		{
			Enter_FieldQuestion.click();
			Enter_FieldQuestion.clear();
			Enter_FieldQuestion.sendKeys(FieldQuestion);
			System.out.println("FieldQuestion is Entered");
			test.log(Status.PASS, "FieldQuestion is Entered ");
			Assert.assertTrue(true, "FieldQuestion is Entered ");
		} else {
			System.out.println("FieldQuestion is Not Entered");
			test.log(Status.FAIL,
					" FieldQuestion is Not Entered");
			Assert.assertFalse(false, "FieldQuestion is Not Entered");
		}

		if (Enter_FieldQuestion.isDisplayed())
		{
			Enter_FieldQuestion.click();
			Enter_FieldQuestion.clear();
			Enter_FieldQuestion.sendKeys(FieldQuestion);
			System.out.println("FieldQuestion is Entered");
			test.log(Status.PASS,
					"FieldQuestion is Entered ");
			Assert.assertTrue(true, "FieldQuestion is Entered ");
		} else {
			System.out.println("FieldQuestion is Not Entered");
			test.log(Status.FAIL,
					" FieldQuestion is Not Entered");
			Assert.assertFalse(false, "FieldQuestion is Not Entered");
		}

		if (Enter_FieldQuestionLabel.isDisplayed())
		{
			Enter_FieldQuestionLabel.click();
			Enter_FieldQuestionLabel.clear();
			Enter_FieldQuestionLabel.sendKeys(FieldQuestionLabel);
			System.out.println("FieldQuestionLabel is Entered");
			test.log(Status.PASS,
					"FieldQuestionLabel is Entered ");
			Assert.assertTrue(true, "FieldQuestionLabel is Entered ");
		} else {
			System.out.println("FieldQuestionLabel is Not Entered");
			test.log(Status.FAIL,
					" FieldQuestionLabel is Not Entered");
			Assert.assertFalse(false, "FieldQuestionLabel is Not Entered");
		}

		if (Enter_FieldQuestion_1_Label.isDisplayed()) 
		{
			Enter_FieldQuestion_1_Label.click();
			Enter_FieldQuestion_1_Label.clear();
			Enter_FieldQuestion_1_Label.sendKeys(FieldQuestion_1_Label);
			System.out.println("FieldQuestion_1_Label is Entered");
			test.log(Status.PASS,
					"FieldQuestion_1_Label is Entered ");
			Assert.assertTrue(true, "FieldQuestion_1_Label is Entered ");
		} else {
			System.out.println("FieldQuestion_1_Label is Not Entered");
			test.log(Status.FAIL,
					" FieldQuestion_1_Label is Not Entered");
			Assert.assertFalse(false, "FieldQuestion_1_Label is Not Entered");
		}

		if (Enter_FieldQuestion_1_Guest_Options.isDisplayed())
		{
			Enter_FieldQuestion_1_Guest_Options.click();
			Enter_FieldQuestion_1_Guest_Options.clear();
			Enter_FieldQuestion_1_Guest_Options.sendKeys(FieldQuestion_1_Guest_Options);
			System.out.println("FieldQuestion_1_Guest_Options is Entered");
			test.log(Status.PASS, 
					"FieldQuestion_1_Guest_Options is Entered ");
			Assert.assertTrue(true, "FieldQuestion_1_Guest_Options is Entered ");
		} else {
			System.out.println("FieldQuestion_1_Guest_Options is Not Entered");
			test.log(Status.FAIL,
					" FieldQuestion_1_Guest_Options is Not Entered");
			Assert.assertFalse(false, "FieldQuestion_1_Guest_Options is Not Entered");
		}

		SeleniumRepo.waitForElementPresent(Click_SaveGuestPQ);
		if (Click_SaveGuestPQ.isDisplayed()) 
		{
			Click_SaveGuestPQ.click();
			ExplicitWait(Update);
			System.out.println("SaveGuestPQ Button  found");
			test.log(Status.PASS, 
					"Clicked on SaveGuestPQ Button ");
			Assert.assertTrue(true, "Clicked on SaveGuestPQ Button ");
		} else {
			System.out.println("SaveGuestPQ Button  not found");
			test.log(Status.FAIL, 
					" SaveGuestPQ Button  not found");
			Assert.assertFalse(false, "SaveGuestPQ Button  not found");
		}

		if (Update.isDisplayed()) 
		{
			System.out.println("Guest preference questions are created successfully");
			test.log(Status.PASS,
					"Guest preference questions are created successfully");
			Assert.assertTrue(true, "Guest preference questions are created successfully");
		} else {
			System.out.println("Failed to create Guest preference questions");
			test.log(Status.FAIL,
					"Failed to create Guest preference questions");
			Assert.assertFalse(false, "Failed to create Guest preference questions");
		}

	}

}
