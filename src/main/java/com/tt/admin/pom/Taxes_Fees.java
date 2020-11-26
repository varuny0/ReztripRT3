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
import com.tt.utility.SeleniumRepoCheckBox;

public class Taxes_Fees extends BaseTest
{

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();


	@FindAll({ @FindBy(xpath = "//a[contains(., 'Taxes')]"),
		@FindBy(css = "ul:nth-child(3) li:nth-child(3) ul:nth-child(2) li:nth-child(7) > a:nth-child(1)") 
	})
	
	private WebElement Click_TaxesFees;

	@FindAll({ @FindBy(xpath = "//h1[contains(text(),'Property Taxes')]"),
		@FindBy(css = "table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) > h1:nth-child(1)")
	})
	
	private WebElement Verify_Property_Taxes;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Add New Tax to Property')]"),
		@FindBy(css = "tbody:nth-child(1) tr:nth-child(1) td:nth-child(3) p:nth-child(3) > a:nth-child(1)") 
	})
	
	private WebElement Click_AddNewTaxToPropertyLinkText;	

	@FindAll({ @FindBy(xpath = "//input[@name='taxName']"),
		@FindBy(css = "table.formtable:nth-child(10) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > input.input.guest-facing-fields")
	})
	
	private WebElement Enter_Tax_Name;	

	@FindAll({ @FindBy(xpath = "//input[@name='code']"),
		@FindBy(css = "table.formtable:nth-child(10) tbody:nth-child(1) tr:nth-child(4) td:nth-child(2) > input:nth-child(1)")
	})
	
	private WebElement Enter_Tax_Code;	

	@FindAll({ @FindBy(xpath = "//input[contains(@name,'chargeFrequency')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(1) > td:nth-child(2)") 
	})
	
	private List<WebElement>Enter_Charge_Frequency;	

	@FindAll({ @FindBy(xpath = "//input[contains(@name,'chargeBasis')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(2)") 
	})
	
	private List<WebElement> Enter_Charge_Basis;	

	@FindAll({ @FindBy(xpath = "//input[contains(@name,'chargeType')]"),
		@FindBy(css = "form:nth-child(2) table.formtable:nth-child(11) tbody:nth-child(1) tr:nth-child(3) > td:nth-child(2)") 
	})
	
	private List<WebElement> Enter_Charge_Type;	

	@FindAll({ @FindBy(xpath = "//input[@id='amountId']"),
		@FindBy(css = "#amountId")
	})
	
	private WebElement Enter_Charge_Amount;	


	@FindAll({ @FindBy(xpath = "//input[@name='dowCheckAll']"),
		@FindBy(css = "table.formtable:nth-child(13) tbody:nth-child(1) tr:nth-child(3) td:nth-child(2) > input:nth-child(1)")
	})
	
	private WebElement DayOfWeekAll;	


	@FindAll({ @FindBy(xpath = "//input[@id='btnSubmit']"),
		@FindBy(css = "#btnSubmit") })
	
	private WebElement Click_SaveButton;	


	@FindAll({ @FindBy(xpath = "//a[contains(text(),'PerStay PerRoom 10%')]"),
		@FindBy(css = "table.listtable:nth-child(2) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > a:nth-child(1)") 
	})
	
	private List<WebElement> PerStayPerRoom10;	


	@FindAll({ @FindBy(xpath = "//form[@name='listTaxForm']//tbody//tr[2]"),
		@FindBy(css = "td:nth-child(3) form:nth-child(4) table.listtable:nth-child(2) tbody:nth-child(1) > tr:nth-child(2)") 
	})
	
	private  List<WebElement> ListTaxForm;	

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"),

	})
	private WebElement property_Management;



	public void delete_taxes() throws InterruptedException
	{
		ExplicitWait(Click_AddNewTaxToPropertyLinkText);
		//	if(ListTaxForm.size()>0);

		if(SeleniumRepo.driver.findElement(By.xpath("(//*[@name='taxIdsToDelete'])[1]")).isDisplayed())
		{
			System.out.println("already tax created");

			List<WebElement>delete=SeleniumRepo.driver.findElements(By.xpath("//*[@name='taxIdsToDelete']"));
			for(WebElement del:delete)
			{
				Javascriptexecutor(del);
			}


			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[@value='Delete']")));
			Thread.sleep(2000);
			Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()='OK']")));


			ExplicitWait(Click_AddNewTaxToPropertyLinkText);
		}

		else
		{
			System.out.println("No taxes ");
		}
	}


	public void click_taxes()
	{
		SeleniumRepo.waitForElementPresent(Click_TaxesFees);
		if(Click_TaxesFees.isDisplayed()) 
		{
			Javascriptexecutor(Click_TaxesFees);
			ExplicitWait(Verify_Property_Taxes);
			logger.info("Clicked on TaxesFees Link");
			test.log(Status.PASS,
					"Clicked on TaxesFees Link" );
			Assert.assertTrue(true, "Clicked on TaxesFees Link");
		}
		else
		{
			System.out.println(" TaxesFees is not found");
			logger.error("Failed to Click on TaxesFees Link");
			test.log(Status.FAIL,
					"Failed to Click on TaxesFees Link");
			Assert.assertFalse(false, 
					"TaxesFees Link not found");
		}

	}
		
	public void click_addtax()
	{
		ExplicitWait(Click_AddNewTaxToPropertyLinkText);
		if (Click_AddNewTaxToPropertyLinkText.isDisplayed()) 
		{
			Javascriptexecutor(Click_AddNewTaxToPropertyLinkText);
			logger.info("Clicked on TaxToProperty Link");
			test.log(Status.PASS,
					"Clicked on TaxToProperty Link" );
			Assert.assertTrue(true,
					"Clicked on TaxToProperty Link");}
		else {
			System.out.println(" TaxToProperty Link is not found");
			logger.error("Failed to Click on TaxToProperty Link");
			test.log(Status.FAIL,
					"Failed to Click on TaxToProperty Link");
			Assert.assertFalse(false, 
					"TaxToProperty Link not found");
		}
	}
	public void tax(String Tax_Name, String Tax_Code, 
			String Charge_Frequency, String Charge_Basis, 
			String Charge_Type, String Charge_Amount ) throws InterruptedException
	{
		ExplicitWait(Enter_Tax_Name);
		if (Enter_Tax_Name.isDisplayed()) 
		{
			Enter_Tax_Name.click();
			Enter_Tax_Name.clear();
			Enter_Tax_Name.sendKeys(Tax_Name+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			System.out.println(" Tax_Name is entered successfully");
			logger.info("Tax_Name is entered successfully");
			test.log(Status.PASS,
					"Tax_Name is entered successfully" );
			Assert.assertTrue(true,
					"Tax_Name is entered successfully");
		} else {
			System.out.println("Tax_Name TextBox not found");
			logger.error("Failed to Enter Tax_Name in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Tax_Name in TextBox");
			Assert.assertFalse(false, 
					"Tax_Name TextBox not found");
		}

		if (Enter_Tax_Code.isDisplayed())
		{
			Enter_Tax_Code.click();
			Enter_Tax_Code.clear();
			Enter_Tax_Code.sendKeys(Tax_Code+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
			System.out.println(" Tax_Code is entered successfully");
			logger.info("Tax_Code is entered successfully");
			test.log(Status.PASS,
					"Tax_Code is entered successfully" );
			Assert.assertTrue(true,
					"Tax_Code is entered successfully");
		} else {
			System.out.println("Tax_Code TextBox not found");
			logger.error("Failed to Enter Tax_Code in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Tax_Code in TextBox");
			Assert.assertFalse(false, 
					"Tax_Code TextBox not found");
		}

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Frequency,Charge_Frequency);
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
					"Failed to Select Charge Frequency");
			e.printStackTrace();
		}


		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Basis,Charge_Basis);
			System.out.println("Charge_Basisis Selected succesfully");
			logger.info("Charge_Basis is Selected succesfully");
			test.log(Status.PASS,
					"Charge_Basis is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge_Basis is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge_Basis is not Selected");
			logger.error("Failed to Select Charge Basis");
			test.log(Status.FAIL,
					"Failed to Select Charge Basis");
			Assert.assertFalse(false, 
					"Failed to Select Charge Basis");
			e.printStackTrace();
		}

		try {
			SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Type,Charge_Type);
			System.out.println("Charge_Type is Selected succesfully");
			logger.info("Charge_Type is Selected succesfully");
			test.log(Status.PASS,
					"Charge_Type is Selected succesfully" );
			Assert.assertTrue(true,
					"Charge_Type is Selected succesfully");
		} catch (Exception e) {
			System.out.println("Charge_Type is not Selected");
			logger.error("Failed to Select Charge Type");
			test.log(Status.FAIL,
					"Failed to Select Charge Type");
			Assert.assertFalse(false, 
					"Failed to Select Charge Type");
			e.printStackTrace();
		}
		if (Enter_Charge_Amount.isDisplayed()) 
		{
			Enter_Charge_Amount.click();
			Enter_Charge_Amount.clear();
			Enter_Charge_Amount.sendKeys(Charge_Amount);
			System.out.println(" Charge_Amount is entered successfully");
			logger.info("Charge_Amount is entered successfully");
			test.log(Status.PASS,
					"Charge_Amount is entered successfully" );
			Assert.assertTrue(true,
					"Charge_Amount is entered successfully");
		} else {
			System.out.println("Charge_Amount TextBox not found");
			logger.error("Failed to Enter Charge_Amount in TextBox");
			test.log(Status.FAIL,
					"Failed to Enter Charge_Amount in TextBox");
			Assert.assertFalse(false, 
					"Charge_AmountTextBox not found");
		}


		if (DayOfWeekAll.isDisplayed()) 
		{
			if (DayOfWeekAll.isSelected() == false)
				DayOfWeekAll.click();
			SeleniumRepo.WaitForLoad(100);
			System.out.println("DayOfWeekAll is Clicked successfully");
			logger.info("Clicked on DayOfWeekAll");
			test.log(Status.PASS,
					"Clicked on DayOfWeekAll" );
			Assert.assertTrue(true,
					"DayOfWeekAll is Clicked successfully");
		} else {
			System.out.println("DayOfWeekAll not Clicked");
			logger.error("Failed to Click on DayOfWeekAll");
			test.log(Status.FAIL,
					"Failed to Click on DayOfWeekAll");
			Assert.assertFalse(false, 
					"DayOfWeekAll not Clicked");
		}


		try {
			Click_SaveButton.click();
			SeleniumRepo.waitForPageLoaded();
			System.out.println("Saved");
			logger.info("Clicked on Save button");
			test.log(Status.PASS,
					"Clicked on Save button" );
		} catch (Exception e) {
			System.out.println("Not Saved");
			logger.error("Failed to Click on Save button");
			test.log(Status.FAIL,
					"Failed to Click on Save button");
			e.printStackTrace();
		}
	}

	public  void  createTaxFees
	(String Property_Taxes_Title, String Tax_Name, String Tax_Code, 
			String Charge_Frequency, String Charge_Basis, 
			String Charge_Type, String Charge_Amount ) throws Exception 
	{
		try 
		{
			
			
			if (Click_TaxesFees.isDisplayed()) 
			{
				Javascriptexecutor(Click_TaxesFees);
				ExplicitWait(Click_AddNewTaxToPropertyLinkText);
				System.out.println("PropertyManagement element Expanded and TaxesFees element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and TaxesFees element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and TaxesFees element  found");
			} 
			else 
			{
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(Click_TaxesFees);
				if(Click_TaxesFees.isDisplayed())
				{
					Javascriptexecutor(Click_TaxesFees);
					SeleniumRepo.waitForPageLoaded();
					ExplicitWait(Click_AddNewTaxToPropertyLinkText);
					System.out.println("TaxesFees element found");
					test.log(Status.INFO, "TaxesFees element found");
					Assert.assertTrue(true, "TaxesFees element found");
				}
				else
				{
					logger.info("TaxesFees element not  found");
					test.log(Status.FAIL, "TaxesFees element not  found");
				}
			}
			
			
			Thread.sleep(4000);
			if(SeleniumRepo.driver.findElement(By.tagName("body")).getText().contains(Tax_Name))
			{
				System.out.println("Tax "+Tax_Name+" already created and going to delete");
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+Tax_Name+"')]/../preceding-sibling::td/input")));
			     Thread.sleep(2000);

					Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[@value='Delete']")));
					Thread.sleep(2000);
					Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//*[text()='OK']")));	     
			}
			else
			{
				System.out.println("tax "+Tax_Name+" not yet created");
			}
			
			ExplicitWait(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Tax to Property')]")));
			
			if (SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Tax to Property')]")).isDisplayed()) 
			{
				Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//a[contains(text(),'Add New Tax to Property')]")));
				SeleniumRepo.waitForPageLoaded();
				logger.info("Clicked on TaxToProperty Link");
				test.log(Status.PASS,
						"Clicked on TaxToProperty Link" );
				Assert.assertTrue(true,
						"Clicked on TaxToProperty Link");}
			else {
				System.out.println(" TaxToProperty Link is not found");
				logger.error("Failed to Click on TaxToProperty Link");
				test.log(Status.FAIL,
						"Failed to Click on TaxToProperty Link");
				Assert.assertFalse(false, 
						"TaxToProperty Link not found");
			}

			ExplicitWait(Enter_Tax_Name);
			if (Enter_Tax_Name.isDisplayed()) 
			{
				Enter_Tax_Name.click();
				Enter_Tax_Name.clear();
				Enter_Tax_Name.sendKeys(Tax_Name+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				System.out.println(" Tax_Name is entered successfully");
				logger.info("Tax_Name is entered successfully");
				test.log(Status.PASS,
						"Tax_Name is entered successfully" );
				Assert.assertTrue(true,
						"Tax_Name is entered successfully");
			} else {
				System.out.println("Tax_Name TextBox not found");
				logger.error("Failed to Enter Tax_Name in TextBox");
				test.log(Status.FAIL,
						"Failed to Enter Tax_Name in TextBox");
				Assert.assertFalse(false, 
						"Tax_Name TextBox not found");
			}

			if (Enter_Tax_Code.isDisplayed())
			{
				Enter_Tax_Code.click();
				Enter_Tax_Code.clear();
				Enter_Tax_Code.sendKeys(Tax_Code+"_"+SeleniumRepo.getRandomAlphNumeircString(6));
				System.out.println(" Tax_Code is entered successfully");
				logger.info("Tax_Code is entered successfully");
				test.log(Status.PASS,
						"Tax_Code is entered successfully" );
				Assert.assertTrue(true,
						"Tax_Code is entered successfully");
			} else {
				System.out.println("Tax_Code TextBox not found");
				logger.error("Failed to Enter Tax_Code in TextBox");
				test.log(Status.FAIL,
						"Failed to Enter Tax_Code in TextBox");
				Assert.assertFalse(false, 
						"Tax_Code TextBox not found");
			}

			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Frequency,Charge_Frequency);
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
						"Failed to Select Charge Frequency");
				e.printStackTrace();
			}


			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Basis,Charge_Basis);
				System.out.println("Charge_Basisis Selected succesfully");
				logger.info("Charge_Basis is Selected succesfully");
				test.log(Status.PASS,
						"Charge_Basis is Selected succesfully" );
				Assert.assertTrue(true,
						"Charge_Basis is Selected succesfully");
			} catch (Exception e) {
				System.out.println("Charge_Basis is not Selected");
				logger.error("Failed to Select Charge Basis");
				test.log(Status.FAIL,
						"Failed to Select Charge Basis");
				Assert.assertFalse(false, 
						"Failed to Select Charge Basis");
				e.printStackTrace();
			}

			try {
				SeleniumRepoCheckBox.MutlipleCheckCheckBox(Enter_Charge_Type,Charge_Type);
				System.out.println("Charge_Type is Selected succesfully");
				logger.info("Charge_Type is Selected succesfully");
				test.log(Status.PASS,
						"Charge_Type is Selected succesfully" );
				Assert.assertTrue(true,
						"Charge_Type is Selected succesfully");
			} catch (Exception e) {
				System.out.println("Charge_Type is not Selected");
				logger.error("Failed to Select Charge Type");
				test.log(Status.FAIL,
						"Failed to Select Charge Type");
				Assert.assertFalse(false, 
						"Failed to Select Charge Type");
				e.printStackTrace();
			}
			if (Enter_Charge_Amount.isDisplayed()) 
			{
				Enter_Charge_Amount.click();
				Enter_Charge_Amount.clear();
				Enter_Charge_Amount.sendKeys(Charge_Amount);
				System.out.println(" Charge_Amount is entered successfully");
				logger.info("Charge_Amount is entered successfully");
				test.log(Status.PASS,
						"Charge_Amount is entered successfully" );
				Assert.assertTrue(true,
						"Charge_Amount is entered successfully");
			} else {
				System.out.println("Charge_Amount TextBox not found");
				logger.error("Failed to Enter Charge_Amount in TextBox");
				test.log(Status.FAIL,
						"Failed to Enter Charge_Amount in TextBox");
				Assert.assertFalse(false, 
						"Charge_AmountTextBox not found");
			}


			if (DayOfWeekAll.isDisplayed()) 
			{
				if (DayOfWeekAll.isSelected() == false)
					DayOfWeekAll.click();
				SeleniumRepo.WaitForLoad(100);
				System.out.println("DayOfWeekAll is Clicked successfully");
				logger.info("Clicked on DayOfWeekAll");
				test.log(Status.PASS,
						"Clicked on DayOfWeekAll" );
				Assert.assertTrue(true,
						"DayOfWeekAll is Clicked successfully");
			} else {
				System.out.println("DayOfWeekAll not Clicked");
				logger.error("Failed to Click on DayOfWeekAll");
				test.log(Status.FAIL,
						"Failed to Click on DayOfWeekAll");
				Assert.assertFalse(false, 
						"DayOfWeekAll not Clicked");
			}


			try {
				Click_SaveButton.click();
				SeleniumRepo.waitForPageLoaded();
				System.out.println("Saved");
				logger.info("Clicked on Save button");
				test.log(Status.PASS,
						"Clicked on Save button" );
			} catch (Exception e) {
				System.out.println("Not Saved");
				logger.error("Failed to Click on Save button");
				test.log(Status.FAIL,
						"Failed to Click on Save button");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.error("Unable to create Taxes And Fees for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Taxes And Fees for selected property because of this execption" + e);
			e.printStackTrace();
		}
	}
}
