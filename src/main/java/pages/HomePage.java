package pages;

import org.openqa.selenium.By;

import base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	By insuranceProd = By.xpath("//a[text()='Insurance Products ']");
	By travelInsurance = By.xpath("//div[@class='ruby-col-3 hidden-md']/ul[1]/li[1]/a/span[contains(text(),'Travel')]");
	By carIcon = By.xpath("/html/body/cclink/main/div[2]/section/div[4]/a/div[1]/i");
	
	/*
	 * Click travel insurance
	 */
	public String clickTravelInsurance() {

		//driver.manage().deleteAllCookies();
		driver.findElement(insuranceProd).click();
		driver.findElement(travelInsurance).click();
		return driver.getTitle();
	}
	
	/*
	 * click car insurance
	 */
	public String clickCarInsurance()
	{
		driver.findElement(carIcon).click();
		return driver.getTitle();
	}
}
