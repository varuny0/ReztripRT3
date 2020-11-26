package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.Multi_Language_And_Currency;
import com.tt.admin.pom.RateGrid;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_Multi_Language_And_Currency extends BaseTest{
	
	public String EnterValue;
	public String RoomType;
	
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	@DataProvider
	public Object[][] dataSupplier() throws IOException{
		Object[][] testobjArray = ReadDataFromExcel.readExcelAsMap(
				
			System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "Multi Lang&Curr");
		return (testobjArray);	
	}
	
	@Test(dataProvider = "dataSupplier",priority=2)
	
		public void flow(HashMap<String, String> h) throws InterruptedException, IOException {
			
			Multi_Language_And_Currency MultiLangCurr = PageFactory.initElements(SeleniumRepo.driver, Multi_Language_And_Currency.class);
			
			test = extent.createTest("Creating MultiLang&Curr");
			logger.info("Creating MultiLang&Curr");
			
			String EnterCurrency = h.get("EnterCurrency").toString().trim();
			String Language = h.get("Language").toString().trim();
			String EnterRooms = h.get("EnterRooms").toString().trim();
			String EnterAdults = h.get("EnterAdults").toString().trim();
			String roomtype = h.get("roomtype").toString().trim();
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

			
			logger.info("Browser Opened");
			
			MultiLangCurr.GoToUrl();
			MultiLangCurr.language_dropdown(Language);
    		MultiLangCurr.Verify_Mybooking();
			MultiLangCurr.currencydropdown(EnterCurrency);
			MultiLangCurr.arrival_date();
			MultiLangCurr.depature_date();
			MultiLangCurr.rooms_guests();
			MultiLangCurr.rooms(EnterRooms);
			MultiLangCurr.Adults(EnterAdults);
			MultiLangCurr.Done();
			MultiLangCurr.check_availablity();
			MultiLangCurr.room_type(roomtype);
			MultiLangCurr.booknow();
			MultiLangCurr.verify_Headingrooms();
			MultiLangCurr.Guestdetails(FirstName, LastName, Email);
			MultiLangCurr.Click_i_would();
			MultiLangCurr.confirm();
			MultiLangCurr.Paymentdetails();
			MultiLangCurr.Card_Information();
			MultiLangCurr.Name_on_card(Cardname);
			MultiLangCurr.CardNumber(Numberoncard);
			MultiLangCurr.Expdate();
			MultiLangCurr.country(Entercountry);
			MultiLangCurr.BillingAddress(Address, Address2, Entercity, Enterstate, Enterzipcode);
			MultiLangCurr.contactinformation(Enterphonenum);
			MultiLangCurr.payment();
			//MultiLangCurr.verify_Thanku_page();
			
		}
	
}
