package pageObjects;

import org.openqa.selenium.By;

public class LoginPageObject {
	
	By txt_email = By.id("mat-input-0");
	By txt_password = By.id("mat-input-1");
	By btn_signIn = By.xpath("//button[@type='submit']");
	
	
}
