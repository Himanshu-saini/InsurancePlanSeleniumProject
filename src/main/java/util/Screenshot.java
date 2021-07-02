package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public void Takescreenshot(WebDriver driver) {
		// TODO Auto-generated method stub
		try{
			TakesScreenshot ts = (TakesScreenshot) driver;
		
		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
		
		//Taking screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);
		String userDir = System.getProperty("user.dir");
		String filePath = userDir + "/Screenshots/";
		
		
			FileUtils.copyFile(source, new File(filePath + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
