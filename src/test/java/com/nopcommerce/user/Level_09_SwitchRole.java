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

public class Level_09_SwitchRole extends BaseTest {
	WebDriver driver;
	UserLoginPageObject userLoginPage;
	UserHomePageObject userHomePage;
	SidebarMyAccountPageObject myAccountPage;
	CustomerInfoPageObject customerInfoPage;
	CustomerAddressesPageObject customerAddressPage;
	AdminLoginPageObject adminLoginPage;
	AdminHomePageObject adminHomePage;
	String urlAdmin;
	String urlUser;

	@Parameters({"browser","urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browerName, String urlAdmin,String urlUser) {
		this.urlAdmin=urlAdmin;
		this.urlUser=urlUser;	
		driver = getBrowserName(browerName, urlUser);
		userHomePage = PageGeneratorManagerUser.getUserHomePage(driver);
	}

	@Test
	public void TC_1_SwitchPage() {
		//Login user role
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailAddress("q123@yopmail.com");
		userLoginPage.inputToPassword("123456");
		userHomePage = userLoginPage.clickToLoginBtn();
		myAccountPage = userHomePage.clickMyAccountLink();
		customerInfoPage= myAccountPage.openCustomerInfoLink();
		customerAddressPage= myAccountPage.openCustomerAddressesLink();
		//Logout user role
		customerAddressPage.clickUserLogoutLink(driver);
		//Login admin role
		adminLoginPage = customerAddressPage.openAdminLoginPage(driver,urlAdmin);
		adminLoginPage.inputToEmailAddress("admin@yourstore.com");
		adminLoginPage.inputToPassword("admin");
		adminHomePage = adminLoginPage.clickToLoginBtn();
		//Logout admin role
		adminLoginPage.areJQueryAndJSLoadedSuccess(driver);
		adminLoginPage = adminHomePage.clickAdminLogoutLink(driver);
		//Login user role - TC chỉ mang tính chất minh họa việc switch giữa 2 role, ko phải TC thực tế
		userHomePage= adminLoginPage.openUserLoginPage(driver, urlUser);
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailAddress("q123@yopmail.com");
		userLoginPage.inputToPassword("123456");
		userHomePage = userLoginPage.clickToLoginBtn();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
