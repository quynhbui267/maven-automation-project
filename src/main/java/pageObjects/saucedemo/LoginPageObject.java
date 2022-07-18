package pageObjects.saucedemo;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerOthers;
import pageUI.saucedemo.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsername(String userName) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME);
		sendKeyToElement(driver, LoginPageUI.USER_NAME, userName);
		
	}

	public void inputToPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD);
		sendKeyToElement(driver, LoginPageUI.PASSWORD, password);
		
	}

	public ProductPageObject clickToLoginBtn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerOthers.getProductPage(driver);
	}

}
