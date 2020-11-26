package com.tt.MB_Test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.MB.Mobile_CompoundAccessCode;
import com.tt.admin.TC_CompoundAccessCodes;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Mobile_CompoundAccessCode extends BaseTest {
	
	@DataProvider
	public Object[][] dataSupplier() throws IOException{
		
		Object[][] compoundmobile = ReadDataFromExcel.readExcelAsMap
				(System.getProperty("user.dir")+ "\\TestData\\BE_TestData.xlsx", "MobileBooking");
		
		return (compoundmobile);
	}
	
	@Test(dataProvider = "dataSupplier")
	public void compound (HashMap<String, String> h) throws IOException, InterruptedException {
		
		Mobile_CompoundAccessCode mobilecompound = PageFactory.initElements(SeleniumRepo.driver, Mobile_CompoundAccessCode.class);
		
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
		windowid();
		SeleniumRepo.driver.switchTo().window(NewWindow);
		
		String cac=TC_CompoundAccessCodes.CompoundAccesscode;
		System.out.println("Compound accesscode is "+cac);
		
//		String r3 = TC_CompoundAccessCodes.Rateplan1;
//		System.out.println(r3);
//		String r4 = TC_CompoundAccessCodes.Rateplan2;
//		System.out.println(r4);
		
		mobilecompound.GoToUrl();
		mobilecompound.Menu_Button();
		mobilecompound.Verify_Menu_Title();
		mobilecompound.Verify_Language();
		mobilecompound.Verify_Currency();
		mobilecompound.Close_Button();
		mobilecompound.Searchoffer();
		mobilecompound.Entercode();
		mobilecompound.Search();
		mobilecompound.PopUp();
		mobilecompound.ArrivalDate();
		mobilecompound.departuredate();
		mobilecompound.Verify_ResetDates();
		mobilecompound.Select_Room();
		mobilecompound.room_type(roomtype);
		mobilecompound.verifyselected_code();
		mobilecompound.Available_offer();
		mobilecompound.Continue();
		mobilecompound.checkbox_guest();
		mobilecompound.FullName(FirstName, Enterphonenum, Email);
		mobilecompound.BillingAddress(Address);
		mobilecompound.Billing_Countrylink(Entercountry);
		mobilecompound.State(Enterstate);
		mobilecompound.City(Entercity, Enterzipcode);
		mobilecompound.CardName(Cardname);
		mobilecompound.CardNo(Numberoncard);
		mobilecompound.Expiration();
		mobilecompound.Card_Countryclick(Entercountry);
		mobilecompound.Postalcode(Enterzipcode);
		mobilecompound.CheckBox();
		mobilecompound.Complete_Reservation();
		mobilecompound.Confirmation_text();
	}

}
