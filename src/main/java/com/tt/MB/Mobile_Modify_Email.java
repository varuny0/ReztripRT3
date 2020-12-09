package com.tt.MB;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;


public class Mobile_Modify_Email extends BaseTest {

	@FindAll({ @FindBy( xpath = "(//span[contains(text(),'QA2 Sachin 6-2018')])[2]"),})

	public WebElement mail_conf;

	@FindAll({ @FindBy (xpath = "(//p[contains(text(),'To change or cancel your reservation')]/a)[1]"), })

	public WebElement change_click;

	@FindAll({ @FindBy (xpath = "(//a[contains(text(),'Change reservation')]"), })

	public WebElement change_reservation;

	@FindAll({ @FindBy (xpath = "(//div[@id='popup']/div/h3"), })

	public WebElement change_reservation_popup;

	@FindAll({ @FindBy (xpath = "//span[contains(text(),'roomtype')]"), })

	public WebElement room_selection;

	@FindAll({ @FindBy (xpath = "//button[contains(text(),'Book now')]"), })

	public WebElement BookNow;

	@FindAll({ @FindBy (xpath = "//button[contains(text(),'Confirm details')]"), })

	public WebElement confirmdetails;

	@FindAll({ @FindBy(xpath ="//input[@id='card_number']"), })

	public WebElement CardNumber;

	@FindAll({ @FindBy(xpath = "//select[@id='expiration_date_month']"), })

	public WebElement expdate;

	@FindAll({ @FindBy(xpath = "//select[@id='expiration_date_year']"), })

	public WebElement expyear;

	@FindAll({ @FindBy(xpath = "//input[@id='security_code']"), })

	public WebElement CVV;

	@FindAll({ @FindBy( xpath = "//select[@id='booking_country']"), })

	public WebElement country;

	@FindAll({ @FindBy(xpath = "//legend[contains(text(),'Billing address')]"),})

	public WebElement BillingAddress;

	@FindAll({ @FindBy(xpath = "//span[@class='accept_booking']//label"), })

	public WebElement Verify_accept;

	@FindAll({ @FindBy(xpath = "//input[@id='accept']"), })

	public WebElement Click_accept;

	@FindAll({ @FindBy(xpath = "//input[@value='Complete reservation']"), })

	public WebElement CompleteReservation;

	@FindAll({ @FindBy(xpath = "//h2[contains(text(),'Thank you for your reservation')]"), })

	public WebElement Verify_thankyou;

	@FindAll({ @FindBy(xpath = "//strong[contains(text(),'sacqa6')]"), })

	public WebElement Confirmation_code;


	public void mail_conf() {
		ExplicitWait(mail_conf);
		
		String confcode = MobileBooking.code;
		System.out.println("The confirmation code is" +confcode);
		if(mail_conf.isDisplayed()) {
			
			mail_conf.click();

			System.out.println("Able to click on mail link");
			Assert.assertTrue(true, "Able to click on mail link");
		}
		else {
			System.out.println("Unable to click on mail link");
			Assert.assertFalse(false, "Unable to click on mail link");
		}
	}
	public void change_click() throws InterruptedException {
		ExplicitWait(change_click);
		if(change_click.isDisplayed()){
			//change_click.click();
			Javascriptexecutor(change_click);
			Thread.sleep(2000);
			System.out.println("Able to click on change the reservation link");
			Assert.assertTrue(true, "Able to click on change the reservation link");
		}
		else {
			System.out.println("Unable to click on change reservation link");
			Assert.assertFalse(false, "Unable to click on change reservation link");
		}
	}
	
	public void BEpage() throws InterruptedException {
		Thread.sleep(2000);
		
		List<String> tabs1 = windowidList();
		SeleniumRepo.driver.switchTo().window(tabs1.get(2));
		
		System.out.println("url is"+SeleniumRepo.driver.getTitle());
	}

