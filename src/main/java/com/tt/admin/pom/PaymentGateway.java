package com.tt.admin.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

/**
 * Creating Payment Gateway  
 *
 */
public class PaymentGateway extends BaseTest 
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	String result=this.getClass().getSimpleName();

	@FindAll({ @FindBy(xpath = "//a[contains(.,'Payment')]"),

	})
	private WebElement Click_PaymentGatewayLink;



	@FindAll({ @FindBy(xpath = "//td//input[@value='true']"),

	})
	private WebElement Enable_RadioButton;

	@FindAll({ @FindBy(xpath = "//select[@name = 'selectedPaymentGateway']"),

	})
	private WebElement Select_Payment;

	@FindAll({ @FindBy(xpath = "//input[@name='merchantId']"),

	})
	private WebElement Enter_MerchantID;

	@FindAll({ @FindBy(xpath = "//input[@name='accessCode']"),

	})
	private WebElement Enter_AccessCode;


	@FindAll({ @FindBy(xpath = "//input[@name='apiVersion']"),

	})
	private WebElement Enter_APIVerison;


	@FindAll({ @FindBy(xpath = "//select[@name='locale']"),

	})
	private  WebElement  Select_Language;

	@FindAll({ @FindBy(xpath = "//input[@name='secureHashSecret']"),

	})
	private  WebElement  Enter_SecureHashSecret;

	@FindAll({ @FindBy(xpath = "//input[@name='paymentChargeUrl']"),

	})
	private  WebElement Enter_PaymentchargeURL;

	@FindAll({ @FindBy(xpath = "//input[@name='feedbackURI']"),

	})
	private  WebElement Enter_FeedbackURI;

	@FindAll({ @FindBy(xpath = "//input[@value='Update']"),

	})
	private  WebElement Clickon_UpdateButton;

	@FindAll({ @FindBy(xpath = "//*[text()='Property Management']"),

	})
	private WebElement property_Management;

	// Creating Method For Payment Gate	 


	public void createPaymentGate(String Payment, String MerchantID, String AccessCode, String APIVerison,
			String Language, String SecureHashSecret, String PaymentchargeURL, String FeedbackURI) 
	{

		try
		{
			if (Click_PaymentGatewayLink.isDisplayed()) 
			{
				Javascriptexecutor(Click_PaymentGatewayLink);
				ExplicitWait(Enable_RadioButton);
				System.out.println("PropertyManagement element Expanded and PaymentGateway element  found");
				test.log(Status.INFO, "PropertyManagement element Expanded and PaymentGateway element  found");
				Assert.assertTrue(true, "PropertyManagement element Expanded and PaymentGateway element  found");
			} 
			else 
			{
				System.out.println("PropertyManagement Menu is not expanded");
				Javascriptexecutor(property_Management);
				System.out.println("Clicked on PropertyManagement Link");
				test.log(Status.INFO, "Clicked on PropertyManagement Link");

				ExplicitWait(Click_PaymentGatewayLink);
				if(Click_PaymentGatewayLink.isDisplayed())
				{
					Javascriptexecutor(Click_PaymentGatewayLink);
					ExplicitWait(Enable_RadioButton);
					System.out.println("PaymentGateway element found");
					test.log(Status.INFO, "PaymentGateway  element found");
					Assert.assertTrue(true, "PaymentGateway element found");
				}
				else
				{
					logger.info("PaymentGateway element not  found");
					test.log(Status.FAIL, "PaymentGateway element not  found");
				}
			}

			if(Enable_RadioButton.isEnabled()) 
			{
				Enable_RadioButton.click();
				Enable_RadioButton.isSelected();
				test.log(Status.PASS,
						"Enable Radio Button");
				logger.info("Radio Button is Enabled successfully");
				Assert.assertTrue(true,
						"Radio Button is Enabled successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enable Radio Button");
				logger.error("Failed to  Enable Radio Button");
				Assert.assertFalse(false, 
						"Failed to  Enable Radio Button");
			}

			SeleniumRepo.waitForElementPresent(Select_Payment);
			if(Select_Payment.isDisplayed()) 
			{
				SeleniumRepoDropdown.selectDropDownText(Select_Payment, Payment);
				test.log(Status.PASS, "Select Payment");
				logger.info("Payment is Select successfully");
				Assert.assertTrue(true,
						"Payment is Select successfully");
			} else {
				test.log(Status.FAIL, "Failed to Select Payment");
				logger.error("Failed to  Select Payment");
				Assert.assertFalse(false, 
						"Failed to  Select Payment");
			}


			SeleniumRepo.waitForElementPresent(Enter_MerchantID);
			if(Enter_MerchantID.isDisplayed()) 
			{
				Enter_MerchantID.click();
				Enter_MerchantID.clear();
				Enter_MerchantID.sendKeys(MerchantID);
				test.log(Status.PASS, 
						"Enter_MerchantID");
				logger.info("Enter_MerchantID successfully");
				Assert.assertTrue(true,
						"Enter_MerchantID successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Enter_MerchantID");
				logger.error("Failed to Enter_MerchantID");
				Assert.assertFalse(false, 
						"Failed to Enter_MerchantID");
			}


			SeleniumRepo.waitForElementPresent(Enter_AccessCode);
			if(Enter_AccessCode.isDisplayed()) 
			{
				Enter_AccessCode.click();
				Enter_AccessCode.clear();
				Enter_AccessCode.sendKeys(AccessCode);
				test.log(Status.PASS, 
						"Enter_AccessCode");
				logger.info("Enter_AccessCode successfully");
				Assert.assertTrue(true,
						"Enter_AccessCode successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter_AccessCode");
				logger.error("Failed to Enter_MerchantID");
				Assert.assertFalse(false, 
						"Failed to Enter_MerchantID");
			}


			SeleniumRepo.waitForElementPresent(Enter_APIVerison);
			if(Enter_APIVerison.isDisplayed()) 
			{
				Enter_APIVerison.click();
				Enter_APIVerison.clear();
				Enter_APIVerison.sendKeys(APIVerison);
				test.log(Status.PASS,
						"Enter_APIVerison");
				logger.info("Enter_APIVerison successfully");
				Assert.assertTrue(true,
						"Enter_APIVerison successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Enter_APIVerison");
				logger.error("Failed to Enter_APIVerison");
				Assert.assertFalse(false, 
						"Failed to Enter_APIVerison");
			}

			SeleniumRepo.waitForElementPresent(Select_Language);
			if(Select_Language.isDisplayed()) 
			{
				SeleniumRepoDropdown.selectDropDownText(Select_Language, Language);
				test.log(Status.PASS,
						"Select_Language");
				logger.info("Language is Select successfully");
				Assert.assertTrue(true,
						"Language is Select successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Select Language");
				logger.error("Failed to  Select Language");
				Assert.assertTrue(false,
						"Failed to  Select Language");
			}

			SeleniumRepo.waitForElementPresent(Enter_SecureHashSecret);
			if(Enter_SecureHashSecret.isDisplayed()) 
			{
				Enter_SecureHashSecret.click();
				Enter_SecureHashSecret.clear();
				Enter_SecureHashSecret.sendKeys(SecureHashSecret);
				test.log(Status.PASS, 
						"Enter_SecureHashSecret");
				logger.info("Enter_SecureHashSecret successfully");
				Assert.assertTrue(true,
						"Enter_SecureHashSecret successfully");
			} else {
				test.log(Status.FAIL, 
						"Failed to Enter_SecureHashSecret");
				logger.error("Failed to Enter_SecureHashSecret");
				Assert.assertTrue(false,
						"Enter_SecureHashSecret successfully");
			}

			SeleniumRepo.waitForElementPresent(Enter_PaymentchargeURL);
			if(Enter_PaymentchargeURL.isDisplayed()) 
			{
				Enter_PaymentchargeURL.click();
				Enter_PaymentchargeURL.clear();
				Enter_PaymentchargeURL.sendKeys(PaymentchargeURL);
				test.log(Status.PASS,
						"Enter_PaymentchargeURL");
				logger.info("Enter_PaymentchargeURL successfully");
				Assert.assertTrue(true,
						"Enter_SecureHashSecret successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter_PaymentchargeURL");
				logger.error("Failed to Enter_PaymentchargeURL");
				Assert.assertTrue(false,
						"Enter_SecureHashSecret successfully");
				Assert.assertTrue(false,
						"Enter_SecureHashSecret successfully");
			}



			SeleniumRepo.waitForElementPresent(Enter_FeedbackURI);
			if(Enter_FeedbackURI.isDisplayed()) 
			{
				Enter_FeedbackURI.click();
				Enter_FeedbackURI.clear();
				Enter_FeedbackURI.sendKeys(FeedbackURI);
				test.log(Status.PASS, 
						"Enter_FeedbackURI");
				logger.info("Enter_FeedbackURI successfully");
				Assert.assertTrue(true,
						"Enter_FeedbackURI successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Enter_FeedbackURI");
				logger.error("Failed to Enter_FeedbackURI");
			}

			SeleniumRepo.waitForElementPresent(Clickon_UpdateButton);
			if(Clickon_UpdateButton.isDisplayed()) 
			{
				Clickon_UpdateButton.click();
				test.log(Status.PASS,
						"Clickon_UpdateButton");
				logger.info("Clickon_UpdateButton successfully");
			} else {
				test.log(Status.FAIL,
						"Failed to Clickon_UpdateButton");
				logger.error("Failed to Clickon_UpdateButton");
				Assert.assertTrue(false,
						"Failed to Clickon_UpdateButton");
			}




		} catch (Exception e) {
			logger.error("Unable to create Payment Gateway for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Payment Gateway for selected property because of this execption" + e);
			e.printStackTrace();
		}



	}}
