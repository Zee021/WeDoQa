package Testing.WeDoQa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testing.WeDoQa.settings.Settings;

public class DemoQaPage extends BasicPage {

	public DemoQaPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.actions = new Actions(driver);
	}

	public WebElement getInteractionsSection() {
		return driver.findElement(By.xpath("//*[@class='category-cards']/div[5]"));
	}

	public WebElement getDroppableElement() {
		return driver.findElement(By.xpath("//*[@class='element-list collapse show']/ul/li[4]"));
	}

	public WebElement getWidgetsSection() {
		return driver.findElement(By.xpath("//*[@class='accordion']/div[4]"));
	}

	public WebElement getToolTipsButton() {
		return driver.findElement(By.xpath("//*[@class='element-list collapse show']/ul/li[7]"));
	}

	public WebElement getTextDropped() {
		return driver.findElement(By.xpath("//*[@id='droppable']/p"));
	}

	public String printTextDropped() {
		return this.getTextDropped().getText();
	}

	public WebElement getHoverMeButton() {
		return driver.findElement(By.id("toolTipButton"));
	}

	public WebElement getHoverMeInput() {
		return driver.findElement(By.id("toolTipTextField"));
	}

	public void dragAndDrop() {
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		Action dragAndDrop = actions.clickAndHold(from).moveToElement(to).release(to).build();
		dragAndDrop.perform();
	}

	public void clickOnDroppableButton() {
		Settings.scrollToElementJS(this.getDroppableElement(), driver);
		this.getDroppableElement().click();
	}

	public void clickOnToolTips() {
		this.getWidgetsSection().click();
		Settings.scrollToElementJS(this.getToolTipsButton(), driver);
		this.getToolTipsButton().click();
	}

	public void hoverTheElementAndPrint() throws InterruptedException {
		WebElement hoverMeToSee = driver.findElement(By.id("toolTipButton"));
		Actions action = new Actions(driver);
		action.moveToElement(hoverMeToSee).build().perform();
		WebElement toolTipElement = driver.findElement(By.xpath("/html//button[@id='toolTipButton']"));
		String toolTipText = toolTipElement.getText();
		System.out.println(toolTipText);

	}

}
