package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pageObjects.user.user.RegisterPageObject;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;


public class Common_01_Register extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;
	RegisterPageObject registerPage;
	String firstName = "Quynh";
	String lastName = "Bui";
	public static String email = "quynhbt" + getRandomNumber(10000) + "123@yopmail.com";
	public static String password = "123456";

	@Parameters("browser")
	@BeforeTest(description = "Create a common user for all test class")
	public void Register(String browerName) {
		driver = getBrowserName(browerName);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstNameTextbox(firstName);
		registerPage.inputLastNameTextbox(lastName);
		registerPage.inputEmailTextbox(email);
		registerPage.inputPasswordTextbox(password);
		registerPage.inputConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		driver.quit();
	}
}