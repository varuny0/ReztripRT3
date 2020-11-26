package com.tt.MB_Test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.MB.Mobile_Multi_langCurr;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Mobile_Multi_langCurr extends BaseTest{

	@DataProvider	
	public Object[][] dataSupplier() throws IOException{
		
		Object[][] test =  ReadDataFromExcel.readExcelAsMap
				(System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "MobileBooking");
		
		return (test);
	}
	
	@Test(dataProvider = "dataSupplier")
	public void langcurr(HashMap<String, String> h) throws InterruptedException, IOException {
	
		
		Mobile_Multi_langCurr multilangcurr = PageFactory.initElements(SeleniumRepo.driver, Mobile_Multi_langCurr.class);
		
		String EnterLanguage = h.get("EnterLanguage").toString().trim();
		String EnterCurrency = h.get("EnterCurrency").toString().trim();
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
		
		multilangcurr.GoToUrl();
		multilangcurr.menu();
		multilangcurr.Verify_Menu_Title();
		multilangcurr.Currency(EnterCurrency);
		multilangcurr.menu();
		multilangcurr.Language(EnterLanguage);
		multilangcurr.Searchoffer();
		multilangcurr.ArrivalDate();
		multilangcurr.departuredate();
		multilangcurr.Bestprice();
		multilangcurr.Verify_ResetDates();
		multilangcurr.Select_Room();
		multilangcurr.Roomlist();
		multilangcurr.room_type(roomtype);
		multilangcurr.Continue();
		multilangcurr.checkbox_guest();
		multilangcurr.FullName(FirstName, Enterphonenum, Email);
		multilangcurr.BillingAddress(Address);
		multilangcurr.Billing_Countrylink(Entercountry);
		multilangcurr.State(Enterstate);
		multilangcurr.City(Entercity, Enterzipcode);
		multilangcurr.CardName(Cardname);
		multilangcurr.CardNo(Numberoncard);
		multilangcurr.Expiration();
		multilangcurr.Card_Countryclick(Entercountry);
		multilangcurr.Postalcode(Enterzipcode);
		multilangcurr.CheckBox();
		multilangcurr.Complete_Reservation();
		multilangcurr.Confirmation_text();

	}
}