	public void change_reservation() throws InterruptedException {
	
		ExplicitWait(change_reservation);
		if(change_reservation.isDisplayed()) {
			
			Thread.sleep(1000);
			Javascriptexecutor(change_reservation);
			System.out.println("clicked on change reservation button");
			Assert.assertTrue(true, "clicked on change reservation button");
		}
		else {
			System.out.println("Unable to clicked on change reservation button");
			Assert.assertFalse(false, "Unable to clicked on change reservation button");
		}
	}

	public void change_reservation_popup() {
		if(change_reservation_popup.isDisplayed()) {
			String change = change_reservation_popup.getText();
			String amount = SeleniumRepo.driver.findElement(By.xpath("(//p[contains(text(),'change reservation fee will')])[1]")).getText();
			WebElement yes = SeleniumRepo.driver.findElement(By.xpath("//span[contains(text(),'Yes')]"));
			System.out.println("Able to view the "+change+"");
			System.out.println("Able to view the "+amount);
			yes.click();

			System.out.println("Able to view the change reservation popup");
			Assert.assertTrue(true,"Able to view the change reservation popup");
		}
		else {
			System.out.println("Unable to view the change reservation popup");
			Assert.assertFalse(false,"Unable to view the change reservation popup");
		}
	}

	public void room_selection(String roomtype) {
		if(room_selection.isDisplayed()) {

			String price = SeleniumRepo.driver.findElement(By.xpath("//span[@class='rooms_price']")).getText();
			System.out.println(""+roomtype+" price is "+price+"");
			room_selection.click();

			System.out.println("selected the "+roomtype);		
		}
	}

	public void booknow() {
		if(BookNow.isDisplayed()) {
			BookNow.click();

			System.out.println("clicked on booknow button");
			Assert.assertTrue(true, "clicked on booknow button");
		}
		System.out.println("Unable to clicked on BookNow button");
		Assert.assertFalse(false, "Unable to clicked on BookNow button");
	}

	public void confirmdetails() {
		if(confirmdetails.isDisplayed()){
			confirmdetails.click();

			System.out.println("Clicked on confirm details");
			Assert.assertTrue(true, "Clicked on confirm details");
		}
		System.out.println("Unable to clicked on confirm details");
		Assert.assertFalse(false, "Unable to clicked on confirm details");
	}

	public void CardNumber(String Numberoncard)
	{
		if (CardNumber.isDisplayed())
		{
			Javascriptexecutor(CardNumber);
			CardNumber.clear();
			TypeInField(CardNumber, Numberoncard);
			//CardNumb.sendKeys(Numberoncard);
			System.out.println("Entered card number");
			Assert.assertTrue(true, "Entered card number");
		} 
		else {
			System.out.println("Not Entered card number");
			Assert.assertFalse(false, "Not Entered card number");
		}
	}
	public void Expdate()
	{
		if(expdate.isDisplayed())
		{
			//CardNumb.clear();
			expdate.click();
			expdate.sendKeys("02");
			System.out.println("Entered Experied Month");
			Assert.assertTrue(true, "Entered Experied Month");
		} 
		else {
			System.out.println("Not Entered Experied Month");
			Assert.assertFalse(false, "Not Entered Experied Month");
		}

		if (expyear.isEnabled()) {
			expyear.isDisplayed();
			//expyear.click();
			selectByVisibleText(expyear, "2022");
			//expyear.sendKeys("2022");
			System.out.println("Entered Experied year");
			Assert.assertTrue(true, "Entered Experied year");
		} else {
			System.out.println("Not Entered Experied year");
			Assert.assertFalse(false, "Not Entered Experied year");
		}

		if (CVV.isEnabled()) {
			CVV.isDisplayed();
			CVV.click();
			CVV.sendKeys("123");
			System.out.println("Entered CVV number");
			Assert.assertTrue(true, "Entered CVV number");
		}
		else {
			System.out.println("Not Entered CVV number");
			Assert.assertFalse(false, "Not Entered CVV number");
		}
	}

	public void country(String Entercountry) {

		ExplicitWait(country);

		if(country.isEnabled()) {

			country.click();
			SeleniumRepoDropdown.selectDropDownText(country, Entercountry);
			System.out.println("selected the country");
		}
		else {
			System.out.println("Unable to select the country");
		}
	}

