package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pageObjects.admin.user.AdminHomePageObject;
import pageObjects.admin.user.AdminLoginPageObject;
import pageObjects.user.myaccount.CustomerAddressesPageObject;
import pageObjects.user.myaccount.CustomerInfoPageObject;
import pageObjects.user.myaccount.SidebarMyAccountPageObject;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class Level_10_ByLocator_DynamicLocator extends BaseTest {
	WebDriver driver;
	UserLoginPageObject userLoginPage;
	UserHomePageObject userHomePage;
	SidebarMyAccountPageObject myAccountPage;
	CustomerInfoPageObject customerInfoPage;
	CustomerAddressesPageObject customerAddressPage;
	AdminLoginPageObject adminLoginPage;
	AdminHomePageObject adminHomePage;
	String urlUser;

	@Parameters({ "browser", "urlUser" })
	@BeforeClass
	public void beforeClass(String browerName, String urlUser) {
		driver = getBrowserName(browerName, urlUser);
		userHomePage = PageGeneratorManagerUser.getUserHomePage(driver);
	}

	@Test
	public void TC_1_Dynamic_Locator() {
		//Open site map
		userHomePage.getFooterMenuInstance(driver).openFooterMenuByPageName("Sitemap");
		userHomePage.getFooterMenuInstance(driver).openFooterMenuByPageName("Search");
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
