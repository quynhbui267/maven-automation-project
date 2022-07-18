package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.user.AdminHomePageObject;
import pageObjects.admin.user.AdminLoginPageObject;


public class PageGeneratorManagerAdmin extends BasePage {

	public static AdminHomePageObject getAdminHomePageObject(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
}
