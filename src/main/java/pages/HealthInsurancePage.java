package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.TestBase;

public class HealthInsurancePage extends TestBase {

	public HealthInsurancePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	By insurance = By.partialLinkText("Insurance Products");
	By HealthInsurance = By.partialLinkText("Health Insurance");

	/*
	 * Printing health insurance menu items
	 */
	public boolean listValues() {
		
		List<WebElement> listval = driver
				.findElements(By.xpath("/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[2]/ul/li/a/span"));

		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(insurance);
		builder.moveToElement(element).perform();
		WebElement element1 = driver.findElement(HealthInsurance);
		builder.moveToElement(element1).perform();
		int size = listval.size();
		for (int i = 1; i <= size; i++) {
			//Printing health insurance menu item value
			WebElement c = driver.findElement(
					By.xpath("/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[2]/ul/li[" + i + "]/a/span"));
			String n = c.getText();
			System.out.println(n);
		}
 return true;
	}
}
