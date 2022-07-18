package pageObjects.user.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import commons.PageGeneratorManagerUser;
import io.qameta.allure.Step;
import pageObjects.user.myaccount.SidebarMyAccountPageObject;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Click to Login Link")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManagerUser.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
	public SidebarMyAccountPageObject clickMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManagerUser.getMyAccountPage(driver);
	}
	public RegisterPageObject clickRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManagerUser.getRegisterPage(driver);
	}
}
