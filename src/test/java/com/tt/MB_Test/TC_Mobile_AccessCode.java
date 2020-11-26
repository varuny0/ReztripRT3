package com.tt.MB_Test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.MB.Mobile_AccessCode;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Mobile_AccessCode extends BaseTest {
	
	@DataProvider
	public Object[][] dataSupplier() throws IOException
	{

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "MobileBooking");

		return (testObjArray);
	}
	
	@Test(dataProvider = "dataSupplier")
		
	public void offercode(HashMap<String, String> h) throws InterruptedException, IOException {
		
		Mobile_AccessCode  mobileaccesscode =PageFactory.initElements(SeleniumRepo.driver, Mobile_AccessCode.class);
		
		String roomtype = h.get("roomtype").toString().trim();
		String FirstName = h.get("FirstName").toString().trim();
		String Email = h.get("Email").toString().trim();
		String Cardname = h.get("Cardname").toString().trim();
		String Numberoncard = h.get("Numberoncard").toString().trim();
		String Entercountry = h.get("Entercountry").toString().trim();
		String Address = h.get("Address").toString().trim();
		String Entercity = h.get("Entercity").toString().trim();
		String Enterstate = h.get("Enterstate").toString().trim();
		String Enterzipcode = h.get("Enterzipcode").toString().trim();
		String Enterphonenum = h.get("Enterphonenum").toString().trim();
		
		mobileaccesscode.GoToUrl();
		mobileaccesscode.Menu_Button();
		mobileaccesscode.Verify_Menu_Title();
		mobileaccesscode.Verify_Language();
		mobileaccesscode.Verify_Currency();
		mobileaccesscode.Close_Button();
		mobileaccesscode.Searchoffer();
		mobileaccesscode.Entercode();
		mobileaccesscode.Search();
		mobileaccesscode.PopUp();
		mobileaccesscode.ArrivalDate();
		mobileaccesscode.departuredate();
		mobileaccesscode.Verify_ResetDates();
		mobileaccesscode.Select_Room();
		//mobileaccesscode.roomlist();
		mobileaccesscode.room_type(roomtype);
		mobileaccesscode.verifyselected_code();
		mobileaccesscode.Selectedoffer();
		mobileaccesscode.Continue();
		mobileaccesscode.checkbox_guest();
		mobileaccesscode.FullName(FirstName, Enterphonenum, Email);
		mobileaccesscode.BillingAddress(Address);
		mobileaccesscode.Billing_Countrylink(Entercountry);
		mobileaccesscode.State(Enterstate);
		mobileaccesscode.City(Entercity, Enterzipcode);
		mobileaccesscode.CardName(Cardname);
		mobileaccesscode.CardNo(Numberoncard);
		mobileaccesscode.Expiration();
		mobileaccesscode.Card_Countryclick(Entercountry);
		mobileaccesscode.Postalcode(Enterzipcode);
		//mobileaccesscode.CheckBox();
		mobileaccesscode.Complete_Reservation();
		mobileaccesscode.Confirmation_text();
		
	}
}
