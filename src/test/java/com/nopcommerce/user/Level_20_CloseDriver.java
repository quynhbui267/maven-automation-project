package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerUser;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class Level_20_CloseDriver extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, GlobalConstants.DEV_USER_URL);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress(Common_01_Register.email);
		loginPage.inputToPassword(Common_01_Register.password);
		homePage = loginPage.clickToLoginBtn();
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC_Search01() {
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
