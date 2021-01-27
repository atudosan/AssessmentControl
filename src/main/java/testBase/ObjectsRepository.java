package testBase;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.QuizzesPageObject;
import pageObjects.SignUpPageObject;

public class ObjectsRepository {
	
	protected final static LoginPageObject loginPage = new LoginPageObject();
	protected final static HomePageObject homePage = new HomePageObject();
	protected final static SignUpPageObject signUpPage = new SignUpPageObject();
	protected final static QuizzesPageObject quizPage = new QuizzesPageObject();


}
