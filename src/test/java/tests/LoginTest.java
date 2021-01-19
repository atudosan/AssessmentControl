package tests;

import org.testng.annotations.Test;

import testBase.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void loginIntoAccountAsTeacher() {
		loginPage.loginIntoAccout("atudosan@yahoo.com", "12345");
	}

}
