package pageObjects.saucedemo;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.BasePage;
import pageUI.saucedemo.ProductPageUI;

public class ProductPageObject extends BasePage {

	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductTitleDisplayed() {
		return isElementDisplayed(driver, ProductPageUI.PRODUCT_TITLE);
	}

	public void selectSortOption(String optionName) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_SORT_DROPDOWNLIST);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_SORT_DROPDOWNLIST, optionName);

	}

	public boolean isNameSortedAscending() {
		List<WebElement> productNames = getListElement(driver, ProductPageUI.PRODUCT_NAME);
		List<String> nameList = new ArrayList<>();
		for (WebElement productName : productNames) {
			nameList.add(0, productName.getText());
		}
		List<String> nameListCopy = new ArrayList<String>(nameList);
		Collections.sort(nameList);
		Collections.reverse(nameList);
		return nameList.equals(nameListCopy);
	}

	public boolean isNameSortedDescending() {
		List<WebElement> productNames = getListElement(driver, ProductPageUI.PRODUCT_NAME);
		List<String> nameList = new ArrayList<>();
		for (WebElement productName : productNames) {
			nameList.add(0, productName.getText());
		}
		List<String> nameListCopy = new ArrayList<String>(nameList);
		Collections.sort(nameList);
		return nameList.equals(nameListCopy);
	}

	public boolean isPriceSortedAscending() {
		List<WebElement> productPrices = getListElement(driver, ProductPageUI.PRODUCT_PRICE);
		List<Float> priceList = new ArrayList<>();
		for (WebElement price : productPrices) {
			priceList.add(0, Float.parseFloat(price.getText().replace("$", "")));
		}
		List<Float> priceListCopy = new ArrayList<Float>(priceList);
		Collections.sort(priceList);
		Collections.reverse(priceList);
		return priceList.equals(priceListCopy);
	}

	public boolean isPriceSortedDescending() {
		List<WebElement> productPrices = getListElement(driver, ProductPageUI.PRODUCT_PRICE);
		List<Float> priceList = new ArrayList<>();
		for (WebElement price : productPrices) {
			priceList.add(0, Float.parseFloat(price.getText().replace("$", "")));
		}
		List<Float> priceListCopy = new ArrayList<Float>(priceList);
		Collections.sort(priceList);
		return priceList.equals(priceListCopy);
	}
}
