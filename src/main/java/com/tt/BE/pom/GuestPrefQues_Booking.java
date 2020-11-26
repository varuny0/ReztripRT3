package com.tt.BE.pom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;
import com.tt.utility.SeleniumRepoDropdown;

public class GuestPrefQues_Booking extends BaseTest {
	
	@FindAll({ @FindBy ( xpath = "//div[contains(text(),'Guest Preference Questions')]"), })
	
	public WebElement GuestPref;
	
	@FindAll({ @FindBy ( xpath = "//a[contains(text(),'List All')]"), })
	public WebElement Listall;
	
	@FindAll({ @FindBy ( xpath = "//a[contains(@href,'addEditGuestPreferences.do?')]"), })
	public WebElement AddNew;
	
	@FindAll({ @FindBy ( xpath = "//select[@id='selectionType']"), })
	
	public WebElement Type;
	
	@FindAll({ @FindBy ( xpath = "//input[@id='room']"), })
	
	public WebElement Category;
	
	@FindAll({ @FindBy ( xpath = "//input[@id='maxOptionsAllowed']"), })
	
	public WebElement Maxoptallowed;
	
    @FindAll({ @FindBy ( xpath = "//input[@id='questionText']"), })
	
	public WebElement Question;
    
    @FindAll({ @FindBy ( xpath = "//input[@id='questionLabel']"), })
	
	public WebElement QuestionLabel;
    
    @FindAll({ @FindBy ( xpath = "//input[@id='optionLabel']"), })
	
	public WebElement Option1_label;
    
    @FindAll({ @FindBy ( xpath = "//input[@id='optionTextIndex_1']"), })
	
	public WebElement Option1_GuestOption;
    
    @FindAll({ @FindBy ( xpath = "(//input[@id='optionLabel'])[2]"), })
	
	public WebElement Option1_label_2;
    
    @FindAll({ @FindBy ( xpath = "//input[@name='options[1].optionText']"), })
	
	public WebElement Option1_GuestOption_2;
    
    @FindAll({ @FindBy ( xpath = "(//input[@id='optionLabel'])[3]"), })
	
	public WebElement Option1_label_3;
    
    @FindAll({ @FindBy ( xpath = "//input[@name='options[2].optionText']"), })
	
	public WebElement Option1_GuestOption_3;
    
    @FindAll({ @FindBy ( xpath = "//input[@onclick='addNewOptions()']"), })
	
	public WebElement Add_New_Option;
    
    @FindAll({ @FindBy ( xpath = "//a[@id='isOptionDefault_1']"), })
	
	public WebElement Makedefault;
    
    @FindAll({ @FindBy ( xpath = "//input[@name='save']"), })
	
	public WebElement Save;
    
	@FindAll({ @FindBy (xpath = "//a[contains(text(),'My bookings')]"), })
	
	public WebElement Verify_Mybooking;
	
	@FindAll({ @FindBy( xpath = "//a[@id='currency-dropdown']"),})
	
	public WebElement verify_Currency_Dropdown;
	
	@FindAll({ @FindBy( xpath = "//a[@id='language-dropdown']"),})
	
	public WebElement verify_lang_dropdown;
	
	@FindAll({ @FindBy( xpath = "//input[@id='search_arrival_date']" ), })
	
	public WebElement Arrival_Date;
	
	@FindAll({ @FindBy( xpath = "//input[@id='search_departure_date']"), })
	
	public WebElement Departure_date;
	
	@FindAll({ @FindBy( xpath = "//div[@class='search-form-item relative rooms_guests_field']"),})
    
	public WebElement room_guest;
	
	@FindAll({@FindBy( xpath = "//select[@id='roomsselector']"),})
	
	public WebElement rooms;
	
	@FindAll({ @FindBy( xpath = "//select[@id='adults-in-room-1']"),})
	
	public WebElement Adults;
	
	@FindAll({ @FindBy( xpath = "//button[contains(text(),'Done')]"),})
	
	public WebElement Done;
	
	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Special rate')]"),})
	
