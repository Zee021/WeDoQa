package Testing.WeDoQa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMPage extends BasicPage {

	public OrangeHRMPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.id("btnLogin"));
	}

	public WebElement getRecruitmentButton() {
		return driver.findElement(By.xpath("//*[@id='menu-content']/ul/li[7]"));
	}

	public WebElement getCandidatesButton() {
		return driver.findElement(By.id("menu_recruitment_viewCandidates"));

	}

	public WebElement addCandidateButton() {
		return driver.findElement(By.xpath("//*[@class='fixed-action-btn']/a"));
	}

	public WebElement addCandidateFirstName() {
		return driver.findElement(By.id("addCandidate_firstName"));
	}

	public WebElement addCandidateLastName() {
		return driver.findElement(By.id("addCandidate_lastName"));
	}

	public WebElement addCandidateEmail() {
		return driver.findElement(By.id("addCandidate_email"));
	}

	public WebElement addResumeButton() {
		return driver.findElement(By.id("addCandidate_resume"));
	}

	public WebElement getDate() {
		return driver.findElement(By.id("applied_date"));
	}

	public WebElement getTodayButton() {
		return driver.findElement(By.xpath("//*[@class='btn-flat picker__today']"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("saveCandidateButton"));
	}

	public WebElement getVacancy() {
		return (WebElement) ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.id("textarea_addCandidate_vacancy")));
	}

	public WebElement getVacancyInput(int vacancy) {
		return (WebElement) ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(
				By.cssSelector("li[class = 'searchSingleObjectLi not-selected']:nth-child(" + vacancy + ")")));
	}

	public WebElement getCheckboxForSelectCandidate() {
		return driver.findElement(By.xpath("//*[@class='material-checkbox']/label"));
	}

	public WebElement getThreeDots() {
		return driver.findElement(By.xpath("//*[@class='material-icons icons-color handCurser']"));
	}

	public WebElement getDeleteItem() {
		return driver.findElement(By.id("deleteItemBtn"));
	}

	public WebElement getConfirmDeleteButton() {
		return driver.findElement(By.id("candidate-delete-button"));
	}

	public WebElement getUserDropDown() {
		return driver.findElement(By.id("user-dropdown"));
	}

	public WebElement getLogOutLink() {
		return driver.findElement(By.id("logoutLink"));
	}

	public void LogIn() {
		this.getLoginButton().click();
	}

	public void clickOnCandidates() {
		this.getRecruitmentButton().click();
		this.getCandidatesButton().click();
	}

	public void waitDashboardPageToLoad() {
		WebElement element = driver.findElement(By.xpath("//*[@class='c3-event-rect']"));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToFrame() {
		driver.switchTo().frame("noncoreIframe");
	}

	public int getNumberOfCandidates() {
		List<WebElement> listOfCandidates = driver.findElements(By.xpath("//*[@class='pagedata']/tbody/tr"));
		return listOfCandidates.size();
	}

	public void addCandidate(String firstName, String lastName, String email, int vacancy) {
		this.addCandidateButton().click();
		this.addCandidateFirstName().clear();
		this.addCandidateFirstName().sendKeys(firstName);
		this.addCandidateLastName().clear();
		this.addCandidateLastName().sendKeys(lastName);
		this.addCandidateEmail().clear();
		this.addCandidateEmail().sendKeys(email);
		this.getVacancy();
		this.getVacancyInput(vacancy);
		this.getDate().click();
		this.getTodayButton().click();
	}

	public void uploadResume(String resume) throws InterruptedException {
		this.addResumeButton().sendKeys(resume);
	}

	public void deleteCandidate() {
		this.getCheckboxForSelectCandidate().click();
		this.getThreeDots().click();
		this.getDeleteItem().click();
		this.getConfirmDeleteButton().click();
	}

	public void logOut() {
		this.getUserDropDown().click();
		this.getLogOutLink().click();
	}
}
