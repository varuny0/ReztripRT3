package com.tt.admin;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.IndependentHotels;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.SeleniumRepo;

public class TC_IndependentHotel extends BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
		
	@DataProvider
	public Object[][] independent() throws IOException
	{
		Object[][] testObjArray1 = ReadDataFromExcel.readExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\AdminTestData\\Admin_TestData_qa2.xlsx", "AddNewProperty");

		return (testObjArray1);
	}
	
	
	@Test
	public void creatIndependentHotel() throws InterruptedException, IOException {
		
			IndependentHotels ClickIndHotel= PageFactory.initElements(SeleniumRepo.driver, IndependentHotels.class);

			test = extent.createTest("Clcik On Independent Hotel Link");
			logger.info("Clcik On Independent Hotel Link ");
			
//			  String PropertyName= h.get("PropertyName").toString().trim();
//				String PropertyCode=  h.get("PropertyCode").toString().trim();
//				String EnterPropertySubDomain = h.get("PropertySubDomain").toString().trim();
//				String EnterAddress1 =  h.get("Address1").toString().trim();
//				String EnterCityName =  h.get("CityName").toString().trim();
//				String EnterCountryName =  h.get("CountryName").toString().trim();
//				String EnterZipCode =  h.get("ZipCode").toString().trim();
//				String AddPropertyTitle = h.get("AddPropertyTitle").toString().trim();

			ClickIndHotel.createIndependentHotel();
																																																																																																																																								
//			addNewPrty
			
		
		}	
}