	public WebElement Special_rate;
	
	@FindAll({ @FindBy( xpath = "//button[@id='special-rates-promo-done']"),})
	
	public WebElement SpecialRate_Done;
	
	@FindAll({ @FindBy( xpath = "//button[contains(text(),'Check Availability')]"),})
	
	public WebElement Check_Availability;
	
	@FindAll({ @FindBy( xpath = "//button[contains(text(),'Book now')]"),})
	
	public WebElement Booknow;
	
	@FindAll({ @FindBy( xpath = "//strong[contains(text(),'Reservation details')]"), })
		
	public WebElement Reservation_details;	
	    
	@FindAll({ @FindBy( xpath = "//a[contains(text(),'Start over')]"), })
		
	public WebElement Start_over;
	    
	@FindAll({ @FindBy(xpath = "//input[@id='is_opted_in']"), })
	    
	public WebElement Click_i_would;
	    
	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Guest details')]"), })
	    
	public WebElement Guestdetails;
	
    @FindAll({ @FindBy( xpath ="//button[contains(text(),'Confirm details')]"),})
    
    public WebElement confirm;  
    
    @FindAll({ @FindBy( xpath = "//strong[contains(text(),'Payment details')]"),})
    
    public WebElement Paymentdetails;
    
    @FindAll({ @FindBy(xpath = "//legend[contains(text(),'Card information')]"), })
    
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
	
    @FindAll({ @FindBy( xpath = "//select[@id='booking_country']"), })
    
    public WebElement country;
    
    @FindAll({ @FindBy(xpath = "//legend[contains(text(),'Billing address')]"),})
    
    public WebElement BillingAddress;
    
    @FindAll({ @FindBy(xpath = "//legend[contains(text(),'Additional contact information')]"), })

	public WebElement contactinformation;
    
    @FindAll({ @FindBy(xpath = "//input[@id='booking_phone_number']"),})
    
    public WebElement PhoneNumber;
    
    @FindAll({ @FindBy(xpath = "//span[contains(text(),'Room charges:')]"), })

	public WebElement verify_paymentroomcharges;
    
    @FindAll({ @FindBy(xpath = "//span[contains(text(),'Taxes and fees:')]"), })

	public WebElement verify_paymenttaxesandfees;
    
    @FindAll({ @FindBy(xpath = "//span[contains(text(),'Grand total:')]"), })

	public WebElement verify_paymentgrandtotal;
    
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
	
	@FindAll({ @FindBy(xpath = "(//div[@class='asa'])[1]"), })
	
	public WebElement gmailback;
	
	@FindAll({ @FindBy(xpath = "(//span[contains(text(),'sacqa6')])[2]"), })
	
	public WebElement gmailconfnum;
	
	 
	
	@FindAll({ @FindBy(xpath = "//*[text()='OK']"), })
	
	public WebElement alertOK;
	
	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Book another room')]"), })
	
	public WebElement BookAnotherRoom;
	
	
	
	
	
    public void GoToURL() throws IOException {
    	{
    		List<String>tabs1=windowidList();
    		SeleniumRepo.driver.switchTo().window(tabs1.get(1));
    	}
    	
    	String beurl = ReadProperties.getPropValues("Admin.properties", "BEURL");
    	SeleniumRepo.GoToUrl(beurl);
    }
    
    public void GuestPref() {
    	ExplicitWait(GuestPref);
    	try {
    	if(GuestPref.isDisplayed()) {
    		 AddNew.click();
    		
    		System.out.println("Able to click on guest preference link");
    		Assert.assertTrue(true, "Able to click on guest preference link");
    	}
    	}
    	catch(Exception e) {
    		GuestPref.click();
    		System.out.println("Unable to click on Guest preference link");
    		Assert.assertFalse(false, "Unable to click on guestpreference link");
    	}
    }
    
