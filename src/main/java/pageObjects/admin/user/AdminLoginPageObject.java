package pageObjects.admin.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerAdmin;
import pageUIs.admin.AdminLoginPageUI;

	public class AdminLoginPageObject extends BasePage {
		 WebDriver driver;
		
		public AdminLoginPageObject(WebDriver driver) {
			this.driver = driver;
		}
		public void inputToEmailAddress(String emailAddress) {
			sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TXTBOX, emailAddress);
			
		}

		public void inputToPassword(String password) {
			sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TXTBOX, password);
			
		}

		public AdminHomePageObject clickToLoginBtn() {
			waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BTN);
			clickToElement(driver, AdminLoginPageUI.LOGIN_BTN);
			return PageGeneratorManagerAdmin.getAdminHomePageObject(driver);
		}
}
