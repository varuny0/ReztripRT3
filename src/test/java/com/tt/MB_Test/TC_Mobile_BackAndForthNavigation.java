package com.tt.MB_Test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.MB.Mobile_BackAndForthNavigation;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Mobile_BackAndForthNavigation extends BaseTest{
	
	@DataProvider
	public Object[][] datasupplier() throws IOException{
		
		Object[][] back = ReadDataFromExcel.readExcelAsMap
				(System.getProperty("user.dir")+ "\\TestData\\BE_TestData.xlsx", "MobileBooking");
		
		return back;
	}
	
	@Test(dataProvider = "datasupplier")
	public void BackForth (HashMap<String, String> h) throws InterruptedException, IOException {
		 
		Mobile_BackAndForthNavigation BackNavigation = PageFactory.initElements(SeleniumRepo.driver, Mobile_BackAndForthNavigation.class);
		
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
		
		BackNavigation.gotourl();
		BackNavigation.Menu_Button();
		BackNavigation.Verify_Menu_Title();
		BackNavigation.Language();
		BackNavigation.Verify_Currency();
		BackNavigation.Close_Button();
		BackNavigation.Searchoffer();
		BackNavigation.ArrivalDate();
		BackNavigation.departuredate();
		BackNavigation.Bestprice();
		BackNavigation.Verify_ResetDates();
		BackNavigation.Select_Room();
		BackNavigation.Back();
		BackNavigation.Select_Room();
		BackNavigation.roomlist();
		BackNavigation.room_type(roomtype);
		BackNavigation.Back();
		BackNavigation.room_type(roomtype);
		BackNavigation.Continue();
		BackNavigation.Back();
		BackNavigation.Continue();
		BackNavigation.checkbox_guest();
		BackNavigation.FullName(FirstName, Enterphonenum, Email);
		BackNavigation.BillingAddress(Address);
		BackNavigation.Billing_Countrylink(Entercountry);
		BackNavigation.State(Enterstate);
		BackNavigation.City(Entercity, Enterzipcode);
		BackNavigation.CardName(Cardname);
		BackNavigation.CardNo(Numberoncard);
		BackNavigation.Expiration();
		BackNavigation.Card_Countryclick(Entercountry);
		BackNavigation.Postalcode(Enterzipcode);
		BackNavigation.CheckBox();
		BackNavigation.Complete_Reservation();
		BackNavigation.Confirmation_text();
	}

}
