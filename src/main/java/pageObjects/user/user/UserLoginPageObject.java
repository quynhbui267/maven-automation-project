package pageObjects.user.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	 WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step ("Input to email textbox with value is {0}")
	public void inputToEmailAddress(String emailAddress) {
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TXTBOX, emailAddress);
		
	}
	@Step ("Input to password textbox with value is {0}")
	public void inputToPassword(String password) {
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TXTBOX, password);
		
	}
	@Step ("Click to Login button")
	public UserHomePageObject clickToLoginBtn() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BTN);
		clickToElement(driver, UserLoginPageUI.LOGIN_BTN);
		return PageGeneratorManagerUser.getUserHomePage(driver);
	}
		
	@Step ("Get Email error message to verify")
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MSG);
		
	}
	public String getCredentialErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.CREDENTIAL_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.CREDENTIAL_ERROR_MSG);
	}
	

}
