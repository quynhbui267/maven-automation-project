package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManagerOthers;
import pageObjects.facebook.FacebookHomePageObject;


public class Level_15_VerifyUndisplayedElement extends BaseTest {
	WebDriver driver;
	FacebookHomePageObject homePage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, "https://www.facebook.com/");
		homePage = PageGeneratorManagerOthers.getFacebookHomePage(driver);
	}

	@Test
	public void TC_1_Login_With_Wrong_Email() {
		homePage.clickToCreateAccountLink();
		//Viet 1 ham verify Element is undisplayed su dung chung cho 2 truong hop Element in DOM or not in DOM.
		//Verify when do not input Email address, Confirm password is in DOM but not displayed
		verifyTrue(homePage.isConfirmEmailUndisplayed());
		
		//Verify when close Create account pop-up, Confirm password is not in DOM and not displayed
		homePage.clickCloseCreateAccountPopup();
		verifyTrue(homePage.isConfirmEmailUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
