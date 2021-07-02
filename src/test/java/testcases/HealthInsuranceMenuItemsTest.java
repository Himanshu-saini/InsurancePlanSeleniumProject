package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import pages.HealthInsurancePage;



public class HealthInsuranceMenuItemsTest extends TestBase{
 
	public HealthInsuranceMenuItemsTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	HealthInsurancePage healthInsurance = new HealthInsurancePage();
	
	@BeforeClass(groups= {"Default","Regression"})
	public void setup()throws Exception {
		driver.navigate().to("https://www.policybazaar.com/");
	}

	@Test(priority=1,groups= {"Default","Smoke"})
	public void listValuesTest()throws Exception
	{
		boolean flag = healthInsurance.listValues();
		Assert.assertTrue(flag);
		logger=report.createTest("Health Insurance test");
		logger.log(Status.PASS, "HealthlistValuesTest");
	}
	
	@AfterSuite(groups= {"Default","Regression"})
	public void closeBrowser()throws Exception
	{
		driver.close();
	}
}
