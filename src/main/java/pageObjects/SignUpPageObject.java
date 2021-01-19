package pageObjects;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import testBase.ExtentFactory;
import testBase.TestBase;

public class SignUpPageObject extends TestBase {

	By btn_registerMe = By.xpath("//button[@type='submit']");
	By msg_successRegister = By.xpath("//ac-registration-confirmation-page//descendant::h4");

	protected By buildXpathTxtField(String fieldName) {
		String xpathTxtField = "//input[contains(@placeholder, '" + fieldName + "')]";
		return By.xpath(xpathTxtField);
	}

	/*
	 * errorName parameters could be: 1. For "This field is required" = "required"
	 * 2. For "Should be a valid..." = "Should be a valid" 3. For
	 * "Whitespaces are not allowed" = "Whitespaces" 4. For
	 * "Too long. Should be no more than.." = "Too long" 5. For
	 * "Too short. Should be at least.." = "Too short" 6. For
	 * "Entered passwords should match" = "should much"
	 */
	protected By buildXpathErrorMessage(String fieldName, String errorName) {
		String xpathErrorMessage = "//input[contains(@placeholder, '" + fieldName + "')]//ancestor::div"
				+ "[contains(@class, 'wrapper')]//descendant::mat-error[contains(text(),'" + errorName + "')]";
		System.out.println(xpathErrorMessage);
		return By.xpath(xpathErrorMessage);
	}

	public SignUpPageObject fillRegistrationForm(String TC, String info, String firstName, String lastName,
			String email, String groupCode, String password, String confirmPassword) {
		ExtentFactory.getInstance().getExtent().log(Status.INFO,
				"Starting TC# [" + TC + "] related to" + " [" + info + "]");
		sendText(buildXpathTxtField("First Name"), "FirstName", firstName);
		sendText(buildXpathTxtField("Last Name"), "LastName", lastName);
		sendText(buildXpathTxtField("Email"), "Email", email);
		sendText(buildXpathTxtField("Group Code"), "Group Code", groupCode);
		sendText(buildXpathTxtField("Password"), "Password", password);
		sendText(buildXpathTxtField("Confirm Password"), "Confirm Password", confirmPassword);
		return new SignUpPageObject();
	}

	public void clickOnRegisterMeButton() {
		clickOn(btn_registerMe, "Register me");
	}

	public void validateErrorMessageText(String fieldName, String errorName, String expectedValue) throws Throwable {
		String actualErrorMessageText = getTextFromWebElement(buildXpathErrorMessage(fieldName, errorName), "Error "
				+ "Message ["+errorName+"] for field ["+fieldName+"]");
		assertEqualStrings(expectedValue, actualErrorMessageText, fieldName);
	}
	
	public void validateSignUpPositiveScenarios(String expectedValue) throws Throwable {
		String actualConfirmRegistration = getTextFromWebElement(msg_successRegister, "Registration Message");
		System.out.println(actualConfirmRegistration);
		assertEqualStrings(expectedValue, actualConfirmRegistration, "Registration Message");
	}	

}
