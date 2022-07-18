package pageObjects.user.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
	this.driver = driver;
	}

	public void inputFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TXTBOX, firstName);
	}
	
	public void inputLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TXTBOX, lastName);
	}
	
	public void inputEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TXTBOX, email);
	}
	
	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TXTBOX, password);		
	}
	
	public void inputConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CPASSWORD_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CPASSWORD_TXTBOX, password);	
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BTN);
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}

	public String getRegisterSuccessfulMsgText() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MSG);
	}

	

	

}
