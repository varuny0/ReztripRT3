package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tt.admin.pom.DeleteGuestPreference;
import com.tt.admin.pom.GuestPreferenceQuestion;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;



/**
 * 
 * @author TT072
 *This test case adds Guest Preference questions by taking test data from Excel
 */

public class TC_GuestPQ extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		
		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName, "GuestPQ");

		return (testObjArray);
	}
	
	@Test(priority=1,enabled=false)
	public void delete() throws InterruptedException
	{
		System.out.println("enter---------------------");
		try {
		GuestPreferenceQuestion CrtGuestPQ = PageFactory.initElements(SeleniumRepo.driver,
				GuestPreferenceQuestion.class);
		
		CrtGuestPQ.delete();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}
	}

	@Test(priority=2,dataProvider = "dataSupplier" )
	public void guestPQ(HashMap<String, String> hMap) throws InterruptedException, IOException 
	{
		try
		{
		
			
			GuestPreferenceQuestion CrtGuestPQ = PageFactory.initElements(SeleniumRepo.driver,
					GuestPreferenceQuestion.class);

				String GuestPType = hMap.get("GuestPType").toString().trim();
				String MaxOptions = hMap.get("MaxOptions").toString().trim();
				String FieldQuestion = hMap.get("FieldQuestion").toString().trim();
				String FieldQuestionLabel = hMap.get("FieldQuestionLabel").toString().trim();
				String FieldQuestion_1_Label = hMap.get("FieldQuestion_1_Label").toString().trim();
				String FieldQuestion_1_Guest_Options = hMap.get("FieldQuestion_1_Guest_Options").toString().trim();
				
				test = extent.createTest("Creating Guest Prefernce Questions "+FieldQuestion);
				logger.info("Creating Guest Prefernce Questions "+FieldQuestion);

				//CrtGuestPQ.delete(FieldQuestion);
				CrtGuestPQ.creatGuestPQ(GuestPType, MaxOptions, FieldQuestion, FieldQuestionLabel, 
						FieldQuestion_1_Label,FieldQuestion_1_Guest_Options);
		}
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(false, true);
		}

		
	}
}
