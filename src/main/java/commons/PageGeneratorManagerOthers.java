package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.facebook.FacebookHomePageObject;
import pageObjects.jquery.JQueryHomePageObject;
import pageObjects.saucedemo.LoginPageObject;
import pageObjects.saucedemo.ProductPageObject;

public class PageGeneratorManagerOthers extends BasePage {

	public static JQueryHomePageObject getJqueryHomePage(WebDriver driver) {
		return new JQueryHomePageObject(driver);

	}

	public static FacebookHomePageObject getFacebookHomePage(WebDriver driver) {
		return new FacebookHomePageObject(driver);

	}

	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}
