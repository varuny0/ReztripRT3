package com.tt.MB_Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.MultiProperty;
import com.tt.MB.MobileBooking;
import com.tt.MB.Mobile_Modify_Email;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Mobile_Modify_Email extends BaseTest{

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "MobileBooking");

		return (testObjArray);
	}
	
	@Test(dataProvider = "dataSupplier")
	public void Flow(HashMap<String, String> h2) throws InterruptedException, IOException, ParseException {

		MobileBooking  mobile = PageFactory.initElements(SeleniumRepo.driver, MobileBooking.class);
 		
		String roomtype = h2.get("roomtype").toString().trim();
		String FirstName = h2.get("FirstName").toString().trim();
		String Email = h2.get("Email").toString().trim();
		String Cardname = h2.get("Cardname").toString().trim();
		String Numberoncard = h2.get("Numberoncard").toString().trim();
		String Entercountry = h2.get("Entercountry").toString().trim();
		String Address = h2.get("Address").toString().trim();
		String Entercity = h2.get("Entercity").toString().trim();
		String Enterstate = h2.get("Enterstate").toString().trim();
		String Enterzipcode = h2.get("Enterzipcode").toString().trim();
		String Enterphonenum = h2.get("Enterphonenum").toString().trim();
		
		mobile.GoToUrl();
		mobile.popup_ok();
		mobile.Menu();
		mobile.Verify_language();
		mobile.close();
		mobile.arrivaldate();
		mobile.departuredate();
		mobile.Verify_Bestprice();
		mobile.verify_ResetButton();
		mobile.Select_Room();
		mobile.RoomLink(roomtype);
		mobile.verify_Room_date_Readmore(roomtype);
		mobile.Bar_radio();
		mobile.Click_Continue();
		mobile.First_name(FirstName);
		mobile.Checkbox();
		mobile.PhoneNumber(Enterphonenum);
		mobile.Email(Email);
		mobile.Address(Address);
		mobile.Country(Entercountry);
		mobile.State(Enterstate);
		mobile.City(Entercity);
		mobile.Zipcode(Enterzipcode);
		mobile.Cardname(Cardname);
		mobile.CardNo(Numberoncard);
		mobile.Expdate();
		mobile.CVV();
		mobile.Payment_Country(Entercountry);
		mobile.postalcode(Enterzipcode);
		mobile.agree();
		mobile.confirmationcode();
	
//		List<String>tabs1=windowidList();
//		SeleniumRepo.driver.switchTo().window(tabs1.get(1));
		
//		ArrayList<String> tabs2 = new ArrayList<String> (SeleniumRepo.driver.getWindowHandles());
//		SeleniumRepo.driver.switchTo().window(tabs2.get(1));
//		SeleniumRepo.driver.close();
//		SeleniumRepo.driver.switchTo().window(tabs2.get(0));
		
		String confcode = MobileBooking.code;
		System.out.println("The confirmation code is" +confcode);
		
		SeleniumRepo.driver.navigate().back();
		SeleniumRepo.driver.navigate().refresh();
		Thread.sleep(1000);
	}
		@Test(dataProvider = "dataSupplier")
		
		public void flow(HashMap<String, String> h1) throws IOException, InterruptedException {
			
			Mobile_Modify_Email  mobileemail =PageFactory.initElements(SeleniumRepo.driver, Mobile_Modify_Email.class);

			String roomtype = h1.get("roomtype").toString().trim();
			String Numberoncard = h1.get("Numberoncard").toString().trim();
		String Entercountry = h1.get("Entercountry").toString().trim();
		String Address = h1.get("Address").toString().trim();
		String Address2 = h1.get("Address2").toString().trim();
		String Entercity = h1.get("Entercity").toString().trim();
		String Enterstate = h1.get("Enterstate").toString().trim();
		
		mobileemail.mail_conf();
		mobileemail.change_click();
		mobileemail.change_reservation();
		mobileemail.change_reservation_popup();
		mobileemail.room_selection(roomtype);
		mobileemail.booknow();
		mobileemail.confirmdetails();
		mobileemail.CardNumber(Numberoncard);
		mobileemail.Expdate();
		mobileemail.country(Entercountry);
		mobileemail.BillingAddress(Address, Address2, Entercity, Enterstate);
		mobileemail.verify();
		mobileemail.Confirmation_code();
		
	}
}
