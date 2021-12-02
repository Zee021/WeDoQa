package Testing.WeDoQa.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Testing.WeDoQa.settings.Settings;
import Testing.WeDoQa.pages.DemoQaPage;
import Testing.WeDoQa.pages.GooglePage;
import Testing.WeDoQa.pages.OrangeHRMPage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected SoftAssert softAssert;
	protected DemoQaPage demoQaPage;
	protected GooglePage googlePage;
	protected OrangeHRMPage orangePage;

	protected String candidateFirstName = "QA";
	protected String candidateLastName = "Automation";
	protected String candidateEmail = "zavisa.sauer@gmail.com";
	// IMPORTANT! Resume path needs to be adjusted to match an existing file on file
	// system
	protected String candidateResume = "C:\\Users\\38163\\Desktop\\Za test\\CV\\CV Zavisa Sauer EN.pdf";
	protected int vacancy = 10;
	protected String google = "https://www.google.com/";
	protected String forGoogleSearch = "cheese";
	protected String demoQaUrl = "demoqa.com";
	protected String orangeHRMPage = "https://orangehrm-demo-7x.orangehrmlive.com/";

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"source/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		softAssert = new SoftAssert();
		demoQaPage = new DemoQaPage(driver, wait);
		googlePage = new GooglePage(driver, wait);
		orangePage = new OrangeHRMPage(driver, wait);

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException, IOException {
		Thread.sleep(2000);
		Settings.screenshot(driver);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
