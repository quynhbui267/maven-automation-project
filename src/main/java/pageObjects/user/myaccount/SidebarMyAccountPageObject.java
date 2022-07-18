package pageObjects.user.myaccount;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import pageUIs.user.SidebarMyAccountPageUI;

public class SidebarMyAccountPageObject extends BasePage {
	WebDriver driver;
	
	public SidebarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	// Switch common page
		public CustomerInfoPageObject openCustomerInfoLink() {
			waitForElementClickable(driver, SidebarMyAccountPageUI.CUSTOMER_INFO_LINK);
			clickToElement(driver, SidebarMyAccountPageUI.CUSTOMER_INFO_LINK);
			return PageGeneratorManagerUser.getCustomerInfoPage(driver);

		}
		
		public CustomerAddressesPageObject openCustomerAddressesLink() {
			waitForElementClickable(driver, SidebarMyAccountPageUI.CUSTOMER_ADDRESSES);
			clickToElement(driver, SidebarMyAccountPageUI.CUSTOMER_ADDRESSES);
			return PageGeneratorManagerUser.getCustomerAddressesPage(driver);

		}
}