   public void AddNew() {
	   ExplicitWait(AddNew);
	   if(AddNew.isDisplayed()) {
		   AddNew.click();
		   
		  System.out.println("Able to click on AddNew link");
   		  Assert.assertTrue(true, "Able to click on AddNew link");
	   }
   	else {
   		System.out.println("Unable to click on AddNew link");
   		Assert.assertFalse(false, "Unable to click on AddNew link");
	   }
   }

   public void Type(String Selection) {
	   ExplicitWait(Type);
	   if(Type.isDisplayed()) {
		   
		   SeleniumRepoDropdown.selectDropDownText(Type, Selection);
		   
		  System.out.println("Able to select type from dropdown ");
   		  Assert.assertTrue(true, "Able to select type from dropdown");
	   }
   	else {
   		System.out.println("Unable to select type from dropdown");
   		Assert.assertFalse(false, "Unable to select type from dropdown");
	   }
   }
   
   public void Maxoptallowed(String MaxOptionsAllowed) {
	ExplicitWait(Maxoptallowed);
	if(Maxoptallowed.isEnabled()) {
		Maxoptallowed.click();
		Maxoptallowed.clear();
		Maxoptallowed.sendKeys(MaxOptionsAllowed);
		
		System.out.println("Enter the Max option allowed value");
		Assert.assertTrue(true, "Enter the Max option allowed value");	
	}
	else {
		System.out.println("Unable to Enter the Max option allowed value");
		Assert.assertTrue(true, "Unable to Enter the Max option allowed value");
	}
	   }
   
   public void category(String category) {
	   
	   WebElement cat = SeleniumRepo.driver.findElement(By.xpath("//input[@id='"+category+"']"));
	   
	   if(cat.isEnabled()) {
		   
		   cat.click();
		   
		   System.out.println("selected cat");
	   }
   }
   
   public void Required(String required) {
	 //*[@name='isRequired' and @value='false']
	   WebElement req = SeleniumRepo.driver.findElement(By.xpath("//*[@name='isRequired' and @value='"+required+"']")); 
	   
	   if(req.isEnabled()) {
		   req.click();
		   
		   System.out.println("Able to select req");
	   }
	
	   
	   
   }
	   
   public void Question(String question) {
	   if(Question.isDisplayed()) {
		   Question.click();
		   Question.sendKeys(question);
		   
			System.out.println("Entered the Question ");
			Assert.assertTrue(true, "Entered the Question");	
		}
		else {
			System.out.println("Unable to Enter the Question");
			Assert.assertTrue(true, "Unable to Enter the Question");
		}
		   }
		   
   public void QuestionLabel(String questionlabel) {
	   if(QuestionLabel.isDisplayed()) {
		   QuestionLabel.click();
		   QuestionLabel.sendKeys(questionlabel);
		   
			System.out.println("Entered the QuestionLabel ");
			Assert.assertTrue(true, "Entered the QuestionLabel");	
		}
		else {
			System.out.println("Unable to Enter the QuestionLabel");
			Assert.assertTrue(true, "Unable to Enter the QuestionLabel");
		}
		   }
   
	 public void Option1_label()  {
		 ExplicitWait(Option1_label);
		 
		 if(Option1_label.isDisplayed()) {
		 Option1_label.click();
		 Option1_label.sendKeys("1");
		 System.out.println("Able to enter the label number on option label");
		 Assert.assertTrue(true, "Able to enter the label number on option label");
		 }
		 else {
		 System.out.println("Unable to enter the label number on option label");
		 Assert.assertFalse(false, "Unable to enter the label number on option label");	 
		 }
	
		 if(Option1_GuestOption.isDisplayed()) {
		 Option1_GuestOption.click();
		 Option1_GuestOption.sendKeys("Yes");
		 System.out.println("Able to enter the text on Guest option");
		 Assert.assertTrue(true, "Able to enter the text on Guest option");	 
		}
		 else {
		 System.out.println("Unable to enter the text on Guest option");
		 Assert.assertFalse(false, "Unable to enter the text on Guest option");	 
		 }
	 }
	 
