package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pageObjects.user.myaccount.CustomerAddressesPageObject;
import pageObjects.user.myaccount.CustomerInfoPageObject;
import pageObjects.user.myaccount.SidebarMyAccountPageObject;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class Level_07_SwitchPage extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;
	SidebarMyAccountPageObject myAccountPage;
	CustomerInfoPageObject customerInfoPage;
	CustomerAddressesPageObject customerAddressPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, "https://demo.nopcommerce.com/");
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
	}

	@Test
	public void TC_1_SwitchPage() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.inputToPassword("123456");
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
