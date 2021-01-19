package acj232_LoginTestsSet;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.TestBase;

public class ACJ236_InvalidEmailAndPasswordTest extends TestBase{
	
	@Parameters({ "wrongEmail", "wrongPassword", "expectedMessage" })
	@Test
	public void invalidEmailAndPassword(String wrongEmail, String wrongPassword, 
			String expectedMessage) throws Throwable {
		loginPage.loginIntoAccout(wrongEmail, wrongPassword);
		loginPage.validateActualAuthFailText(expectedMessage);		
	}

}
