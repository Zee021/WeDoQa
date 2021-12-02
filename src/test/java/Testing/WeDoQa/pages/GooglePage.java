package Testing.WeDoQa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends BasicPage {

	public GooglePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

	}

	public WebElement getSearchInput() {
		return driver.findElement(By.name("q"));
	}

	public WebElement getFirstFromTheList() {
		return driver.findElement(By.id("rso")).findElements(By.xpath("/*")).get(0);
	}

	public WebElement getDemoPage() {
		return driver.findElement(By.xpath("//*[@class='yuRUbf']/a"));
	}

	public String getResultStatus() {
		return driver.findElement(By.id("result-stats")).getText();
	}

	public void getDemoQAPage() {
		this.getFirstFromTheList().click();
		this.getDemoPage().click();
	}

	public void googleSearch(String text) {
		this.getSearchInput().clear();
		this.getSearchInput().sendKeys(text);
		this.getSearchInput().sendKeys(Keys.ENTER);
	}

	public void googleSearchEnter() {
		this.getSearchInput().sendKeys(Keys.ENTER);
	}
}
