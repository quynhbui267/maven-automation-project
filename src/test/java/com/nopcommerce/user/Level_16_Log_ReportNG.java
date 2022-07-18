package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerUser;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class Level_16_Log_ReportNG extends BaseTest {
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
	public void TC_1_Login_With_Wrong_Email() {
		log.info("Register - Step 1: Click Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Register - Step 2: Input wrong email");
		loginPage.inputToEmailAddress("a");
		
		log.info("Register - Step 3: Click Login button");
		homePage = loginPage.clickToLoginBtn();
		
		log.info("Register - Step 3: Verify error message is displayed");
		//Khi chay custom hard assert thi se log ra duoc 2 diem fails
		verifyEquals(loginPage.getEmailErrorMessage(),"Why");
		verifyEquals(loginPage.getEmailErrorMessage(),"Wrong email");
		verifyEquals(loginPage.getEmailErrorMessage(),"Bi lam sao the nhi");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