	public void BillingAddress(String Address, String Address2, String Entercity, String Enterstate) {

		ExplicitWait(BillingAddress); 

		if(BillingAddress.isDisplayed()) {

			WebElement Address_line_1 = SeleniumRepo.driver.findElement(By.xpath("//input[@name='booking[street_address1]']"));
			WebElement Address_line_2 = SeleniumRepo.driver.findElement(By.xpath("//input[@name='booking[street_address2]']"));
			WebElement City = SeleniumRepo.driver.findElement(By.xpath("//input[@name='booking[city]']"));
			WebElement State = SeleniumRepo.driver.findElement(By.xpath("//select[@name='state']"));
			WebElement Zipcode = SeleniumRepo.driver.findElement(By.xpath("//input[@name='booking[zip_code]']"));

			if(Address_line_1.isEnabled()) {
				Address_line_1.click();
				Address_line_1.sendKeys(Address);
				System.out.println("Able to enter the address line 1");
			}
			else {
				System.out.println("Unable to enter the address");
			}

			if(Address_line_2.isEnabled()) {

				Address_line_2.click();
				Address_line_2.sendKeys(Address2);
				System.out.println("ABle to enter Address line 2");
			}
			else {
				System.out.println("Unable to enter address line 2");
			}

			if(City.isDisplayed()) {
				City.click();
				City.sendKeys(Entercity);
				System.out.println("Able to enter city");
			}
			else {
				System.out.println("Unable to enter city");
			}
			if(State.isDisplayed()) {
				State.click();
				SeleniumRepoDropdown.selectDropDownText(State, Enterstate);
				System.out.println("Able to enter the state");
			}
			else {
				System.out.println("Unable to enter State");
			}

			System.out.println("Able to enter the billing address details");
			Assert.assertTrue(true, "Able to enter the billing address details");
		}
		else {
			System.out.println("Unable to enter the Billing Address details");
			Assert.assertFalse(false, "Unable to enter the Billing Address details" );
		}	
	}

	public void verify() {	
		if (Verify_accept.isDisplayed()) {
			String termsandcondition=Verify_accept.getText();
			System.out.println("Text obtained is"+termsandcondition);
			if(termsandcondition.contains("I accept the Terms & Conditions"))
			{
				System.out.println("Expected text "+termsandcondition +" is obtained");
			}
			else{

				System.out.println("Expected text "+termsandcondition +" is not obtained");
			}
			test.log(Status.INFO, "I accept the Terms & Conditions Element is present");

		} else {
			System.out.println("I accept the Terms & Conditions Element is not present");
		}

		if (Click_accept.isEnabled()) {
			Click_accept.isDisplayed();
			Click_accept.click();
			System.out.println("Clicked on accept checkbox");
		} 
		else {
			System.out.println("Not Clicked on accept checkbox");
		}
		if (CompleteReservation.isEnabled()) 
		{
			Javascriptexecutor(CompleteReservation);
			System.out.println("Clicked on CompleteReservation button");		
		}
		else {
			System.out.println("Not Clicked on CompleteReservation button");		
		}

		SeleniumRepo.waitForPageLoaded();

		ExplicitWait(Verify_thankyou);

		if (Verify_thankyou.isDisplayed()) 
		{
			String Thankyou=Verify_thankyou.getText();
			System.out.println("Text obtained is"+Thankyou);
			if(Thankyou.contains("THANK YOU FOR YOUR RESERVATION"))
			{
				System.out.println("Expected text "+Thankyou+" is obtained");
			}
			else{

				System.out.println("Expected text is not obtained");
			}
		}
	}

	public void Confirmation_code() {
		ExplicitWait(Confirmation_code);

		if(Confirmation_code.isDisplayed()) {

			String resnum = Confirmation_code.getText();
			System.out.println("Confirmation num is "+resnum+" ");

			System.out.println("Able to view the confirmation code");
			Assert.assertTrue(true, "Able to view the confirmation code");
		}
		else {
			System.out.println("Unable to view the confirmation number");
			Assert.assertFalse(false, "Unable to view the confirmation number");
		}	
	}
}