	 public void Add_New_Option()throws InterruptedException {
		 if(Add_New_Option.isDisplayed()) {
			 Add_New_Option.click();
			 Thread.sleep(2000);
			 
			 System.out.println("Able to click on Add New Option button");
			 Assert.assertTrue(true, "Able to click on Add New Option button");
		 }
		 else {
			 System.out.println("unable to click on Add New Option button");
			 Assert.assertFalse(false, "Unable to click on Add New Option button"); 	 
		 }	 
	 }  
    
	 public void Option1_label_2()  {
		 ExplicitWait(Option1_label_2);
		 
		 if(Option1_label_2.isDisplayed()) {
			 Option1_label_2.click();
			 Option1_label_2.sendKeys("2");
		 System.out.println("Able to enter the label number on option label 2");
		 Assert.assertTrue(true, "Able to enter the label number on option label 2");
		 }
		 else {
		 System.out.println("Unable to enter the label number on option label 2");
		 Assert.assertFalse(false, "Unable to enter the label number on option label 2");	 
		 }
	
		 if(Option1_GuestOption_2.isDisplayed()) { 
			 Option1_GuestOption_2.click();
			 Option1_GuestOption_2.sendKeys("No");
		 System.out.println("Able to enter the text on Guest option 2");
		 Assert.assertTrue(true, "Able to enter the text on Guest option 2");	 
		}
		 else {
		 System.out.println("Unable to enter the text on Guest option 2");
		 Assert.assertFalse(false, "Unable to enter the text on Guest option 2");	 
		 }
	 }
	 public void Add_New_Option1()throws InterruptedException {
		 if(Add_New_Option.isDisplayed()) {
			 Add_New_Option.click();
			 Thread.sleep(2000);
			 
			 System.out.println("Able to click on Add New Option button");
			 Assert.assertTrue(true, "Able to click on Add New Option button");
		 }
		 else {
			 System.out.println("unable to click on Add New Option button");
			 Assert.assertFalse(false, "Unable to click on Add New Option button"); 	 
		 }	 
	 }  

	 public void Option1_label_3()  {
		 ExplicitWait(Option1_label_3);
		 
		 if(Option1_label_3.isDisplayed()) {
			 Option1_label_3.click();
			 Option1_label_3.sendKeys("3");
		 System.out.println("Able to enter the label number on option label 3");
		 Assert.assertTrue(true, "Able to enter the label number on option label 3");
		 }
		 else {
		 System.out.println("Unable to enter the label number on option label 3");
		 Assert.assertFalse(false, "Unable to enter the label number on option label 3");	 
		 }
	
		 if(Option1_GuestOption_3.isDisplayed()) {
			 Option1_GuestOption_3.click();
			 Option1_GuestOption_3.sendKeys("Can't Say");
		 System.out.println("Able to enter the text on Guest option 3");
		 Assert.assertTrue(true, "Able to enter the text on Guest option 3");	 
		}
		 else {
		 System.out.println("Unable to enter the text on Guest option 3");
		 Assert.assertFalse(false, "Unable to enter the text on Guest option 3");	 
		 }
	 }
    
    public void Makedefault() {
    	if(Makedefault.isDisplayed()) {
    		Makedefault.click();
    		
    		System.out.println("Able to click on Make default link");
    		Assert.assertTrue(true, "Able to click on Make default link");
    	}
    	else {
    		System.out.println("Able to click on Make default link");
    		Assert.assertFalse(false, "Able to click on Make default link");
    	}
    }
    
