package pageObjects.admin.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminHomePageObject extends BasePage{
	WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

}
