package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManagerOthers;
import pageObjects.saucedemo.LoginPageObject;
import pageObjects.saucedemo.ProductPageObject;

public class SortData extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	String userName = "standard_user";
	String password = "secret_sauce";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browerName, String url) {
		driver = getBrowserName(browerName, url);
		loginPage = PageGeneratorManagerOthers.getLoginPage(driver);
		loginPage.inputToUsername(userName);
		loginPage.inputToPassword(password);
		productPage = loginPage.clickToLoginBtn();
		verifyTrue(productPage.isProductTitleDisplayed());
	}

	@Test
	public void TC_Search01_SortNameAscending() {
		productPage.selectSortOption("Name (A to Z)");
		Assert.assertTrue(productPage.isNameSortedAscending());

	}

	@Test
	public void TC_Search02_SortNameDescending() {
		productPage.selectSortOption("Name (Z to A)");
		Assert.assertTrue(productPage.isNameSortedDescending());
	}

	@Test
	public void TC_Search03_SortPriceAscending() {
		productPage.selectSortOption("Price (low to high)");
		Assert.assertTrue(productPage.isPriceSortedAscending());
	}

	@Test
	public void TC_Search02_SortPriceDescending() {
		productPage.selectSortOption("Price (high to low)");
		Assert.assertTrue(productPage.isPriceSortedDescending());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
