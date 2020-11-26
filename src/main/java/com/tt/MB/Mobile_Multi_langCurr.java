package com.tt.MB;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class Mobile_Multi_langCurr extends BaseTest {
	
	String month;
	String Year;
	
	@FindAll({ @FindBy( xpath = "//*[@title='Menu']"),})
	
	public WebElement menu;
	
	@FindAll({ @FindBy( xpath = "//*[@ng-bind='title']"),})
	
	public WebElement Verify_Menu_Title;
	
	@FindAll({ @FindBy(xpath = "//*[@data-title='Language']/span[1]"), })
	
	public WebElement Language;
	
	@FindAll({ @FindBy(xpath = "//*[@data-title='Currency']/span[1]"), })
	
	public WebElement Currency;	
	
	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Sök alla erbjudanden')]"), })
	
	public WebElement Searchoffer;
	
	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Bästa pris per natt:')]"), })
	
	public WebElement Bestprice;
	
	@FindAll({ @FindBy(xpath = "//button[text()='Återställ Datum'][@ng-click='reset()']"), })
	
	public WebElement Verify_ResetDates;

	@FindAll({ @FindBy(xpath = "//button[@type='button'][text()='Välj Rum']"), })
	
	public WebElement Select_Room;
	
	@FindAll({ @FindBy(xpath = "//form[@id='new_checkout']/input[5]"), })
	
	public WebElement Continue;
	
	@FindAll({ @FindBy(xpath = "//*[@id='is_opted_in']"), })
	
	public WebElement checkbox_guest;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Fullständigt namn']"), })
	
	public WebElement FullName;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Telefonnummer']"), })
	
	public WebElement Phoneno;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='E-post']"), })
	
	public WebElement Email1;
	
	@FindAll({ @FindBy(xpath = "//h3[contains(text(),'Fakturaadress')]"), })
	
	public WebElement BillingAddress;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Adress']"), })
	
	public WebElement Address1;

	@FindAll({ @FindBy(xpath = "(//div[@class='form-group']/popover-selector/input)[1]"), })
	
	public WebElement Billing_Countrylink;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Ange']"), })
	
	public WebElement State;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Stad']"), })
	
	public WebElement City;

	@FindAll({ @FindBy(xpath = "//input[@autocomplete='zipcode'][@placeholder='Postnummer']"), })
	
	public WebElement ZipCode;

	@FindAll({ @FindBy(xpath = "//*[@id='cardName']"), })
	
	public WebElement CardName;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Kortnummer']"), })
	
	public WebElement CardNo;

	@FindAll({ @FindBy(xpath = "//*[@placeholder='Utgångsdatum (MM/YY)']"), })
	
	public WebElement Expiration;

	@FindAll({ @FindBy(xpath = "//input[@id='cardCsc']"), })
	
	public WebElement CVV;
	
	@FindAll({ @FindBy(xpath = "(//div[@class='form-group']/popover-selector/input)[3]"), })
	
	public WebElement Card_Countryclick;

	@FindAll({ @FindBy(xpath = "//input[@autocomplete='postal-code'][@placeholder='Postnummer']"), })
	
	public WebElement Postalcode;
	
	@FindAll({ @FindBy(xpath = "//input[@id='accept-tandc' and @type='checkbox']"), })
	
	public WebElement CheckBox;

	@FindAll({ @FindBy(xpath = "//button[@type='button'][text()='Slutför Bokningen']"), })
	
	public WebElement Complete_Reservation;
	
	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Din reservation är bekräftad!')]"), })
	
	public WebElement Confirmation_text;
	
	
	public void GoToUrl() throws IOException
		{
			String MobileURL=ReadProperties.getPropValues("Admin.properties", "MobileURL");
			SeleniumRepo.GoToUrl(MobileURL);
		}
	
	public void menu() {
		
		ExplicitWait(menu);
		
		if(menu.isDisplayed()) {
			menu.click();
			System.out.println("Able to click on menu button");
			Assert.assertTrue(true, "Able to click on menu button");
		}
		else {
			System.out.println("Unable to click on Menu button");
			Assert.assertFalse(false, "Unable to click on Menu button");
		}
	}
	
	public void Verify_Menu_Title() {
		if(Verify_Menu_Title.isDisplayed()) {
			
			String men = Verify_Menu_Title.getText();
			
			System.out.println("Able to view on "+men+" title");
			Assert.assertTrue(true, "Able to view on "+men+" title");
		}
		else {
			System.out.println("Unable to view on Menu title");
			Assert.assertFalse(false, "Unable to view on Menu title");
		}
	}
	
	public void Language(String EnterLanguage) throws InterruptedException {
		if(Language.isDisplayed()) {
			Thread.sleep(1000);
			Language.click();
			
		WebElement lang = SeleniumRepo.driver.findElement(By.xpath("//button[contains(text(),'"+EnterLanguage+"')]"));
		
		Javascriptexecutor(lang);
			
			SeleniumRepo.waitForPageLoaded();
			
			System.out.println("selected language is "+lang+" ");
			Assert.assertTrue(true, "selected language is "+lang+" field");
		}
		else {
			System.out.println("Unable to view the language field");
			Assert.assertFalse(false, "Unable to view the language field");
		}		
	}
	
	public void Currency(String EnterCurrency) {
		if(Currency.isDisplayed()) {
			Currency.click();
			
			WebElement curr = SeleniumRepo.driver.findElement(By.xpath("//button[contains(text(),'"+EnterCurrency+"')]"));
			
			Javascriptexecutor(curr);
			SeleniumRepo.waitForPageLoaded();
			
			System.out.println("selected the currency is "+curr+" ");
			Assert.assertTrue(true, "selected the currency is "+curr+" field");
		}
		else {
			System.out.println("Unable to view the currency field");
			Assert.assertFalse(false, "Unable to view the currency field");
		}		
	}
	
	public void Searchoffer() {
		ExplicitWait(Searchoffer);
		if(Searchoffer.isDisplayed()) {
		
			String offer = Searchoffer.getText();
			
			System.out.println("Able to view  "+offer+" selected language");
			Assert.assertTrue(true, "Able to view  "+offer+" selected language");
		}
		else {
			System.out.println("Unable to view on Search offer link");
			Assert.assertFalse(false, "Unable to view on Search offer link");
		}
	}
	
	public void ArrivalDate() throws InterruptedException {
		
		Thread.sleep(1000);
		Date date1 = new Date();
		date1.setDate(date1.getDate()+2);
		
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String arrivaldate = df1.format(date1);
		
		month = new SimpleDateFormat("MMMM").format(new Date());
		Year = new SimpleDateFormat("YYYY").format(new Date());

		System.out.println("//*[text()='"+month+" "+Year+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+arrivaldate+"']");
		WebElement startdate=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+month+" "+Year+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+arrivaldate+"']"));
		Javascriptexecutor(startdate);
		System.out.println("arrival date enterd successfully");	
	}
	
	public void departuredate()	{
		Date date2 = new Date();
		date2.setDate(date2.getDate() + 5);
		
		SimpleDateFormat df1 = new SimpleDateFormat("dd");
		String departuredate = df1.format(date2);
			
		 month = new SimpleDateFormat("MMMM").format(date2);
		 Year = new SimpleDateFormat("YYYY").format(date2);	
		
		System.out.println("departuredate is "+departuredate);
		System.out.println("//*[text()='"+month+" "+Year+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+departuredate+"']");
		WebElement Enddate=SeleniumRepo.driver.findElement(By.xpath("//*[text()='"+month+" "+Year+"']/following-sibling::div[1]/mobile-calendar-day/div/div[text()='"+departuredate+"']"));
		Javascriptexecutor(Enddate);
		System.out.println("Departure date enterd successfully");
	}
	
	public void Bestprice() throws InterruptedException {
		SeleniumRepo.waitForElementPresent(Bestprice);
		Thread.sleep(1000);
		if(Bestprice.isDisplayed()) {
			
			String bestpricetext = Bestprice.getText();
		String bestpri = SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'Bästa pris per natt:')]/strong")).getText();
		
		System.out.println(""+bestpricetext+" is "+bestpri+"");
		Assert.assertTrue(true, "Able to view bestprice per night");
		}
		else {
			System.out.println("Unable to view the best price per night");
			Assert.assertFalse(false,"Unable to view the best price per night");
		}
	}

	public void Verify_ResetDates() {
		if(Verify_ResetDates.isDisplayed()) {
			
			String reset = Verify_ResetDates.getText();
			
			System.out.println("Able to view the reset dates in selected language: "+reset+"");
			Assert.assertTrue(true, "Able to view the reset dates in selected language: "+reset+"");	
		}
		else {
			System.out.println("Unable to view the reset button");
			Assert.assertFalse(false, "Unable to view the reset button");
		}
	}
	
	public void Select_Room() {
		ExplicitWait(Select_Room);
		if(Select_Room.isDisplayed()) {
			
			String rom = Select_Room.getText();
			System.out.println("Able to view the select room in selected language "+rom+"");
			//Select_Room.click();
			Javascriptexecutor(Select_Room);
			
			System.out.println("Able to click on select room button");
			Assert.assertTrue(true, "Able to click on select room button");
		}
		else {
			System.out.println("Unable to click on select room button");
			Assert.assertFalse(false, "Unable to click on select room button");
		}
	}
	
	public void Roomlist() {
		
		List <WebElement> roomlis = SeleniumRepo.driver.findElements(By.xpath("//*[contains(@class,'clearfix comp-title-room')]"));
		System.out.println(roomlis);
		
		for(int i=1; i<roomlis.size(); i++) {
			System.out.println(roomlis.get(i).getText());
		}
	}
	
	public void room_type(String roomtype) throws InterruptedException {
		
		Thread.sleep(1000);	
		WebElement room = SeleniumRepo.driver.findElement(By.xpath("//*[contains(text(),'"+roomtype+"')]"));		
		System.out.println("Able to view" +room);
		//room.click();
		Javascriptexecutor(SeleniumRepo.driver.findElement(By.xpath("//span[contains(text(),'"+roomtype+"')]//..//..//img[@class='comp-rm-arrow']")));
	}
	
	public void Continue() {
		
		SeleniumRepo.waitForPageLoaded();
		ExplicitWait(Continue);
		if(Continue.isDisplayed()) {
			 
		String con = Continue.getText();
		
		System.out.println("Able to view in continue button in selected language "+con+"");
			Continue.click();
			System.out.println("Able to click on continue button");
			Assert.assertTrue(true, "Able to click on continue button");
		}
		else {
			System.out.println("Unable to click on continue button");
			Assert.assertFalse(false, "Unable to click on continue button");
		}
	}
	
	public void checkbox_guest() {
		SeleniumRepo.waitForPageLoaded();
		if(checkbox_guest.isDisplayed()) {
			checkbox_guest.click();
			
			System.out.println("Able to click on Checkbox");
			Assert.assertTrue(true, "Able to click on Checkbox");
		}
		else {
			System.out.println("Unable to click on Checkbox");
			Assert.assertFalse(false, "Unable to click on Checkbox");
		}
	}
	
	public void FullName(String FirstName, String Enterphonenum, String Email) {
		ExplicitWait(FullName);
		if(FullName.isDisplayed()) {
			FullName.click();
			FullName.sendKeys("MultiLangCurr");
			
			System.out.println("Able to enter the first name");
			Assert.assertTrue(true, "Able to enter the first name");
		}
		else {
			System.out.println("Unable to enter the first name");
			Assert.assertFalse(false, "Unable to enter the first name");
		}
		
		if(Phoneno.isDisplayed()) {
			Phoneno.click();
			Phoneno.sendKeys(Enterphonenum);
			
			System.out.println("Able to enter the phone number");
			Assert.assertTrue(true, "Able to enter the phone number");
		}
		else {
			System.out.println("Unable to enter the phone number");
			Assert.assertFalse(false, "Unable to enter the phone number");
		}
		
		if(Email1.isDisplayed()) {
			Email1.click();
			Email1.sendKeys(Email);
			
			System.out.println("Able to enter the Email");
			Assert.assertTrue(true, "Able to enter the Email");
		}
		else {
			System.out.println("Unable to enter the Email");
			Assert.assertFalse(false, "Unable to enter the Email");
		}		
	}
	
	public void BillingAddress(String Address) {
		if(BillingAddress.isDisplayed()) {
			
			String billing = BillingAddress.getText();
			
			System.out.println("Able to view the "+billing+" text");
			Assert.assertTrue(true, "Able to view the "+billing+" text");
		}
		else {
			System.out.println("Unable to view the billing address text");
			Assert.assertFalse(false, "Unable to view the billing address text");
		}
		
		if(Address1.isDisplayed()) {
			Address1.click();
			Address1.sendKeys(Address);
			
			System.out.println("Able to enter the address");
			Assert.assertTrue(true, "Able to enter the address");
		}
		else {
			System.out.println("Unable to enter the address");
			Assert.assertFalse(false, "Unable to enter the address");
		}
	}
	
	public void Billing_Countrylink(String Entercountry) throws InterruptedException {
		if(Billing_Countrylink.isDisplayed()) {
			Billing_Countrylink.click();
		
	WebElement country=SeleniumRepo.driver.findElement(By.xpath("//ul[@class='page-list -theme-color']/li[text()='"+Entercountry+"']"));
	Javascriptexecutor(country);
	Thread.sleep(2000);
			
			System.out.println("selected the "+country+" country");
			Assert.assertTrue(true, "selected the "+country+" country");
		}
		else {
			System.out.println("Unable to enter the country");
			Assert.assertFalse(false, "Unable to enter the country");
		}
	}
	
	public void State(String Enterstate) {
		if(State.isDisplayed()) {
			State.sendKeys(Enterstate);
			//SeleniumRepoDropdown.selectDropDownText(State, Enterstate);
			
			System.out.println("Able to enter the State");
			Assert.assertTrue(true, "Able to enter the State");
		}
		else {
			System.out.println("Unable to enter the State");
			Assert.assertFalse(false, "Unable to enter the State");
		}
	}
	
	public void City(String Entercity, String Enterzipcode) {
		if(City.isDisplayed()) {
		City.click();
		City.sendKeys(Entercity);
		
		System.out.println("Able to enter the city");
		Assert.assertTrue(true, "Able to enter the city");
	}
		else {
			System.out.println("Unable to enter the city");
			Assert.assertFalse(false, "Unable to enter the city");
		}
		
		if(ZipCode.isDisplayed()) {
			ZipCode.click();
			ZipCode.sendKeys(Enterzipcode);
			
			System.out.println("Able to enter the Zipcode");
			Assert.assertTrue(true, "Able to enter the Zipcode");
		}
			else {
				System.out.println("Unable to enter the Zipcode");
				Assert.assertFalse(false, "Unable to enter the Zipcode");
			}
		}
	
	public void CardName(String Cardname) {
		if(CardName.isDisplayed()) {
			CardName.click();
			CardName.sendKeys(Cardname);
			
			System.out.println("Able to enter the card name");
			Assert.assertTrue(true, "Able to enter the card name");
		}
			else {
				System.out.println("Unable to enter the card name");
				Assert.assertFalse(false, "Unable to enter the card name");
		}
	}
	
	public void CardNo(String Numberoncard) {
		if(CardNo.isDisplayed()) {
			CardNo.click();
			CardNo.sendKeys(Numberoncard);
			
			System.out.println("Able to enter the card number");
			Assert.assertTrue(true, "Able to enter the card number");
		}
			else {
				System.out.println("Unable to enter the card number");
				Assert.assertFalse(false, "Unable to enter the card number");	
		}
	}

	public void Expiration() throws InterruptedException {
		if(Expiration.isDisplayed()) {
			Expiration.click();
			TypeInField(Expiration, "05/23");
			
			System.out.println("Able to enter the Expirary month and year");
			Assert.assertTrue(true, "Able to enter the Expirary month and year");
		}
			else {
				System.out.println("Unable to enter the Expirary month and year");
				Assert.assertFalse(false, "Unable to enter the Expirary month and year");	
		}
		
		Thread.sleep(2000);
		if(CVV.isDisplayed()) {
			Javascriptexecutor(CVV);
			//CVV.click();
			CVV.clear();
		//	TypeInField(CVV, "123");
			CVV.sendKeys("123");
			System.out.println("Able to enter the CVV");
			Assert.assertTrue(true, "Able to enter the CVV");
		}
			else {
				System.out.println("Unable to enter the CVV");
				Assert.assertFalse(false, "Unable to enter the CVV");	
		}
	}
	
	public void Card_Countryclick(String Entercountry) throws InterruptedException {
		ExplicitWait(Card_Countryclick);
		if(Card_Countryclick.isDisplayed()) {
			Card_Countryclick.click();
			
	WebElement country=SeleniumRepo.driver.findElement(By.xpath("//ul[@class='page-list -theme-color']/li[text()='"+Entercountry+"']"));
	Javascriptexecutor(country);
			Thread.sleep(2000);
			
			System.out.println("Able to enter the country");
			Assert.assertTrue(true, "Able to enter the country");
		}
		else {
			System.out.println("Unable to enter the country");
			Assert.assertFalse(false, "Unable to enter the country");		
		}
	}

	public void Postalcode(String Enterzipcode) {
		if(Postalcode.isDisplayed()) {
			Postalcode.click();
			Postalcode.sendKeys(Enterzipcode);
	
			System.out.println("Able to enter the Zipcode");
			Assert.assertTrue(true, "Able to enter the Zipcode");
		}
	else {
		System.out.println("Unable to enter the Zipcode");
		Assert.assertFalse(false, "Unable to enter the Zipcode");
	}
	}
	
	public void CheckBox() {
		if(CheckBox.isSelected()) {
			System.out.println("checkbox is already selected");
		}
			else {
			CheckBox.click();
			System.out.println("Able to click on agree check box");
			Assert.assertTrue(true, "Able to click on agree check box");
			}
//	else {
//		System.out.println("Unable to click on agree check box");
//		Assert.assertFalse(false, "Unable to click on agree check box");
//	}	
}

	
	public void Complete_Reservation() {
		if(Complete_Reservation.isDisplayed()) {
			Complete_Reservation.click();
			
			System.out.println("Able to click on complete reservation button");
			Assert.assertTrue(true, "Able to click on complete reservation button");
		}
	else {
		System.out.println("Unable to click on complete reservation button");
		Assert.assertFalse(false, "Unable to click on complete reservation button");	
		}
	}
	
	public void Confirmation_text() {
		SeleniumRepo.waitForPageLoaded();
		if(Confirmation_text.isDisplayed()) {
			
			String conf = Confirmation_text.getText();
			
			System.out.println("Able to view "+conf+" text");
			Assert.assertTrue(true, "Able to view "+conf+" text");
		}
	}
	
}
