package acj232_LoginTestsSet;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.TestBase;

public class ACJ235_LoginValidEmailAndPasswordTest extends TestBase {

	@Parameters({ "email", "password", "name" })
	@Test
	public void acj235_LogInWithValidNameAndPasswordTest(String email, String password, 
			String name) throws Throwable {
		loginPage.loginIntoAccout(email, password).
				  validateAccountName(name);
					
	

	}

	

}
