package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	//implementing singleton design pattern 
	// 1.creating private instance
	private static DriverFactory instance = new DriverFactory();

	// 2.private constructor so no one else can create another instance
	private DriverFactory() {
	}

	// 3.creating method which allow us to have global access to that instance
	public static DriverFactory getInstance() {
		return instance;
	}

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	

	// Implementing Factory design pattern
	// Setting instance of driver
	public void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance); // this method will set the value for ThreadLocal driver instance
	}

	// Retriving Driver instance
	public WebDriver getDriver() {
		return driver.get();
	}

	//closing and removing specific driver instance
	public void closeBrowser() {
		driver.get().close();
		driver.remove();
	}

}
