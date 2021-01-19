package pageObjects;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import testBase.ExtentFactory;
import testBase.TestBase;

public class LoginPageObject extends TestBase {

	By txt_email = By.id("mat-input-0");
	By txt_password = By.id("mat-input-1");
	By btn_signIn = By.xpath("//button[@type='submit']");
	By pop_authFail = By.xpath("//simple-snack-bar[contains(@class, 'mat-simple-snackbar')]");
	By btn_registerNow = By.linkText("Register Now");

	// login into Account
	public HomePageObject loginIntoAccout(String email, String password) {
		sendText(txt_email, "loginEmailTextField", email);
		sendText(txt_password, "loginPasswordTextField", password);
		clickOn(btn_signIn, "SignInBtn");
		ExtentFactory.getInstance().getExtent().log(Status.INFO, "Login into acount");
		return new HomePageObject();

	}

	public void validateActualAuthFailText(String expectedMessage) throws Throwable {
		waitForElementToBeVisibile(pop_authFail, 5);
		String actualText = getTextFromWebElement(pop_authFail, "LoginFail Text ");
		assertIfActualStringContainsExpectedString(expectedMessage, actualText, "Authentification Failed Text");

	}

	public void typeCredentials(String email, String password) {
		sendText(txt_email, "loginEmailTextField", email);
		sendText(txt_password, "loginPasswordTextField", password);
	}
	
	public void checkIfPasswordHasBullets() throws Throwable {
		assertElementPropertyHasDesiredValue(txt_password, "Password Text Field", "type", "password");
	}
	
	public void clickOnRegisterNowBtn() {
		pressEnter(btn_registerNow, "Register Now Button");
		//return new SignUpPageObject();
	}

}
