package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.DriverFactory;

public class QuizzesPageObject extends RightSideMenuBar {

	By btn_createQuizzez = By.xpath("//span[text()='Create New Quiz']/parent::button");
	By txt_quizzTitle = By.xpath("//input[starts-with(@placeholder, 'Title')]");
	By btn_addQuestion = By.xpath("//div[contains(@class, 'ng-star')]/button[contains" + "(@class, 'mat-button')]");
	By txt_questionText = By.xpath("//textarea[contains(@placeholder,'Question')]");
	By btn_saveQuiz = By.xpath("//span[contains(text(), 'Save')]//parent::button");

	protected void clickOnQuizByTitle(String title) {
		By quizTitle = By.xpath("//mat-panel-title[contains(text(),'" + title + "']");
		String elementLog = "Quiz [" + title + "]";
		clickOn(quizTitle, elementLog);
	}

	protected void clickCreateNewQuiz() {
		waitForElementToBeVisibile(btn_createQuizzez, 10);
		// clickOn(btn_createQuizzez, "CreateNewQuiz");
		pressEnter(btn_createQuizzez, "Create New Quiz");
	}

	public void createNTextualQuestionsQuiz(String quizTitle, int nrOfQuestions, String question) {
		clickCreateNewQuiz();
		sendText(txt_quizzTitle, "Quiz Title", quizTitle);
		for (int i = 0; i < nrOfQuestions; i++) {
			pressEnter(btn_addQuestion, "Add Question");
			checkTypeOfQuestionRadioBtn("Textual");
			provideQuestionToQuiz(question);
		}
		pressEnter(btn_saveQuiz, "Save Quiz");
	}
	
	public String getNumberOfQuestionFromQuiz(String quizTitle) {
		By info_nrOfQuestions = By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')"
				+ "]//following-sibling::mat-panel-description");
		WebElement infoNrQuestion = DriverFactory.getInstance().getDriver().findElement(info_nrOfQuestions);
		return infoNrQuestion.getText();	
	}
	
	private void provideQuestionToQuiz(String question) {
		List<WebElement> questList = findAll(txt_questionText);
		WebElement abc;
		if (questList.size()>1) {
			int m = questList.size() - 1;
			abc = questList.get(m);
		} else {
			abc = questList.get(0);
		}
		abc.sendKeys(question);
	}
	
	private void checkTypeOfQuestionRadioBtn(String type) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
		List<WebElement> rdbs_questionType = findAll(By.xpath("//mat-radio-button[contains(@class, 'mat')]"));
		List<WebElement> abc;
		if (rdbs_questionType.size() > 3) {
			int m = rdbs_questionType.size() - 1;
			int n = m - 3;
			abc = rdbs_questionType.subList(n, m);
		} else {
			abc = rdbs_questionType;
		}
		for (WebElement rdb : abc) {
			wait.until(ExpectedConditions.visibilityOfAllElements(abc));
			if (rdb.getText().contains(type)) {
				System.out.println(rdbs_questionType.size());
				System.out.println(rdb.getText());
				wait.until(ExpectedConditions.elementToBeClickable(rdb));
				rdb.click();
			}
		}
	}

}
