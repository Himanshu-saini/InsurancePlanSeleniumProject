
package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import pages.HomePage;
import pages.TravelInsurancePage;
import util.TravelInsuranceExcel;

public class TravelInsuranceDetailsTest extends TestBase {

	HomePage homePage;
	private TravelInsurancePage travelInsurance;

	public TravelInsuranceDetailsTest() throws Exception {
		super();
		travelInsurance = new TravelInsurancePage();
	}

	@BeforeSuite(groups= {"Default","Regression"})
	public void setup() throws Exception {
		initialization();
		
		homePage = new HomePage();
		logger = report.createTest("Travel Insurance ValidTest");
	}

	@DataProvider(name = "dp_travelData")
	public Object[] dp() throws IOException {

		Object[] obj;

		obj = TravelInsuranceExcel
				.readData(System.getProperty("user.dir") + "/src/test/java/DataTables/TravelData.xlsx");
		System.out.println(obj);
		return obj;
	}

	@Test(priority = 1,groups= {"Default","Smoke","Regression"})
	public void homePageTitle() throws Exception
	{
		String title = homePage.clickTravelInsurance();
		Assert.assertEquals(title, "Travel Insurance - Buy Travel Insurance Online with COVID-19 Coverage in India");
		logger.log(Status.PASS, "Travel Insurance Page Opened");
	}

	@Test(dataProvider = "dp_travelData", priority = 2,groups= {"Default","Regression"})
	public void getStudentTravelInsurance(String country, String age1, String age2, String startDate, String endDate, String mobileNumber) throws Exception {
		travelInsurance.fillStudentDetails(country,age1,age2,startDate,endDate,mobileNumber);
		logger.log(Status.PASS, "Filling Details");
		logger.log(Status.INFO, "Filling Details");
		
		travelInsurance.setStudentPlanOption();
		logger.log(Status.PASS, "StudentPlan");
		logger.log(Status.INFO, "Student plan option selected");
		
		travelInsurance.sortPrice();
		logger.log(Status.PASS, "sortPrice");
		logger.log(Status.INFO, "Clicking on sort price dropdown");
		
		travelInsurance.insuranceDetails();
		logger.log(Status.PASS, "getinsuranceProviderName");
		logger.log(Status.INFO, "Clicking on sort price dropdown");
	}
	
	@AfterSuite(groups= {"Default","Regression"})
	public void closeBrowser()throws Exception
	{
		driver.close();
	}

}
