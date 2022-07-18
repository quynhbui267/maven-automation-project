package pageObjects.user.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.FooterMenuPageUI;

public class FooterMenuPageObject extends BasePage {
	WebDriver driver;

	public FooterMenuPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public SitemapPageObject openSiteMapLink() {
		waitForElementClickable(driver, FooterMenuPageUI.FOOTER_LINK, "Sitemap");
		clickToElement(driver, parseStringToLocator(FooterMenuPageUI.FOOTER_LINK, "Sitemap"));
		return new SitemapPageObject(driver);
	}
	public SearchPageObject openSearchLink() {
		waitForElementClickable(driver, FooterMenuPageUI.FOOTER_LINK, "Search");
		clickToElement(driver, parseStringToLocator(FooterMenuPageUI.FOOTER_LINK, "SiteSearchmap"));
		return new SearchPageObject(driver);
	}
	
	public void openFooterMenuByPageName(String pageName) {
		waitForElementClickable(driver, FooterMenuPageUI.FOOTER_LINK, pageName);
		clickToElement(driver, FooterMenuPageUI.FOOTER_LINK, pageName);
	}

}