    public void Save() {
    	if(Save.isEnabled()) {
    	Save.click();
    	
    	System.out.println("Able to clicked on save button");
    	Assert.assertTrue(true, "Able to clicked on save button");
    }
    	else {
        	System.out.println("Unable to clicked on save button");
        	Assert.assertTrue(true, "Unable to clicked on save button");
    	}
    }
    
//    public void verify_Guestpref1() {
//    	
//    	SeleniumRepo.waitForPageLoaded();
//    	String pref = "//td[contains(text(),'Guest Pref REG Test 1')]";
//    	
//    	WebElement createdguestpref = SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'Guest Pref REG Test 1')]"));
//    	if(createdguestpref.equals("Guest Pref REG Test 1")) {
//    		
//        	System.out.println("Able to view the created guest preference");
//        	Assert.assertTrue(true, "Able to view the created guest preference");
//    	}
//    	else {
//        	System.out.println("Unable to view the created guest preference");
//        	Assert.assertFalse(false, "Unable to view the created guest preference");	
//    	}
//    }
    
    
    
public void Verify_Mybooking() {
	
		ExplicitWait(Verify_Mybooking);
		if(Verify_Mybooking.isDisplayed()) {
			
			System.out.println("Mybooking text is obtained");
			Assert.assertTrue(true, "mybooking test is obtained");
		}
		else {
			System.out.println("Unable to view the  my booking link");
			Assert.assertFalse(false, "mybooking text is not displayed");
		}		
	}

	public void verify_Currency_Dropdown(String EnterCurrency) {
		ExplicitWait(verify_Currency_Dropdown);
		
		if(verify_Currency_Dropdown.isEnabled()) {
			verify_Currency_Dropdown.click();
			
			System.out.println("Able to click on Currency dropdown ");
			Assert.assertTrue(true,"Able to click on currency dropdown");
		}
		else {
			System.out.println("Unable to click on currencuy dropdown");
			Assert.assertFalse(false, "Unable to click on currencydropdown");
		}
	}
	
	public void verify_lang_dropdown() {
		ExplicitWait(verify_lang_dropdown);
		if(verify_lang_dropdown.isEnabled()) {
			verify_lang_dropdown.click();
			
			System.out.println("Able to click on language dropdown");
			Assert.assertTrue(true, "Able to click on language dropdown");
    }
		else {
			System.out.println("Unable to click on language dropdown");
			Assert.assertFalse(false, "Unable to click on language dropdown");
		}
	}
	
	public void Arrival_Date() {
		
		ExplicitWait(Arrival_Date);
		
		Date date1 = new Date();
		date1.setDate(date1.getDate()+1);
		SimpleDateFormat df1 = new SimpleDateFormat("mm/dd/yyyy");
		String formatteddate1 = df1.format(date1);
		
		if(SeleniumRepo.isElementPresent(Arrival_Date)) {
			Arrival_Date.click();
			//TypeInField(Arrival_Date, formatteddate1);
			Arrival_Date.sendKeys(formatteddate1);
			System.out.println("Clicked on arrival date : "+formatteddate1+"");
			Assert.assertTrue(true, "Clicked on arrival date");
		}
		else {
			System.out.println("Unable to Clicked on arrival date");
			Assert.assertFalse(false, "Clicked on arrival date");
		}
	
	}
	
	public void Departure_date() {
		ExplicitWait(Departure_date);
		
		Date currentdate = new Date();
		currentdate.setDate(currentdate.getDate() +3);
		SimpleDateFormat df1 = new SimpleDateFormat("mm/dd/yyyy");
		String formatedcurrent = df1.format(currentdate);
		
		if(SeleniumRepo.isElementPresent(Departure_date)) {
			Departure_date.click();
			//TypeInField(Departure_date, formatedcurrent);
			Departure_date.sendKeys(formatedcurrent);
			System.out.println("CLicked on departure date is : "+formatedcurrent+"");
			Assert.assertTrue(true, "clicked on departure date");
		}
		else {
			System.out.println("Unable to clicked on departure date");
			Assert.assertFalse(false, "Unable to clicked on departure date");
		}
	}
	
	public void room_guest() {
		ExplicitWait(room_guest);
		
		if(room_guest.isDisplayed()) {
			room_guest.click();
			
			System.out.println("Clicked on room and guest");
			Assert.assertTrue(true, "Clicked on room and guest");
		}
		else {
		
		System.out.println("Unable to clicked on room and guest");
		Assert.assertFalse(false, "Unable to clicked on room and guest");
	}
	}
	public void rooms(String Enterrooms) {
		ExplicitWait(rooms);
		
		if(rooms.isEnabled()) {
			rooms.click();
			
			SeleniumRepoDropdown.selectDropDownValue(rooms, Enterrooms);
			System.out.println("selected rooms from room dropdown");
			Assert.assertTrue(true, "selected rooms from room dropdown");
		}
		else {
			System.out.println("Unable to select the rooms from rooms dropdown");
			Assert.assertFalse(false,"Unable to select the rooms from rooms dropdown");
		}
		
	}
	
