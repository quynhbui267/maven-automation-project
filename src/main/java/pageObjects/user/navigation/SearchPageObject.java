package pageObjects.user.navigation;

import org.openqa.selenium.WebDriver;

public class SearchPageObject extends FooterMenuPageObject {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
