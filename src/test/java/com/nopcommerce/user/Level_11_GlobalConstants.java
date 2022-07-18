package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerUser;
import pageObjects.user.myaccount.CustomerAddressesPageObject;
import pageObjects.user.myaccount.CustomerInfoPageObject;
import pageObjects.user.myaccount.SidebarMyAccountPageObject;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class Level_11_GlobalConstants extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;
	SidebarMyAccountPageObject myAccountPage;
	CustomerInfoPageObject customerInfoPage;
	CustomerAddressesPageObject customerAddressPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, GlobalConstants.DEV_USER_URL);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
	}

	@Test
	public void TC_1_SwitchPage() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress(GlobalConstants.USER_USERNAME);
		loginPage.inputToPassword(GlobalConstants.USER_PASSWORD);
		homePage = loginPage.clickToLoginBtn();
		myAccountPage = homePage.clickMyAccountLink();
		customerInfoPage = myAccountPage.openCustomerInfoLink();
		customerAddressPage = myAccountPage.openCustomerAddressesLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
