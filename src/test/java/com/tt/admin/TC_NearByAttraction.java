package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.NearByAttraction;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_NearByAttraction  extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"NearByAttraction");

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void crteNearByAttract(HashMap<String, String> h) throws InterruptedException, IOException 
	{
		try {
			NearByAttraction nearByAttraction = PageFactory.initElements(SeleniumRepo.driver, NearByAttraction.class);
			
			
			test = extent.createTest(" NearByAttraction FOR PROPERTY");
			logger.info("Creating NearByAttraction for selected property ");

			String EnterName = h.get("EnterName").toString().trim();
			String NearBy_Category = h.get("NearBy_Category").toString().trim();
			String NearBy_Description = h.get("NearBy_Description").toString().trim();
			String roomImagePath = h.get("roomImagePath").toString().trim();
			String Country = h.get("Country").toString().trim();
			String NearBy_Address = h.get("NearBy_Address").toString().trim();
			String NearBy_City= h.get("NearBy_City").toString().trim();
			String NearBy_ZipCode = h.get("NearBy_ZipCode").toString().trim();
			
			System.out.println("----------------------------------------");
			
			
			nearByAttraction.createNearByAttraction(EnterName, NearBy_Category, NearBy_Description, 
					roomImagePath, Country, NearBy_Address, NearBy_City, NearBy_ZipCode);
			/*finalAssertTrue(true,
				    "NearByAttraction  selected successfully");*/
	
			System.out.println("----------------------------------------");
	
	
	
		} catch (Exception e) {
			logger.error("Unable to create NearByAttraction for selected property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create NearByAttraction for selected property because of this execption" + e);
			/*finalAssertTrue(true,
				    "Failed to select NearByAttraction ");*/
			e.printStackTrace();

		}

	
	
	
	
	}
	
	
	
}
