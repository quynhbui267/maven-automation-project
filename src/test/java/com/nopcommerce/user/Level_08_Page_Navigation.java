package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.myaccount.CustomerAddressesPageObject;
import pageObjects.user.myaccount.CustomerInfoPageObject;
import pageObjects.user.myaccount.SidebarMyAccountPageObject;
import pageObjects.user.navigation.SearchPageObject;
import pageObjects.user.navigation.SitemapPageObject;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class Level_08_Page_Navigation extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;
	SidebarMyAccountPageObject sidebarMyAccountPage;
	CustomerInfoPageObject customerInfoPage;
	CustomerAddressesPageObject customerAddressPage;
	SitemapPageObject sitemapPage;
	SearchPageObject searchPage;
	String urlAdmin;
	String urlUser;

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browerName, String urlAdmin, String urlUser) {
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;
		driver = getBrowserName(browerName, urlUser);
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void TC_1_SwithchSidebarMyAccount() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.inputToPassword("123456");
		homePage = loginPage.clickToLoginBtn();
		sidebarMyAccountPage = homePage.clickMyAccountLink();
		customerInfoPage = sidebarMyAccountPage.openCustomerInfoLink();
		customerAddressPage = sidebarMyAccountPage.openCustomerAddressesLink();

	}

	@Test
	public void TC_2_SwitchFooterMenu() {
		// Tạo ra 1 hàm trung gian để có thể gọi các hàm open Footer link từ 1 page bất
		// kì mà kế thừa basePage
		// Click Search Link từ homepage
		searchPage = homePage.getFooterMenuInstance(driver).openSearchLink();
		// Click SiteMap Link từ search page
		searchPage.getFooterMenuInstance(driver).openSiteMapLink();
		// Nếu chỉ click mà ko cần tương tác gì ở searchPage (ko sử dụng method nào
		// trong searchPageObject) thì gọi ntn cũng đc, right?
		homePage.getFooterMenuInstance(driver).openSearchLink();
		homePage.getFooterMenuInstance(driver).openSiteMapLink();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
