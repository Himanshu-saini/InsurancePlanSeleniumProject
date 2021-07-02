package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class TravelInsurancePage extends TestBase {

	public TravelInsurancePage() throws Exception {
		super();
	}
	public JavascriptExecutor executor;
	By destination = By.id("destination-autocomplete");
	
	By nextButton = By.xpath("//button[@class='enable' and text()='Next']");
	By travellerAge1Field = By.id("travellerAge1");
	By travellerAge2Field = By.id("travellerAge2");
	By addTraveller = By.className("addTraveller");
	By startDateElement = By.id("startdate");
	By endDateElement = By.id("enddate");
	By travelMobile = By.id("travelmobile");
	
	By viewPlansButton = By.xpath("//button[@class='enable' and text()='View Plans']");
	By studentPlanOption = By.className("studentPlanLabel");

	By student1VisaCheckbox = By.xpath("//*[@class='MuiSwitch-root jss1']");
	By student2VisaCheckbox = By.xpath("(//*[@class='MuiSwitch-root jss1'])[2]");
	By visaValidDropDown = By.xpath("//*[@class='form-control d-inline-block selctstud']");
	By applyVisaButton = By.xpath("//button[@class='next']");
	
	By sortByDropDown = By.xpath("//*[@class='sort_select']");

	
	/* Entering student details in form */
	public void fillStudentDetails(String country, String age1, String age2, String startDate, String endDate, String mobileNumber) {
		
		setDestination(country);
		setPersonAge(age1, age2);
		setTravelDate(startDate, endDate);
		
		driver.findElement(travelMobile).sendKeys(mobileNumber);
		
		element = driver.findElement(viewPlansButton);
		executor.executeScript("arguments[0].click()", element);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

	}
	
	public void setDestination(String country) {
		driver.findElement(destination).sendKeys(country);
		driver.findElement(destination).sendKeys(Keys.RETURN);
		driver.findElement(nextButton).click();
	}
	
	public void setPersonAge(String age1, String age2) {
		Select age1DropDown = new Select(driver.findElement(travellerAge1Field));
		age1DropDown.selectByVisibleText(age1+" yrs");
		driver.findElement(addTraveller).click();
		Select age2DropDown = new Select(driver.findElement(travellerAge2Field));
		age2DropDown.selectByVisibleText(age2+" yrs");
		driver.findElement(nextButton).click();
	}

	public void setTravelDate(String startDate, String endDate){
		executor = (JavascriptExecutor) driver;
		
		element = driver.findElement(startDateElement);
		executor.executeScript("arguments[0].removeAttribute('readonly')", element);
		element.sendKeys(startDate);
		
		element = driver.findElement(endDateElement);
		executor.executeScript("arguments[0].removeAttribute('readonly')", element);
		element.sendKeys(endDate);
		
		element = driver.findElement(nextButton);
		executor.executeScript("arguments[0].click()", element);
	}
	
	public void setStudentPlanOption() {
		driver.findElement(studentPlanOption).click();
		driver.findElement(student1VisaCheckbox).click();
		driver.findElement(student2VisaCheckbox).click();
		
		Select visaDropDown = new Select(driver.findElement(visaValidDropDown));
		visaDropDown.selectByIndex(1);
		
		driver.findElement(applyVisaButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void sortPrice() {
		Select sortDropDown = new Select(driver.findElement(sortByDropDown));
		sortDropDown.selectByIndex(1);
	}
	
	public void insuranceDetails() {
        System.out.println("List of cheapest 3 travel insurance plans:");
        List<WebElement> insuranceList = driver.findElements(By.xpath("//div[@class='main_quotes blank_si']"));
        
        for(int i=0;i<3;i++) {
        	WebElement currRow = insuranceList.get(i);
        	String companyName = currRow.findElement(By.xpath("//*[@class='desktop leftLogo']/div[1]"))
        			.getAttribute("class").substring(5);

        	String planName = currRow.findElement(By.xpath("//*[@class='key_features']/li/*[@class='quotes_plan_name']"))
        			.getText();
        	String planPrice = currRow.findElement(By.xpath("//button[@type='button'][contains(@class,'card_btn_secondary')]"))
        			.getText().substring(2);
        	
        	System.out.println(companyName+" - "+planName+" - Rs "+planPrice);
        }
	}
}