package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pageObjects.user.user.RegisterPageObject;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


public class Common_01_Register_Cookie extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;
	RegisterPageObject registerPage;
	String firstName = "Quynh";
	String lastName = "Bui";
	public static String email = "quynhbt" + getRandomNumber(10000) + "123@yopmail.com";
	public static String password = "123456";
	public static Set<Cookie> cookies;

	@Parameters("browser")
	@BeforeTest(description = "Create a common user for all test class")
	public void Register(String browerName) {
		driver = getBrowserName(browerName);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
		//Register
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstNameTextbox(firstName);
		registerPage.inputLastNameTextbox(lastName);
		registerPage.inputEmailTextbox(email);
		registerPage.inputPasswordTextbox(password);
		registerPage.inputConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		homePage.clickUserLogoutLink(driver);
		//Login
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress(email);
		loginPage.inputToPassword(password);
		homePage = loginPage.clickToLoginBtn();
		cookies = homePage.getAllCookie(driver);
		driver.quit();
	}
}