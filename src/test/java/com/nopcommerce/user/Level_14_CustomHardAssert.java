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

public class Level_14_CustomHardAssert extends BaseTest {
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
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddress("a");
		homePage = loginPage.clickToLoginBtn();
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
