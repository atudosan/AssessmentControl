package acj79_RegistrationFirstName;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import reusableUtilities.ExcelOperation;
import testBase.TestBase;

public class NegativeSignUpTests extends TestBase {
	
	ExcelOperation excel = new ExcelOperation("NegativeSignUpTestData");
	
	@Test(dataProvider = "negativeLoginTestData")
	public void validateAllErrorMsgForSignUpTest(Object obj) throws Throwable {
		@SuppressWarnings("unchecked")
		HashMap<String, String> loginTestData = (HashMap<String, String>) obj;
		
		loginPage.clickOnRegisterNowBtn();
		signUpPage.fillRegistrationForm(loginTestData.get("TC ID"), loginTestData.get("Short "
				+ "Description"), loginTestData.get("First Name"), loginTestData.get("Last Name"),
				loginTestData.get("Email"), loginTestData.get("Group Code"), loginTestData.get
				("Password"), loginTestData.get("Confirm Password"));
		signUpPage.clickOnRegisterMeButton();
		signUpPage.validateErrorMessageText(loginTestData.get("Field"), loginTestData.get("Message"),
				loginTestData.get("Message"));
		
		
	} 
	
	
	@DataProvider(name = "negativeLoginTestData")
	private Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.rowCount()][1];
		for (int i = 1; i <= excel.rowCount(); i++) {
			HashMap<String, String> loginTestData = excel.getTestDataIntoMap(i);
			obj[i - 1][0] = loginTestData;
		}
		return obj; 	
	}

}
