package pages;

import org.openqa.selenium.By;

import base.TestBase;
import util.Screenshot;

public class CarInsurancePage extends TestBase {

	public CarInsurancePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	By proceedButton = By.className("btn-proceed");
	By place = By.xpath("//*[@id='spn1']");
	By rto = By.xpath("//*[@id='section1']/ul/li[1]/span");
	By carname = By.className("maruti");
	By carModel = By.xpath("//*[@id='modelScroll']/li[1]/span");
	By fuelType = By.xpath("//*[@id='Petrol']");
	By variant = By.xpath("//*[@id='variantScroll']/li[1]/span");
	By year = By.xpath("//*[@id='dvRegYear']/ul/div/li[17]");
	By name = By.id("name");
	By email = By.id("email");
	By mobileNo = By.id("mobileNo");
	By errorMsg = By.xpath("//*[@id='dvVariant']/div[2]/div[1]/div[2]/div[2]");
	By errorMsg1 = By.xpath("//*[@id='dvVariant']/div[2]/div[1]/div[3]/div[2]");

	/*
	 * Clicking proceed button
	 */
	public void clickProceedButton() {
		driver.findElement(proceedButton).click();
	}

	/*
	 * Selecting city and rto
	 */
	public void selectCity() {
		driver.findElement(place).click();
		driver.findElement(rto).click();
	}

	/*
	 * Selecting car brand
	 */
	public void selectCarBrand() {
		driver.findElement(carname).click();
	}

	/*
	 * Selecting car model
	 */
	public void selectCarModel() {
		driver.findElement(carModel).click();
	}

	/*
	 * Select fuel type
	 */
	public void chooseFuelType() {
		driver.findElement(fuelType).click();
	}

	/*
	 * Selecting car variant
	 */
	public void selectCarVariant() {
		driver.findElement(variant).click();
	}

	/*
	 * Selecting year
	 */
	public void selectYear() {
		driver.findElement(year).click();
	}

	/*
	 * Entering name
	 */
	public void fillName(String uname) {
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys(uname);
	}
	
	/*
	 * Entering email
	 */
	public void fillEmail(String uemail) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(uemail);
	}
	
	/*
	 * Entering phone number
	 */
	public void fillPhone(String uphone) {
		driver.findElement(mobileNo).sendKeys(uphone);
	}

	/*
	 * Taking error screenshot
	 */
	public boolean takeScreenshot() {
		Screenshot s = new Screenshot();

		try {

			s.Takescreenshot(driver);

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		//Displaying error message
		System.out.println(driver.findElement(errorMsg).getText());
		System.out.println(driver.findElement(errorMsg1).getText());
		return true;
	}
}
