package pageObjects;

import org.openqa.selenium.By;

public class QuizzesPageObject extends RightSideMenuBar {

	By btn_createQuizzez = By.xpath("//span[text()='Create New Quiz']/parent::button"); 
	By txt_quizzTitle = By.xpath("//input[starts-with(@placeholder, 'Title')]");
	
	
}
