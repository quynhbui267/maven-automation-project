package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.myaccount.CustomerAddressesPageObject;
import pageObjects.user.myaccount.CustomerInfoPageObject;
import pageObjects.user.myaccount.SidebarMyAccountPageObject;
import pageObjects.user.user.RegisterPageObject;
import pageObjects.user.user.UserHomePageObject;
import pageObjects.user.user.UserLoginPageObject;

public class PageGeneratorManagerUser extends BasePage {


	// Su dung static method de truy nhap truc tiep o cac PageObject ko phai khoi tao object PageGeneratorManager)
	// SidebarMyAccountPageObject co ham constructor voi bien driver nen ham getMyAccountPage cung phai co bien parameter la driver
	public static SidebarMyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new SidebarMyAccountPageObject(driver);
	}

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static CustomerAddressesPageObject getCustomerAddressesPage(WebDriver driver) {
		return new CustomerAddressesPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
}
