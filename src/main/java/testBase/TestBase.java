package testBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableUtilities.ConfigPropExtractData;



public class TestBase {

	// create an instance of BrowserFactoryClass 
	BrowserFactory factory = new BrowserFactory();

	 
	@BeforeMethod
	public void LaunchApplication() throws Exception {
		
		String browser = ConfigPropExtractData.getPropValueByKey("browser");
		String url = ConfigPropExtractData.getPropValueByKey("url");
		
		// create driverInstance to pass it to setDriver() method		
		WebDriver driverInstance = factory.createBrowserInstance(browser);
		// here we set the driver value into the ThreadLocal driver instance (TreadLocal HashMap)
		DriverFactory.getInstance().setDriver(driverInstance);
		//get the value driver from ThreadLocal and set it for our driver instance
		WebDriver driver = DriverFactory.getInstance().getDriver();

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@AfterMethod
	public void tearDown() {	
		DriverFactory.getInstance().closeBrowser();
	}

}
