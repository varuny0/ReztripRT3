package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.MultiProperty;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_MultiProperty extends BaseTest{
	
	@DataProvider
	public Object[][] datasupplier() throws IOException{
		
		Object[][] testobj = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "MultiProperty");
		
		return(testobj);
	}
		
		@Test(dataProvider = "datasupplier")
			
		public void flow(HashMap<String, String> h) throws IOException, InterruptedException {
			
			MultiProperty multiprop = PageFactory.initElements(SeleniumRepo.driver, MultiProperty.class);
			
			test = extent.createTest("Creating MultiProperty");
			
			String EnterCurrency = h.get("EnterCurrency").toString().trim();
			String Areas = h.get("Areas").toString().trim();
			String Enterrooms = h.get("Enterrooms").toString().trim();
			String EnterAdults = h.get("EnterAdults").toString().trim();
			String FirstName = h.get("FirstName").toString().trim();
			String LastName = h.get("LastName").toString().trim();
			String Email = h.get("Email").toString().trim();
			String Cardname = h.get("Cardname").toString().trim();
			String Numberoncard = h.get("Numberoncard").toString().trim();
			String Entercountry = h.get("Entercountry").toString().trim();
			String Address = h.get("Address").toString().trim();
			String Address2 = h.get("Address2").toString().trim();
			String Entercity = h.get("Entercity").toString().trim();
			String Enterstate = h.get("Enterstate").toString().trim();
			String Enterzipcode = h.get("Enterzipcode").toString().trim();
			String Enterphonenum = h.get("Enterphonenum").toString().trim();

			
			
			multiprop.GoToURl();
			multiprop.Verify_Mybooking();
			multiprop.verify_Currency_Dropdown(EnterCurrency);
			//multiprop.verify_lang_dropdown();
			multiprop.Hotels_Area_dropdown(Areas);
			multiprop.Arrival_Date();
			multiprop.Departure_date();
			multiprop.room_guest();
			multiprop.rooms(Enterrooms);
			multiprop.Adults(EnterAdults);
			multiprop.Done();
			multiprop.Special_rate();
			multiprop.SpecialRate_Done();
			multiprop.Check_Availability();
			multiprop.verifyhotel();
			multiprop.Hotels_link();
			multiprop.selected_property();
			multiprop.room_booknow();
			multiprop.Reservation_details();
			multiprop.Start_over();
			multiprop.Click_i_would();
			multiprop.Guestdetails(FirstName, LastName, Email);
			//multiprop.Available_offer();
			multiprop.confirm();
			multiprop.Paymentdetails();
			multiprop.Card_Information();
			multiprop.Name_on_card(Cardname);
			multiprop.CardNumber(Numberoncard);
			multiprop.Expdate();
			multiprop.country(Entercountry);
			multiprop.BillingAddress(Address, Address2, Entercity, Enterstate, Enterzipcode);
			multiprop.contactinformation(Enterphonenum);
			multiprop.payment();
			multiprop.Confirmation_code();
			multiprop.URL();
			multiprop.mybooking(Email);
			//multiprop.verify_lookup();

			
}

}
