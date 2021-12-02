package Testing.WeDoQa.test;

import java.io.IOException;

import org.testng.annotations.Test;

import Testing.WeDoQa.settings.Settings;

public class FirstTestDemoQa extends BasicTest {

	@Test
	public void FirstTestDemoQa() throws InterruptedException, IOException {
		// Go to google.com
		driver.get(google);

		// Search for demoqa.com
		googlePage.googleSearch(demoQaUrl);

		// Hit the first result which will navigate to demoqa.com
		googlePage.getDemoQAPage();

		// Navigate to the Droppable element
		demoQaPage.getInteractionsSection().click();
		demoQaPage.clickOnDroppableButton();

		Thread.sleep(1000);
		// Pick and drop the “Drag me” box into the “Drop here” box
		demoQaPage.dragAndDrop();

		// print out the text from the “Drop here”
		String printText = demoQaPage.printTextDropped();
		System.out.println(printText);

		// take a screenshot
		Settings.screenshot(driver);

		// Click on the ToolTips link on the left hand side in the Widgets section
		demoQaPage.clickOnToolTips();

		Thread.sleep(1000);
		// Move your cursor to the “Hover me to see” button input element and print out
		// the text from the pop-up tooltip.
		demoQaPage.hoverTheElementAndPrint();

	}

}
