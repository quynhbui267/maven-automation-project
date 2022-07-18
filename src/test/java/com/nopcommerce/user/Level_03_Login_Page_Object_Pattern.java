package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class Level_03_Login_Page_Object_Pattern {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserLoginPageObject loginPage;
	UserHomePageObject homePage;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);
		//Cần thêm đoạn Precondion register account
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getEmailErrorMessage(),"Please enter your email");		
	}
	@Test
	public void TC_02_Login_With_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddress("quynh123");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getEmailErrorMessage(),"Wrong email");	
	}
	@Test
	public void TC_03_Login_With_Not_Registerd_Email() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddress("quynh123@yopmail.com");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getCredentialErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found");	
	}
	@Test
	public void TC_4_Login_With_Empty_Password() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getCredentialErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");	
	}
	@Test
	public void TC_5_Login_With_Empty_Password() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.inputToPassword("123");
		loginPage.clickToLoginBtn();
		Assert.assertEquals(loginPage.getCredentialErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");	
	}
	@Test
	public void TC_6_Login_With_Valid_Credential() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailAddress("quynh12345678@yopmail.com");
		loginPage.inputToPassword("123456");
		loginPage.clickToLoginBtn();
		homePage.isMyAccountLinkDisplayed();
	}
}
