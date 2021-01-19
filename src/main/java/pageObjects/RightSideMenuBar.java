package pageObjects;

import org.openqa.selenium.By;

import testBase.TestBase;

public class RightSideMenuBar extends TestBase {
	
	By info_acountName = By.xpath("//*[@class='info']/child::h3");
	By info_moduleName = By.xpath("//*[@class='info']/child::p");
	By elementThatSwitchVisibility = By.xpath("//*[@class='info']//ancestor::mat-sidenav");
	
	public void clickOnMenuItem(String menu) {
	String string_xpath = "//h5[text()='"+ menu +"']//ancestor::a";
	By by_xpath = By.xpath(string_xpath);
	String elementLog = menu+"LinkMenu";
	clickOn(by_xpath, elementLog);
	}
	

	
	public RightSideMenuBar validateAccountName(String expectedNameAccount) throws Throwable {
		waitUntilAttributeContainsValue(elementThatSwitchVisibility, 5, "style", "visible");
		String actualAccountName = getTextFromWebElement(info_acountName, "AccountName");
		assertEqualStrings(expectedNameAccount, actualAccountName, "AccountName");
		return new RightSideMenuBar();
	}
	
	public void validateModuleName(String expectedModuleName) throws Throwable {
		String actualModuleName = getTextFromWebElement(info_acountName, "Module Name");
		assertEqualStrings(expectedModuleName, actualModuleName, "Module Name");
	}
	
	
}
