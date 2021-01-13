package pageObjects;

public class RightSideMenuBar {
	
	public void clickOnMenu(String menu) {
	String xpath = "//h5[text()='"+ menu +"']//ancestor::a";
	}
}