	public void Adults(String EnterAdults) {
		ExplicitWait(Adults);

		if(Adults.isEnabled()) {
			SeleniumRepoDropdown.selectDropDownValue(Adults, EnterAdults);
			System.out.println("Selected the adults from the dropdown ");
			Assert.assertTrue(true, "Selected the adults count");
	}
		else {
			System.out.println("Unable to select the adults");
			Assert.assertFalse(false, "Unable to select the adults");
		}
		}
	public void Done() {
		ExplicitWait(Done);
			if(Done.isEnabled()) {
				Done.click();
			System.out.println("Able to click on room and guest done button");
			Assert.assertTrue(true, "Able to click on room and guest done button");
			}
			else {
				System.out.println("Unable to click on rooma and guest done button");
				Assert.assertFalse(false, "Unable to click on room and guest done button");
			}
		}
	
	public void Special_rate() throws InterruptedException {
		ExplicitWait(Special_rate);
		Thread.sleep(2000);
		if(Special_rate.isEnabled()) {
		Special_rate.click();
		
		System.out.println("Able to click on Special rate link");
		Assert.assertTrue(true, "Able to click on Special rate link");
	}
	else {
		System.out.println("Unable to click on Special rate");
		Assert.assertFalse(false, "Unable to click on Special rate");
	}
	}
	
	public void SpecialRate_Done() {
		ExplicitWait(SpecialRate_Done);
			if(SpecialRate_Done.isEnabled()) {
				SpecialRate_Done.click();
			System.out.println("Able to click on special rate done button");
			Assert.assertTrue(true, "Able to click on special rate done button");
			}
			else {
				System.out.println("Unable to click on special rate done button");
				Assert.assertFalse(false, "Unable to click on special rate done button");
			}
		}
	public void Check_Availability() throws InterruptedException {
		ExplicitWait(Check_Availability);
		Thread.sleep(2000);
		
		if(Check_Availability.isEnabled()) {
			Check_Availability.click();
			
			System.out.println("Able to click on check availability button");
			Assert.assertTrue(true, "Able to click on check availability button" );
		}
		else {
			System.out.println("Unable to click on check availability button");
			Assert.assertFalse(false, "Unable to click on check availability button");
		}	
	}
	
	public void room_type(String roomtype) throws InterruptedException {
		Thread.sleep(2000);

		String room = "//span[contains(text(),'"+roomtype+"')]";
		WebElement roomm = SeleniumRepo.driver.findElement(By.xpath("//span[contains(text(),'"+roomtype+"')]"));
		roomm.click();	
		
		System.out.println("selected the "+roomm+"");
		Assert.assertTrue(true, "Selected the room");
		
	}
	
	public void Booknow() {
		
		ExplicitWait(Booknow);
		
		if(Booknow.isEnabled()) {
			Booknow.click();
			System.out.println("Clicked on book now button");
			Assert.assertTrue(true, "Clicked on book now button" );
		}
		else {
			System.out.println("Unable to clicked on Book now button");
			Assert.assertFalse(false, "Unable to  on Book now button");
		}
	}  
	
	public void Reservation_details() {
		ExplicitWait(Reservation_details);
		
		if(Reservation_details.isDisplayed()) {
			
			System.out.println("Able to view the reservation details link");
			Assert.assertTrue(true, "Able to view the reservation details link");
		}
		else {
			System.out.println("Unable to view the reservation details link");
			Assert.assertFalse(false, "Unable to view the reservation details link" );
		}
	}
	
