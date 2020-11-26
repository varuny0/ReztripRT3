package com.tt.admin;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tt.admin.pom.Taxes_Fees;
import com.tt.utility.BaseTest;
import com.tt.utility.ReadDataFromExcel;
import com.tt.utility.ReadProperties;
import com.tt.utility.SeleniumRepo;

public class TC_TaxesAndFees extends BaseTest
{
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@DataProvider
	public Object[][] dataSupplier() throws IOException 
	{

		String fileName=System.getProperty("user.dir")+"\\TestData\\AdminTestData\\"
				+ReadProperties.getPropValues("AdminEnvironment.properties", "Admin.FileName");

		Object[][] testObjArray = ReadDataFromExcel.readExcelAsMap(fileName,"TaxesAndFees");     

		return (testObjArray);
	}

	@Test(dataProvider = "dataSupplier")
	public void testTaxesAndFees(HashMap<String, String> h) throws Exception 
	{
		try 
		{

			Taxes_Fees CreateTaxFees =PageFactory.initElements(SeleniumRepo.driver, Taxes_Fees.class);
			String Property_Taxes_Title= h.get("Property_Taxes_Title").toString().trim();
			String Tax_Name= h.get("Tax_Name").toString().trim();
			String Tax_Code= h.get("Tax_Code").toString().trim();
			String Charge_Frequency= h.get("Charge_Frequency").toString().trim();
			String Charge_Basis= h.get("Charge_Basis").toString().trim();
			String Charge_Type= h.get("Charge_Type").toString().trim();
			String Charge_Amount= h.get("Charge_Amount").toString().trim();

			System.out.println("----------------------------------------");

			logger.info("Adding tax wiht tax name"+Tax_Name);

			test = extent.createTest("Adding tax wiht tax name "+Tax_Name);


			CreateTaxFees.createTaxFees(Property_Taxes_Title, Tax_Name, Tax_Code,
					Charge_Frequency, Charge_Basis, Charge_Type, Charge_Amount);
			
			System.out.println("-------Tax_Name "+Tax_Name+" created successfully---------");
			test.log(Status.INFO, "-------Tax_Name "+Tax_Name+" created successfully---------");
			logger.info("-------Tax_Name "+Tax_Name+" created successfully---------");
			

		} catch (Exception e) {
			logger.error("Unable to create Taxes And Fees property because of this execption" + e);
			test.log(Status.ERROR, "Unable to create Taxes And Fees property because of this execption" + e);
			e.printStackTrace();
			Assert.assertEquals(false, true);

		}}

}
