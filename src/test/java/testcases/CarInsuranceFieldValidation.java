package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import base.TestBase;
import pages.CarInsurancePage;
import pages.HomePage;
import util.ReadExcel;


public class CarInsuranceFieldValidation extends TestBase {

	public CarInsuranceFieldValidation() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	CarInsurancePage carInsurance = new CarInsurancePage();
	HomePage homePage = new HomePage();
	String sheetName = "Sheet1";
    String userDir = System.getProperty("user.dir");
	String filePath = userDir + "/src/test/java/DataTables/CarInsuranceData.xlsx";

	@BeforeClass(groups= {"Default","Regression"})
	public void setup()throws Exception {
		 initialization();
		driver.navigate().to("https://www.policybazaar.com/");
	}

	@Test(priority = 1,groups= {"Default","Smoke","Regression"})
	public void clickCarInsuranceTest() throws Exception{

		homePage.clickCarInsurance();
		logger = report.createTest("Car Insurance ValidTest");
		logger.log(Status.PASS, "Clicking car Insurance");
	}

	@Test(priority = 2,groups= {"Default","Regression"})
	public void clickProceedButtonTest()throws Exception {
		carInsurance.clickProceedButton();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking proceed button");
	}

	@Test(priority = 3,groups= {"Default","Regression"})
	public void selectCityTest()throws Exception {
		carInsurance.selectCity();
		logger.log(Status.PASS, "selectCityTest");
	}

	@Test(priority = 4,groups= {"Default","Smoke","Regression"})
	public void selectCarBrandTest() throws Exception{
		carInsurance.selectCarBrand();
		logger.log(Status.PASS, "selectCarBrandTest");
		
	}

	@Test(priority = 5,groups= {"Default","Regression"})
	public void selectCarModelTest()throws Exception {
		carInsurance.selectCarModel();
		logger.log(Status.PASS, "selectCarModelTest");
		
	}

	@Test(priority = 6,groups= {"Default","Regression"})
	public void chooseFuelTypeTest()throws Exception {
		carInsurance.chooseFuelType();
		logger.log(Status.PASS, "chooseFuelTypeTest");
		
	}

	@Test(priority = 7,groups= {"Default","Regression"})
	public void selectCarVariantTest()throws Exception {
		carInsurance.selectCarVariant();
		logger.log(Status.PASS, "selectCarVariantTest");
	}

	@Test(priority = 8,groups= {"Default","Regression"})
	public void selectYearTest() throws Exception{
		carInsurance.selectYear();
		logger.log(Status.PASS, "selectYearTest");
	}

	@Test(priority = 9,groups= {"Default","Regression"})
	public void fillDetailsTest()throws Exception {
		ReadExcel re = new ReadExcel();

		try {
			carInsurance.fillName(re.readExcel(2, 0, filePath, sheetName));
			carInsurance.fillEmail(re.readExcel(2, 1, filePath, sheetName));
			carInsurance.fillPhone(re.readExcel(2, 2, filePath, sheetName));
			logger.log(Status.PASS, "fillDetailsTest");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 10,groups= {"Default","Regression"})
	public void takeScreenshotTest()throws Exception {
		boolean flag = carInsurance.takeScreenshot();
		Assert.assertTrue(flag);
		logger.log(Status.PASS, "takeScreenshotTest");
	}
	@AfterSuite(groups= {"Default","Regression"})
	public void closeBrowser()throws Exception
	{
		driver.close();
	}
}



