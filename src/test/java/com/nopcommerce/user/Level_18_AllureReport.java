package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Description;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;
import reportConfig.ExtentTestManager;

public class Level_18_AllureReport extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, GlobalConstants.DEV_USER_URL);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
	}
	@Description("Login with Wrong Email")
	@Test
	public void TC_1_Login_With_Wrong_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("a");
		homePage = loginPage.clickToLoginBtn();
		verifyEquals(loginPage.getEmailErrorMessage(),"Wrong email...");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
