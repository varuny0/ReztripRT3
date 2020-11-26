package com.tt.BE.pom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class Multi_Language_And_Currency extends BaseTest {
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	@FindAll({ @FindBy(xpath = "//a[text()='Meine Buchungen']"), })
	
	public WebElement Verify_Mybooking;
	
	@FindAll({ @FindBy(xpath = "//a[@id='currency-dropdown']"), })

	public WebElement currencydropdown;
	
	@FindAll({ @FindBy(xpath = "//a[@id='language-dropdown']"), })
	
	public WebElement language_dropdown;
	
	@FindAll({ @FindBy(xpath = "//input[@id='search_arrival_date']"), })
	
	public WebElement arrival_date;
	
	@FindAll({ @FindBy( xpath = "//input[@id='search_departure_date']"), })
	
	public WebElement depature_date;
	
	@FindAll({ @FindBy(xpath = "//div[@class='search-form-item relative rooms_guests_field']"), })
	
	public WebElement rooms_guests;
	
	@FindAll({ @FindBy(xpath = "//select[@id='roomsselector']"), })
	
	public WebElement rooms;
	
	@FindAll({ @FindBy(xpath = "//select[@id='adults-in-room-1']"), })
	
	public WebElement Adults;
	
	@FindAll({ @FindBy(xpath = "//select[@id='children-in-room-1']"), })
	
	public WebElement children;
	
	@FindAll({@FindBy(xpath = "	//button[text()='Fertig']"), })
	
	public WebElement Done;
	
    @FindAll({ @FindBy(xpath = "//span[text()='Sonderpreis!']"), })
	
	public WebElement special_rate;
    
    @FindAll({ @FindBy(xpath="//span[text()='Done']"), })
    
    public WebElement specialrate_Done;
    
    @FindAll({ @FindBy(xpath = "//button[text()='Verfügbarkeit Prüfen']"), })
     
    public WebElement check_availablity; 
    
    @FindAll({ @FindBy(xpath = "//button[text()='Jetzt buchen!']"), })
    
    public WebElement booknow;
    
    @FindAll({ @FindBy(xpath = "//a[contains(text(),'Zimmer')]"), })

	public WebElement verify_Headingrooms;
    
    @FindAll({ @FindBy(xpath = "//strong[contains(text(),'Reservierungsdaten')]"), })
    
    public WebElement verify_reservation_details;
    
    @FindAll({ @FindBy(xpath ="//strong[contains(text(),'Neuanfang')]"), })
   
    public WebElement StartOver;
    
    @FindAll({ @FindBy(xpath = "//span[contains(text(),'Gästedaten')]"), })
    
    public WebElement Guestdetails;
    
    @FindAll({ @FindBy(xpath = "//input[@id='is_opted_in']"), })
    
    public WebElement Click_i_would;
    
    @FindAll({ @FindBy( xpath ="//button[contains(text(),'Daten bestätigen')]"),})
    
    public WebElement confirm;  
    
    @FindAll({ @FindBy( xpath = "//strong[contains(text(),'Zahlungsdaten')]"),})
    
    public WebElement Paymentdetails;
    
    @FindAll({ @FindBy( xpath = "//select[@id='booking_country']"), })
    
    public WebElement country;
    
    @FindAll({ @FindBy(xpath = "//legend[contains(text(),'Kartendaten')]"), })
    
    public WebElement Card_Information;
    
    @FindAll({ @FindBy(xpath = "//input[@id='card_holder_name']"), })
    
    public WebElement Name_on_card;
    
    @FindAll({ @FindBy(xpath ="//input[@id='card_number']"), })
    
    public WebElement CardNumber;
    
	@FindAll({ @FindBy(xpath = "//select[@id='expiration_date_month']"), })

	public WebElement expdate;

	@FindAll({ @FindBy(xpath = "//select[@id='expiration_date_year']"), })

	public WebElement expyear;

	@FindAll({ @FindBy(xpath = "//input[@id='security_code']"), })

	public WebElement CVV;
    
    @FindAll({ @FindBy(xpath = "//legend[contains(text(),'Rechnungsadresse')]"),})
    
    public WebElement BillingAddress;
    
    @FindAll({ @FindBy(xpath = "//legend[contains(text(),'Zusätzliche Kontaktinformation')]"), })

	public WebElement contactinformation;
    
    @FindAll({ @FindBy(xpath = "//input[@id='booking_phone_number']"),})
    
    public WebElement PhoneNumber;
    
    @FindAll({ @FindBy(xpath = "//span[contains(text(),'Zimmerkosten:')]"), })

	public WebElement verify_paymentroomcharges;
    
    @FindAll({ @FindBy(xpath = "//span[contains(text(),'Taxes and fees:')]"), })

	public WebElement verify_paymenttaxesandfees;
    
    @FindAll({ @FindBy(xpath = "//span[contains(text(),'Summe:')]"), })

	public WebElement verify_paymentgrandtotal;
    
	@FindAll({ @FindBy(xpath = "//span[@class='accept_booking']//label"), })

	public WebElement Verify_accept;

	@FindAll({ @FindBy(xpath = "//input[@id='accept']"), })

	public WebElement Click_accept;

	@FindAll({ @FindBy(xpath = "//input[@value='Reservier. abschließen']"), })

	public WebElement CompleteReservation;
	
	@FindAll({ @FindBy(xpath = "//h2[contains(text(),'Danke für Ihre Reservierung')]"), })

	public WebElement Verify_thankyou;
    
    
    public void GoToUrl() throws IOException
	{
		String beurl=ReadProperties.getPropValues("Admin.properties", "BEURL");
		SeleniumRepo.GoToUrl(beurl);
	}
    
public void language_dropdown(String Language) throws InterruptedException {
		
		ExplicitWait(language_dropdown);
		if(language_dropdown.isDisplayed()) {
			
			language_dropdown.click();	
			Thread.sleep(1000);
			SeleniumRepo.driver.findElement(By.xpath("//a[text()='"+Language+"']")).click();
			
		String lang = language_dropdown.getText();
		if(lang.contains(Language)) {
			System.out.println("Selected "+lang+" language");
			logger.info("Selected '"+lang+"' language");
			test.log(Status.PASS, "Selected "+lang+" language");	
		}
		else {
			logger.error("Not Selected the "+lang+" language");
			test.log(Status.FAIL, "Not Selected the "+lang+" language");
		}
		logger.info("Able to select the language dropdown");
		test.log(Status.PASS, "Able to select the language dropdown");
		}
		else {
			logger.error("Unable to select the language dropdown");
			test.log(Status.FAIL, "Unable to select the language dropdown");
		}	
    }
    
    public void Verify_Mybooking() {
    
		ExplicitWait(Verify_Mybooking);
		if (Verify_Mybooking.isDisplayed()) 
		{
			String text=Verify_Mybooking.getText();
			if(text.contains("Meine Buchungen"))
			{
				System.out.println("Mybooking label is "+text+" is displayed");
				test.log(Status.PASS, "Expected text "+text+" is obtained");
				logger.info("Expected text "+text+" is obtained");
			}
			else{
				test.log(Status.FAIL, "Expected text "+text+" is not obtained");
				logger.error("Expected text "+text+" is not obtained");
			}
			logger.info("verified mybooking text");
			test.log(Status.PASS, "verified mybooking text");
		} 
		else 
		{
			logger.error("My Bookings field notfound");
			test.log(Status.FAIL, "My Bookings field notfound");
		}
    }
    
    public void currencydropdown(String EnterCurrency) throws InterruptedException {
    	ExplicitWait(currencydropdown);
    	if(currencydropdown.isDisplayed()) {
    		
    		currencydropdown.click();
    		Thread.sleep(1000);
    		SeleniumRepo.driver.findElement(By.xpath("//a[text()='"+EnterCurrency+"']")).click();
    	String selected_currency = currencydropdown.getText();
    	//System.out.println();
    	if(selected_currency.contains("EUR")) {
    		
    		System.out.println("Expected currency "+selected_currency+" is selected");
    		
    		logger.info("Expected currency "+selected_currency+" is selected");
    		test.log(Status.PASS, "Expected currency "+selected_currency+" is selected");    		
    	}
    	else {
    		logger.error("Expected currency "+selected_currency+" is not selected");
    		test.log(Status.FAIL, "Expected currency "+selected_currency+" is not selected");
    	}
    		logger.info("able to click on currency dropdown");
    		test.log(Status.PASS, "able to click on currency dropdown");
    	}
    	else {
    		
    		logger.error("unable to click on currency dropdown");
    		test.log(Status.FAIL, "unable to click on currency dropdown");
    	}
    		
    	}
    	
	
    
	public void arrival_date() {
		ExplicitWait(arrival_date);
		
	Date current_date = new Date();
	current_date.setDate(current_date.getDate() +3);
	SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YYYY");
	String formattedcurrent_date = df1.format(current_date);
	
	if (SeleniumRepo.isElementPresent(arrival_date)) 
	{
		arrival_date.click();
		arrival_date.clear();
		TypeInField(arrival_date, formattedcurrent_date);
		//arrival_date.sendKeys(formattedcurrent_date);
		System.out.println("Arrival date is: "+formattedcurrent_date+"");
 		test.log(Status.INFO, "Clicked on arrivaldate Link");
		logger.info("Clicked on arrivaldate Link");

	}
	else 
	{
		logger.error("arrivaldate TextBox not found");
		test.log(Status.FAIL, "arrivaldate TextBox not found");

	}

}
	 
		public void depature_date() {
			ExplicitWait(depature_date);
			
			Date date1 = new Date();
            date1.setDate(date1.getDate() +5);
			SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/YYYY");
			String formatteddate1 = df1.format(date1);
			
			if(SeleniumRepo.isElementPresent(depature_date)){
				depature_date.click();
				depature_date.clear();
				TypeInField(depature_date, formatteddate1);
				System.out.println("Depature date is: "+formatteddate1+" ");
				//depature_date.sendKeys(formatteddate1);
			
			
//			SimpleDateFormat df1;
//			
//			if(depature_date.equals("DD-MM-YYYY")) {
//				df1 = new SimpleDateFormat("DD-MM-YYYY");
//			}
//			else{
//					df1 = new SimpleDateFormat("MM-DD-YYYY");
//			}
//			Date date1 = new Date();
//			date1.setDate(date1.getDate() +1);
//			String formatteddate1 = df1.format(date1);
				
			test.log(Status.INFO, "Clicked on depature date");
			logger.info("Clicked on depature date");
			}
			else {
				test.log(Status.FAIL, "Unable to click on depature date");
				logger.error("Unable to click on depature date");
			}
		}
	
	public void rooms_guests() {
		ExplicitWait(rooms_guests);
		
		if(rooms_guests.isDisplayed()) {
			rooms_guests.click();
		test.log(Status.INFO, "Able to view pop_up");
		logger.info("Able to view pop_up");
		}
		else {
			test.log(Status.FAIL,"Unable to view pop_up");
			logger.error("Unable to view pop_up");
		}
	}
    
	public void rooms(String EnterRooms) {
		ExplicitWait(rooms);
		
		if(rooms.isEnabled()) {
			
			rooms.click();
		SeleniumRepoDropdown.selectDropDownValue(rooms, EnterRooms);
		test.log(Status.INFO, "Able to select room");
		logger.info("Able to select room");
		}
		else {
			test.log(Status.FAIL, "Unable to select room");
			logger.error("Unable to select room");
		}
	}
	
	public void Adults(String EnterAdults) {
		
		ExplicitWait(Adults);
		
		if(Adults.isEnabled()) {
			
			SeleniumRepoDropdown.selectDropDownValue(Adults, EnterAdults);		
			System.out.println(Adults.getSize());
			
			test.log(Status.PASS, "Selected adults");
			logger.info("Selected adults");
		}
		else {
			test.log(Status.FAIL, "Unable to select the adults");
			logger.error("Unable to select the adults");
		}
	}
	
	public void Done() throws InterruptedException {
		ExplicitWait(Done);
		if(Done.isEnabled()) {
		Done.click();
		Thread.sleep(1000);
		
		test.log(Status.PASS, "Able to clicked on Done");
		logger.info("Able to clicked on done");
		}
		else {
			test.log(Status.FAIL, "Unable to click on Done");
			logger.error("Unable to click on Done");;
		}
	}
	
	public void special_rate() {
		ExplicitWait(special_rate);
		if(special_rate.isDisplayed()) {
			special_rate.click();
			
			
		}
	}
	public void check_availablity() throws InterruptedException {
		
		ExplicitWait(check_availablity);
		
		Thread.sleep(1000);
		
	if(check_availablity.isDisplayed()) {
		check_availablity.click();
		String test1 = check_availablity.getText();
		if(test1.contains("Verfügbarkeit Prüfen")) {
			test.log(Status.INFO, "Expected text "+test1+"is obtained");
			logger.info("Expected text \"+test1+\"is obtained");
		}
		else {
			test.log(Status.FAIL, "Expected text "+test1+"is not obtained");
			logger.error("Expected text "+test1+"is not obtained");
		}
		test.log(Status.PASS, "Verified check availability text");
		logger.info("Verified check availability text");
	}
	else {
		test.log(Status.FAIL, "check availability text is not found");
		logger.error("check availability text is not found");
		
	
		
	}		
	}
	
	public void room_type( String roomtype) throws InterruptedException {
		Thread.sleep(3000);
		SeleniumRepo.waitForPageLoaded();
		
		String a="//span[contains(text(),'"+roomtype+"') and @class='rooms-list-title ng-binding'])";
		WebElement Room=SeleniumRepo.driver.findElement(By.xpath("//span[contains(text(),'"+roomtype+"') and @class='rooms-list-title ng-binding']"));
		Thread.sleep(1000);
		Room.click();
		
		Thread.sleep(1000);
		System.out.println("selected room is "+roomtype+"");
		logger.info( "Clicked on "+roomtype+ " room");
		test.log(Status.INFO, "Clicked on "+roomtype+ " room");

	}
	
	public void booknow() {
		
		ExplicitWait(booknow);
		if(booknow.isEnabled()) {
			booknow.click();
		test.log(Status.INFO, "Clicked on Booknow Button");
		logger.info("Clicked on Booknow Button");
		}
		else {
			test.log(Status.FAIL, "Failed to click on Booknow Button");
			logger.error("Failed to click on Booknow Button");
		}	
	}
	
	public void verify_Headingrooms() {
		ExplicitWait(verify_Headingrooms);
		
		if(verify_Headingrooms.isDisplayed()){
			System.out.println(verify_Headingrooms.getText());
			
			test.log(Status.INFO, "Verified rooms title");
			logger.info("Verified rooms title");
		}
	}
	
	public void verify_reservation_details() {
		
		ExplicitWait(verify_reservation_details);
		
		if(verify_reservation_details.isDisplayed()) {
			System.out.println(verify_reservation_details.getText());
			
			test.log(Status.PASS, "Verified reservation details");
			logger.info("Verified reservation details");
		}
	}
	
	public void StartOver() {
		
		ExplicitWait(StartOver);
		
		if(StartOver.isDisplayed()) {
			System.out.println(StartOver.getText());
			
			test.log(Status.PASS, "Verified start over text");
			logger.info("Verified stat over text");
		}
	}
   
	public void Guestdetails(String FirstName, String LastName, String Email) {
		ExplicitWait(Guestdetails);
				
		if(Guestdetails.isDisplayed()) {		
			
	
		WebElement firstname = SeleniumRepo.driver.findElement(By.xpath("//input [@name='booking[first_name]']"));
		WebElement lastname = SeleniumRepo.driver.findElement(By.xpath("//input [@name='booking[last_name]']"));
		WebElement email = SeleniumRepo.driver.findElement(By.xpath("//input [@name='booking[email]']"));

		
		
		firstname.click();
		firstname.sendKeys(FirstName);
		System.out.println("Firstname is "+FirstName+"");
		
		lastname.click();
		lastname.sendKeys(LastName);
		System.out.println("Last name is "+LastName+"");
		
		email.click();
		email.sendKeys(Email);
		System.out.println("Email is "+Email+"");
		test.log(Status.PASS, "Guestdetails label is displayed");
		logger.info("Guestdetails label is displayed");
}		
else {
	test.log(Status.FAIL, "Guesstdetails label is not displayed");
	logger.error("Guestdetails label is not displayed");
}
		
			}
	
	public void Click_i_would() {
		ExplicitWait(Click_i_would);
		
		if(Click_i_would.isEnabled()) {
			Click_i_would.click();
			System.out.println("Clicked on checkbox ");
		}
		else {
			System.out.println("Unable to clicked on checkbox on guestdetails page");
		}
	}
	
	public void confirm() {
		if(confirm.isEnabled()) {
			confirm.click();
			System.out.println("Clicked on confirm button");
		}
		else {
			System.out.println("Unable to click on confirm buton");
		}
	}
				
			
	public void Paymentdetails() {
		ExplicitWait(Paymentdetails);
		
		if(Paymentdetails.isDisplayed()) {
			System.out.println("Paymentdetails page is displayed");
		}
		else {
			System.out.println("Paymentdetails page is not displayed");
		}
	}
	
	public void Card_Information() throws InterruptedException {
		Thread.sleep(5000);
		if (Card_Information.isDisplayed()) 
		{
			String card=Card_Information.getText();
			System.out.println("Text obtained is" +card);
			if(card.contains("CARD INFORMATION"))
			{
				System.out.println("Expected text is obtained");
			}
			else{

				System.out.println("Expected text is not obtained");
			}
			test.log(Status.INFO, "CardInformation Element is present");

		} else {
			System.out.println("CardInformation Element is not present");
			logger.error("CardInformation Expected value is not present");
			test.log(Status.FAIL, "CardInformation Element is not present");

		}
	}
	
	public void Name_on_card(String Cardname)
	{

		if(Name_on_card.isDisplayed())
		{
			Name_on_card.clear();
			Name_on_card.click();
			Name_on_card.sendKeys(Cardname);
			logger.info("Entered card name");
			test.log(Status.INFO, "Entered card name");

		} else {
			//System.out.println("Not Entered card name");
			logger.error("Not Entered card name");
			test.log(Status.FAIL, "Not Entered card name");
		}
	}
	
	public void CardNumber(String Numberoncard)
	{

		if (CardNumber.isDisplayed())
		{
			Javascriptexecutor(CardNumber);
			CardNumber.clear();

			TypeInField(CardNumber, Numberoncard);
			//CardNumb.sendKeys(Numberoncard);
			logger.info("Entered card number");
			test.log(Status.INFO, "Entered card number");

		} else {
			//System.out.println("Not Entered card number");
			logger.error("Not Entered card number");
			test.log(Status.FAIL, "Not Entered card number");
		}
	}
	
	public void Expdate()
	{

		if(expdate.isDisplayed())
		{
			//CardNumb.clear();
			expdate.click();
			expdate.sendKeys("02");
			logger.info("Entered Experied Month");
			test.log(Status.INFO, "Entered Experied Month");

		} else {
			//System.out.println("Not Entered Experied Month");
			logger.error("Not Entered Experied Month");
			test.log(Status.FAIL, "Not Entered Experied Month");
		}

		if (expyear.isEnabled()) {
			expyear.isDisplayed();
			//expyear.click();
			selectByVisibleText(expyear, "2022");
			//expyear.sendKeys("2022");
			logger.info("Entered Experied year");
			test.log(Status.INFO, "Entered Experied year");

		} else {
			//System.out.println("Not Entered Experied year");
			logger.error("Not Entered Experied year");
			test.log(Status.FAIL, "Not Entered Experied year");
		}

		if (CVV.isEnabled()) {
			CVV.isDisplayed();
			CVV.click();
			CVV.sendKeys("123");
			logger.info("Entered CVV number");
			test.log(Status.INFO, "Entered CVV number");

		} else 
		{
			//System.out.println("Not Entered CVV number");
			logger.error("Not Entered CVV number");
			test.log(Status.FAIL, "Not Entered CVV number");

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
	
	public void BillingAddress(String Address, String Address2, String Entercity, String Enterstate, String Enterzipcode) {
		
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
			if(Zipcode.isDisplayed()) {
			Zipcode.click();
			Zipcode.sendKeys(Enterzipcode);
			System.out.println("Able to enter the zipcode");
			}
			else {
				System.out.println("Unable to enter zipcode");
			}
		}
		else {
			System.out.println("Unable to enter the Billing Address details");
		}	
		
		
	}
		
		public void contactinformation(String Enterphonenum) throws InterruptedException
		{
			if (contactinformation.isDisplayed()) {
				String contact=contactinformation.getText();
				//System.out.println("Text obtained is" +contact);
				if(contact.contains("Zusätzliche Kontaktinformation"))
				{
					System.out.println("Expected text "+contact+" is obtained");
				}
				else{

					System.out.println("Expected text is not obtained");
				}
				test.log(Status.INFO, "contactinformation Element is present");

			} else {
				//System.out.println("contactinformation Element is not present");
				logger.error("Expected value is not present");
				test.log(Status.FAIL, "contactinformation Element is not present");

			}
			if (PhoneNumber.isEnabled()) 
			{
				PhoneNumber.isDisplayed();
				PhoneNumber.click();
				PhoneNumber.clear();
				PhoneNumber.sendKeys(Enterphonenum);
				logger.info("Entered PhoneNumber ");
				test.log(Status.INFO, "Entered PhoneNumber");

			} else {
				System.out.println("Not Entered PhoneNumber");
				logger.error("Not Entered PhoneNumber");
				test.log(Status.FAIL, "Not Entered PhoneNumber");
			}
		} 
		public void payment() throws InterruptedException

		{
			if (verify_paymentroomcharges.isDisplayed()) {
				String paymentroom=verify_paymentroomcharges.getText();
				//System.out.println("Text obtained is" +paymentroom);
				if(paymentroom.contains("Zimmerkosten:"))
				{
					//System.out.println("Expected text is obtained");
				}
				else{

					//System.out.println("Expected text is not obtained");
				}
				test.log(Status.INFO, "paymentroomcharges Element is present");

			} else {
				//System.out.println("paymentroomcharges Element is not present");
				logger.error("Expected value is not present");
				test.log(Status.FAIL, "paymentroomcharges Element is not present");

			}


//			if (verify_paymenttaxesandfees.isDisplayed()) {
//				String paymenttaxes=verify_paymenttaxesandfees.getText();
//				//System.out.println("Text obtained is" +paymenttaxes);
//				if(paymenttaxes.contains("TAXES AND FEES:"))
//				{
//					//System.out.println("Expected text is obtained");
//				}
//				else{
//
//					//System.out.println("Expected text is not obtained");
//				}
//				test.log(Status.INFO, "Element is present");
//
//			} else {
//				//System.out.println("Element is not present");
//				logger.error("Expected value is not present");
//				test.log(Status.FAIL, "Element is not present");
//			}


			if (verify_paymentgrandtotal.isDisplayed()) {
				String paymentgrandtotal=verify_paymentgrandtotal.getText();
				System.out.println("Text obtained is"+paymentgrandtotal);
				if(paymentgrandtotal.contains("Summe:"))
				{
					System.out.println("Expected text "+paymentgrandtotal+ " is obtained");
				}
				else{

					//System.out.println("Expected text "+paymentgrandtotal+ " is not obtained");
				}
				test.log(Status.INFO, "paymentgrandtotal Element is present");

			} else {
				//System.out.println("paymentgrandtotal Element is not present");
				logger.error("Expected value is not present");
				test.log(Status.FAIL, "paymentgrandtotal Element is not present");

			}

			if (Verify_accept.isDisplayed()) {
				String termsandcondition=Verify_accept.getText();
				System.out.println("Text obtained is"+termsandcondition);
				if(termsandcondition.contains("I accept the Terms & Conditions"))
				{
					System.out.println("Expected text "+termsandcondition +" is obtained");
				}
				else{

					//System.out.println("Expected text "+termsandcondition +" is not obtained");
				}
				test.log(Status.INFO, "I accept the Terms & Conditions Element is present");

			} else {
				System.out.println("I accept the Terms & Conditions Element is not present");
				logger.error("Expected value is not present");
				test.log(Status.FAIL, "I accept the Terms & Conditions Element is not present");

			}

			if (Click_accept.isEnabled()) {
				Click_accept.isDisplayed();
				Click_accept.click();
				System.out.println("Clicked on accept checkbox");
				logger.info("Clicked on accept checkbox");
				test.log(Status.INFO, "Clicked on accept checkbox");

			} else {
				System.out.println("Not Clicked on accept checkbox");
				logger.error("Not Clicked on accept checkbox");
				test.log(Status.FAIL, "Not Clicked on accept checkbox");
			}


			if (CompleteReservation.isEnabled()) 
			{

				Javascriptexecutor(CompleteReservation);
				System.out.println("Clicked on CompleteReservation button");
				logger.info("Clicked on CompleteReservation button");
				test.log(Status.INFO, "Clicked on CompleteReservation button");

			} else {
				System.out.println("Not Clicked on CompleteReservation button");
				logger.error("Not Clicked on CompleteReservation button");
				test.log(Status.FAIL, "Not Clicked on CompleteReservation button");
			}

			SeleniumRepo.waitForPageLoaded();

			ExplicitWait(Verify_thankyou);

			if (Verify_thankyou.isDisplayed()) 
			{
				String Thankyou=Verify_thankyou.getText();
				//System.out.println("Text obtained is"+Thankyou);
				if(Thankyou.contains("Danke für Ihre Reservierung"))
				{
					System.out.println("Expected text "+Thankyou+" is obtained");
				}
				else{

					//System.out.println("Expected text is not obtained");
				}
				test.log(Status.INFO, "Thank you for your reservation Element is present");


			}
		}
}	
		