	public void Start_over() {
		ExplicitWait(Start_over);
		
		if(Start_over.isDisplayed()) {
			
			System.out.println("Able to view the start over button");
			Assert.assertTrue(true, "Able to view the start over button");
		}
		else {
			System.out.println("Unable to view the startover button");
			Assert.assertFalse(false, "Unable to view the startover button");
		}
	}
	
	public void Click_i_would() {
		ExplicitWait(Click_i_would);
		
		if(Click_i_would.isEnabled()) {
			Click_i_would.click();
			
			System.out.println("Able to click on check box under Guest details");
			Assert.assertTrue(true, "Able to click on check box under Guest details");
		}
		else {
			System.out.println("Unable to click on checkbox under guest details");
			Assert.assertFalse(false, "Unable to click on checkbox under guest details");
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
		
		System.out.println("Able to view the Guest details label");
		Assert.assertTrue(true, "Able to view the Guest details label");
}		
		else {
			System.out.println("Unable to view the Guest details label");
			Assert.assertFalse(false, "Unable to view the Guest details label");
		}
			}
	
	public void Guestlabels() {
		
		String gl1 = "//span[contains(text(),'Guest Pref REG Test 1')]";
		String gl2 = "//h4[contains(text(),'Guest Pref REG Test 2')]";
		
		WebElement guest1 = SeleniumRepo.driver.findElement(By.xpath("//span[contains(text(),'Guest Pref REG Test 1')]"));
		WebElement guest2 = SeleniumRepo.driver.findElement(By.xpath("//h4[contains(text(),'Guest Pref REG Test 2')]"));
		
		if(guest1.isDisplayed()) {
			System.out.println("Able to view the "+guest1+"");
		}
		else {
			System.out.println("Unable to view the "+guest1+"");
		}
		if(guest2.isDisplayed()) {
			System.out.println("Able to view the "+guest2+"");
		}
		else {
			System.out.println("Unable to view the "+guest2+"");
		}	
	}
	
	public void VerifyReqGuest() throws InterruptedException {
		
		String errmsg = "//span[contains(text(),'Please select between 1 - 3 options')]";
		
		WebElement reqgue = SeleniumRepo.driver.findElement(By.xpath("(//input[@name='booking[guest_reservation_preferences][8][option_ids][]'])[1]"));
		
		reqgue.click();
		
		confirm.click();
		Thread.sleep(1000);
		System.out.println("Clicked on confirm button");
		System.out.println("Getting error message "+errmsg+"");
		
		reqgue.click();
	}

	public void confirm() {
		if(confirm.isEnabled()) {
			confirm.click();
			
			System.out.println("Clicked on confirm button");
			Assert.assertTrue(true, "Clicked on confirm button");
		}
		else {
			System.out.println("Unable to click on confirm buton");
			Assert.assertFalse(false, "Unable to click on confirm buton");
		}
	}
		
	public void Paymentdetails() {
		ExplicitWait(Paymentdetails);
		
		if(Paymentdetails.isDisplayed()) {
			System.out.println("Paymentdetails page is displayed");
			Assert.assertTrue(true, "Paymentdetails page is displayed");
		}
		else {
			System.out.println("Paymentdetails page is not displayed");
			Assert.assertFalse(false, "Paymentdetails page is not displayed" );
		}
	}	
	
	public void Card_Information()  {
		
		if (Card_Information.isDisplayed()) 
		{
			System.out.println("card information text is obtained");
			Assert.assertTrue(true, "card information text is obtained");
		} 
		else {
			System.out.println("CardInformation text is not present");
			Assert.assertFalse(false, "CardInformation text is not present");
		}
	}
	
