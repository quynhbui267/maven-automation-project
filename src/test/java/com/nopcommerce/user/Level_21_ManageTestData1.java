package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pageObjects.user.user.RegisterPageObject;
import pageObjects.user.user.UserHomePageObject;
import utilities.DataHelper;

public class Level_21_ManageTestData1 extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	UserHomePageObject homePage;
	DataHelper dataHelper = DataHelper.getDataHelper();
	String firstName = dataHelper.getFirstName();
	String lastName = dataHelper.getLastName();
	String email = dataHelper.getEmail();
	String password = dataHelper.getPassword();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 1: Click Register link");
		registerPage = homePage.clickRegisterLink();
		
		log.info("Register - Step 2: Input first name= " + firstName);
		registerPage.inputFirstNameTextbox(firstName);
		
		log.info("Register - Step 3: Input last name= " + lastName);
		registerPage.inputLastNameTextbox(lastName);
		
		log.info("Register - Step 4: Input email= " + email);
		registerPage.inputEmailTextbox(email);
		
		log.info("Register - Step 5: Input password and confirm password= " + password);
		registerPage.inputPasswordTextbox(password);
		registerPage.inputConfirmPasswordTextbox(password);
		
		log.info("Register - Step 6: Click register button");
		registerPage.clickToRegisterButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
