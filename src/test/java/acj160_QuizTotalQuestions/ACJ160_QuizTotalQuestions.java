package acj160_QuizTotalQuestions;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testBase.TestBase;

public class ACJ160_QuizTotalQuestions extends TestBase {
	
	@Parameters({ "email", "password", "iterations", "title"})
	@Test
	public void createQuizWithNNumberOfQuestions(String email, String password, int iterations, 
			String title) throws Throwable {
		loginPage.loginIntoAccout(email, password);
		homePage.clickOnMenuItem("Quizzes");
		quizPage.createNTextualQuestionsQuiz(title, iterations, "abc?");
		assertIfActualStringContainsExpectedString(iterations+" Question(s)", 
				quizPage.getNumberOfQuestionFromQuiz(title), "Number of questions in Quiz");
	
	}

}
	