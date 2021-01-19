package acj232_LoginTestsSet;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.TestBase;

public class ACJ239_PasswordInBullets extends TestBase {
	
	@Parameters({ "email", "password"})
	@Test
	public void verifyIfPasswordIsInBullets(String email, String password) throws Throwable {
		loginPage.typeCredentials(email, password);
		loginPage.checkIfPasswordHasBullets();	
		
	}

}
