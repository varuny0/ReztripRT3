package com.tt.BE;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.BE.pom.GuestPrefQues_Booking;
import com.tt.BE.pom.MultiProperty;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_GuestPrefQues_Booking extends BaseTest{
	
	SeleniumRepo Selenium = SeleniumRepo.getInstance();


	@DataProvider
	
	public Object[][] datasupplier() throws IOException{
		
		Object[][] testobj = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "GuestPrefQues");
		
		return(testobj);
	}
	
	@DataProvider
	public Object[][] datasupplier1() throws IOException{
		
		Object[][] testobj1 = ReadDataFromExcel.readExcelAsMap(System.getProperty("user.dir") + "\\TestData\\BE_TestData.xlsx", "GuestPrefQues");
		
		return(testobj1);
	}
	
	@Test(dataProvider = "datasupplier",priority=1)
	
	public void Addguestpref(HashMap<String, String> h) throws IOException, InterruptedException {
		
		GuestPrefQues_Booking GuestPrefQues = PageFactory.initElements(SeleniumRepo.driver, GuestPrefQues_Booking.class);
		
		test = extent.createTest("Creating GuestPrefQues_Booking");
		
		String Selection = h.get("Selection").toString().trim();
		String category = h.get("category").toString().trim();
		String MaxOptionsAllowed = h.get("MaxOptionsAllowed").toString().trim();
		String required = h.get("required").toString().trim();
		String question = h.get("question").toString().trim();
		String questionlabel = h.get("questionlabel").toString().trim();
		
		
		GuestPrefQues.GuestPref();
		//GuestPrefQues.delguestpref(question);
		GuestPrefQues.AddNew();
		GuestPrefQues.Type(Selection);
		GuestPrefQues.category(category);
		GuestPrefQues.Required(required);
		GuestPrefQues.Maxoptallowed(MaxOptionsAllowed);
		GuestPrefQues.Question(question);
		GuestPrefQues.QuestionLabel(questionlabel);
		GuestPrefQues.Option1_label();
		GuestPrefQues.Add_New_Option();
		GuestPrefQues.Option1_label_2();
		GuestPrefQues.Add_New_Option1();
		GuestPrefQues.Option1_label_3();
		GuestPrefQues.Makedefault();
		GuestPrefQues.Save();
	}
		@Test(dataProvider = "datasupplier1",priority=2)
		
		public void BE(HashMap<String, String> h) throws IOException, InterruptedException {
		GuestPrefQues_Booking GuestPrefQues = PageFactory.initElements(SeleniumRepo.driver, GuestPrefQues_Booking.class);
			
			test = extent.createTest("Creating GuestPrefQues_Booking");		
		
		String Enterrooms = h.get("Enterrooms").toString().trim();
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
		
		
		GuestPrefQues.GoToURL();
		GuestPrefQues.Verify_Mybooking();
		GuestPrefQues.verify_lang_dropdown();
		GuestPrefQues.Arrival_Date();
		GuestPrefQues.Departure_date();
		GuestPrefQues.room_guest();
		GuestPrefQues.rooms(Enterrooms);
		GuestPrefQues.Adults(EnterAdults);
		GuestPrefQues.Done();
		GuestPrefQues.Special_rate();
		GuestPrefQues.SpecialRate_Done();
		GuestPrefQues.room_type(roomtype);
		GuestPrefQues.Booknow();
		GuestPrefQues.Reservation_details();
		GuestPrefQues.Start_over();
		GuestPrefQues.Click_i_would();
		GuestPrefQues.Guestdetails(FirstName, LastName, Email);
		GuestPrefQues.Guestlabels();
		GuestPrefQues.VerifyReqGuest();
		GuestPrefQues.confirm();
		GuestPrefQues.Paymentdetails();
		GuestPrefQues.Card_Information();
		GuestPrefQues.Name_on_card(Cardname);
		GuestPrefQues.CardNumber(Numberoncard);
		GuestPrefQues.Expdate();
		GuestPrefQues.country(Entercountry);
		GuestPrefQues.BillingAddress(Address, Address2, Entercity, Enterstate, Enterzipcode);
		GuestPrefQues.contactinformation(Enterphonenum);
		GuestPrefQues.payment();
		//GuestPrefQues.VerifyGmail();
		
	}
		
		@Test(dataProvider = "datasupplier",priority=3)
		
		public void DeleteGuestpref(HashMap<String, String> h) throws IOException, InterruptedException {
			
			GuestPrefQues_Booking GuestPrefQues = PageFactory.initElements(SeleniumRepo.driver, GuestPrefQues_Booking.class);
			
			String question = h.get("question").toString().trim();
			
			GuestPrefQues.delguestpref(question);
			
			
		}
		
		@Test(dataProvider = "datasupplier1",priority=4)
		
		public void VerifyBE(HashMap<String, String> h) throws IOException, InterruptedException {
			
			GuestPrefQues_Booking GuestPrefQues = PageFactory.initElements(SeleniumRepo.driver, GuestPrefQues_Booking.class);
			
			GuestPrefQues.BookAnotherRoom();
			GuestPrefQues.Booknow();
			GuestPrefQues.Reservation_details();
			GuestPrefQues.Start_over();
			//GuestPrefQues.Guestlabels();
	}
}
