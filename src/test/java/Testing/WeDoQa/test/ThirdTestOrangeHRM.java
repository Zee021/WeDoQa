package Testing.WeDoQa.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThirdTestOrangeHRM extends BasicTest {

	@Test
	public void orangePageTest() throws InterruptedException {
		// Go to https://orangehrm-demo-7x.orangehrmlive.com/
		driver.get(orangeHRMPage);

		// Login with admin credentials (form is prefilled with the login data)
		orangePage.LogIn();

		// Wait for the dashboard page to load
		orangePage.waitDashboardPageToLoad();

		// Go to Recruitment page
		// Open the left side panel
		// Click on Candidates
		orangePage.clickOnCandidates();

		orangePage.switchToFrame();

		// Print out the number of candidates
		System.out.println("Number of candidates is: " + orangePage.getNumberOfCandidates());
		int numberOfCandidates = orangePage.getNumberOfCandidates();

		// Click on the green Add button
		// Fill the mandatory fields and vacancy. (Resume is also mandatory)
		// The candidate name should be QA Automation - <CurrentDate> (Please substitute
		// the current date with the current date) Click Save
		orangePage.addCandidate(candidateFirstName, candidateLastName, candidateEmail, vacancy);
		orangePage.uploadResume(candidateResume);
		orangePage.getSaveButton().click();

		// Use Junit Assert to check if the number of candidates is increased by 1
		Assert.assertTrue(numberOfCandidates == orangePage.getNumberOfCandidates() - 1);

		// Select the freshly created candidate
		// Click on the three dots in the left upper side of the table.
		// Delete the candidate
		orangePage.deleteCandidate();
		Thread.sleep(3000);

		// Use Junit assert to check if the number of candidates decreased by 1
		Assert.assertEquals(orangePage.getNumberOfCandidates(), numberOfCandidates);

		// Open the side menu
		// Click on the User icon
		// Click Logout
		orangePage.logOut();

	}

}
