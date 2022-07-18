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

public class Level_19_ShareClass_Cookie extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, GlobalConstants.DEV_USER_URL);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
		homePage.addCookies(driver, Common_01_Register_Cookie.cookies);
		homePage.refreshCurrentPage(driver);
	}
	
	@Test
	public void TC_Search01() {
		homePage.clickMyAccountLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
