package pageObjects.user.navigation;

import org.openqa.selenium.WebDriver;

public class SitemapPageObject extends FooterMenuPageObject {
	WebDriver driver;
	
	public SitemapPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

}
