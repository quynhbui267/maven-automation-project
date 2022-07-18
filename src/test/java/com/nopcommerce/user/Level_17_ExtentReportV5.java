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
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;
import reportConfig.ExtentTestManager;

public class Level_17_ExtentReportV5 extends BaseTest {
	WebDriver driver;
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, GlobalConstants.DEV_USER_URL);
		homePage = PageGeneratorManagerUser.getUserHomePage(driver);
	}

	@Test
	public void TC_1_Login_With_Wrong_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with wrong email");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input wrong email");
		loginPage.inputToEmailAddress("a");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click Login button");
		homePage = loginPage.clickToLoginBtn();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Verify error message is displayed");
		verifyEquals(loginPage.getEmailErrorMessage(),"Why");
		verifyEquals(loginPage.getEmailErrorMessage(),"Wrong email");
		verifyEquals(loginPage.getEmailErrorMessage(),"Bi lam sao the nhi");
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
