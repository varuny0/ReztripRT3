package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Amenities;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;


@Test
public class TC_Amenties extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")
				+"\\TestData\\AdminTestData\\"+
				ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"Amenities");

		return (testObjArray);
	}
	
	@Test(dataProvider = "dataSupplier")
	public void amenities(HashMap<String, String> h) throws Exception 
	{
		try {
		Amenities CrtAmenities =PageFactory.initElements(SeleniumRepo.driver, Amenities.class);
		        
		 
	
	  String Amenity_Name = h.get("Amenity_Name").toString().trim();
	  String Type         = h.get("Type").toString().trim();
	  
	  
	  test = extent.createTest("Creating Amenitiey "+Amenity_Name);
      logger.info("Creating Amenitiey "+Amenity_Name);
	  
	  System.out.println("----------------------------------------");
	  
	CrtAmenities.addAmenity(Amenity_Name, Type);
	
	System.out.println("-------Amenity_Name "+Amenity_Name+" created successfully---------");
	test.log(Status.INFO, "-------Amenity_Name "+Amenity_Name+" created successfully---------");
	  
		} 
		catch (Exception e) {
			logger.error("Unable to create Amenities  property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Amenities property because of this execption" + e);
		/*	finalAssertTrue(true,
				    "Failed to select Amenities ");*/
			e.printStackTrace();
			Assert.assertEquals(false, true);
	
}
}}
