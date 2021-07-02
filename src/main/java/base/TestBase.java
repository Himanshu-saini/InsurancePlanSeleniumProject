package base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import util.ExtentReportManager;

public class TestBase {
	static Properties prop;
	public static WebDriver driver;
	public static WebElement element;
	
	@SuppressWarnings("unused")
	private static final Logger logBase = LogManager.getLogger(base.TestBase.class);
    public ExtentReports report= ExtentReportManager.getReportInstance();
    public ExtentTest logger;

   //constructor
	public TestBase() throws Exception {
		try {
			System.out.println("reading prop");
			String userDir=System.getProperty("user.dir");
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					userDir + "/src/main/java/config/config.properties");  
			
			//loading properties file
			prop.load(ip);
			System.out.println("reading prop complete");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	/* To Invoke Browser */
	public static void initialization()throws Exception
	{
		try{
		String userDir = System.getProperty("user.dir");
		String browserName = prop.getProperty("browser");
		String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36";
		//opening browser
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", userDir + "/Driver/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments(String.format("user-agent=%s", userAgent));
			driver=new ChromeDriver(options);
			System.out.println("driver chrome");
		}
			else if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", userDir + "/Driver/geckodriver");
				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(new FirefoxProfile());
				options.addPreference("general.useragent.override",userAgent);
				options.addPreference("dom.webnotifications.enabled",false);
				driver=new FirefoxDriver(options);
				System.out.println("driver firefox");
			}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/* Dump all data in a file */
	@AfterMethod(groups= {"Regression","Default"})
	public void flushReports()throws Exception {
	report.flush();
	}
}