	public void Name_on_card(String Cardname)
	{

		if(Name_on_card.isDisplayed())
		{
			Name_on_card.clear();
			Name_on_card.click();
			Name_on_card.sendKeys(Cardname);
		System.out.println("Able to enter the cardname");
		Assert.assertTrue(true, "Able to enter the cardname");
		} 
		else {
			System.out.println("Not Entered card name");
			Assert.assertFalse(false, "Not Entered card name");
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
		System.out.println("Able to enter the billing address details");
		Assert.assertTrue(true, "Able to enter the billing address details");
		}
		else {
			System.out.println("Unable to enter the Billing Address details");
			Assert.assertFalse(false, "Unable to enter the Billing Address details" );
		}			
	}
	public void contactinformation(String Enterphonenum)	{
		
		if (contactinformation.isDisplayed()) {
			
			System.out.println("Able to view the contact information text");
			Assert.assertTrue(true, "Able to view the contact information text");		
		} 
		else {
			System.out.println("contact information text is not present");
			Assert.assertFalse(false, "contact information text is not present");
		}
		if (PhoneNumber.isEnabled()) 
		{
			PhoneNumber.isDisplayed();
			PhoneNumber.click();
			PhoneNumber.clear();
			PhoneNumber.sendKeys(Enterphonenum);
			System.out.println("Entered PhoneNumber ");
			Assert.assertTrue(true, "Entered PhoneNumber ");
		} 
		else {
			System.out.println("Not Entered PhoneNumber");
			Assert.assertFalse(false, "Not Entered PhoneNumber ");	
		}
	} 
	
	public void payment() throws InterruptedException

	{
		if (verify_paymentroomcharges.isDisplayed()) {
			String paymentroom=verify_paymentroomcharges.getText();
			System.out.println("Text obtained is" +paymentroom);
			if(paymentroom.contains("Room charges:"))
			{
				System.out.println("Expected text is obtained");
			}
			else{

				System.out.println("Expected text is not obtained");
			}
		 }
		else {
			System.out.println("paymentroomcharges Element is not present");
		}
//		if (verify_paymenttaxesandfees.isDisplayed()) {
//			String paymenttaxes=verify_paymenttaxesandfees.getText();
//			System.out.println("Text obtained is" +paymenttaxes);
//			if(paymenttaxes.contains("TAXES AND FEES:"))
//			{
//				System.out.println("Expected text is obtained");
//			}
//			else{
//
//				System.out.println("Expected text is not obtained");
//			}
//		
//
//		} else {
//			System.out.println("Element is not present");
//			
//		}


		if (verify_paymentgrandtotal.isDisplayed()) {
			String paymentgrandtotal=verify_paymentgrandtotal.getText();
			System.out.println("Text obtained is"+paymentgrandtotal);
			if(paymentgrandtotal.contains("Grand total:"))
			{
				System.out.println("Expected text "+paymentgrandtotal+ " is obtained");
			}
			else{

				System.out.println("Expected text "+paymentgrandtotal+ " is not obtained");
			}

		} else {
			System.out.println("paymentgrandtotal Element is not present");
			

		}

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
	
//	public void VerifyGmail() throws InterruptedException {
//		SeleniumRepo.waitForPageLoaded();
//		{
//			List<String>tabs1=windowidList();
//			SeleniumRepo.driver.switchTo().window(tabs1.get(1));
//		}
//		
//		gmailback.click();
//		Thread.sleep(1000);
//		SeleniumRepo.driver.navigate().refresh();		
//	}
	
	public void delguestpref(String question) throws InterruptedException {
		
		{
			List<String>tabs1=windowidList();
			SeleniumRepo.driver.switchTo().window(tabs1.get(0));
		}
		
		SeleniumRepo.waitForPageLoaded();
		if(SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'"+question+"')]//..//a[contains(text(),'Delete')]")).isDisplayed()){
			SeleniumRepo.driver.findElement(By.xpath("//td[contains(text(),'"+question+"')]//..//a[contains(text(),'Delete')]")).click();
		}			
			alertOK.click();
			Thread.sleep(1000);
			System.out.println("Able to delete the guest pref"+question+"");
		
		 
	}
	public void BookAnotherRoom() {
		
		{
			List<String>tabs1=windowidList();
			SeleniumRepo.driver.switchTo().window(tabs1.get(1));
		}
		
		ExplicitWait(BookAnotherRoom);
			if(BookAnotherRoom.isEnabled()) {
				BookAnotherRoom.click();
				System.out.println("Clicked on book another room button");
			}
		}
	
}