package Testing.WeDoQa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestGoogleCheese extends BasicTest {

	@Test
	public void resultTest() {
		// Go to google.com
		driver.get(google);

		// Search for cheese
		googlePage.googleSearch(forGoogleSearch);
		googlePage.googleSearchEnter();

		// Use JUnit assertion to compare the number of results to 777.
		// The test should fail during the comparison with an assertion message "There
		// is too much
		// cheese on the internet"
		Assert.assertTrue(googlePage.getResultStatus().contains("777"), "There are to many cheese on internet");
	}

}
