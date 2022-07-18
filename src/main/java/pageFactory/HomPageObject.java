package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomPageObject extends BasePageFactory {
	WebDriver driver;

	public void HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Cách định nghĩa 1 Element (1)
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccountLink;

	// Cách định nghĩa 1 Element (2)
	@FindBy(how = How.XPATH, using = "")
	List<WebElement> footerLinks;

	public void clickToLoginLink() {
		clickToElement(driver, myAccountLink);
	}
}
