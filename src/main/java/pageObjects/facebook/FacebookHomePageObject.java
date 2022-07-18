package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import paeUIs.facebook.HomePageUI;

public class FacebookHomePageObject extends BasePage {
	WebDriver driver;

	public FacebookHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateAccountLink() {
		waitForAllElementVisible(driver, HomePageUI.CREATE_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.CREATE_ACCOUNT_LINK);
	}

	public boolean isConfirmEmailUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.CONFIRMATION_EMAIL);
	}
	public void clickCloseCreateAccountPopup() {
		waitForAllElementVisible(driver, HomePageUI.CLOSE_BUTTON);
		clickToElement(driver, HomePageUI.CLOSE_BUTTON);
	}
}
