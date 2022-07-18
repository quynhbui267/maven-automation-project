package pageObjects.jquery;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.BasePage;
import pageUIs.jquery.JQueryPageUI;

public class JQueryHomePageObject extends BasePage {
	WebDriver driver;

	public JQueryHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// AppendGrid
	public void inputCellByColumnNameandRowNumber(String columnName, int rowNumber, String inputValue) {
		waitForElementInVisible(driver, JQueryPageUI.INPUT_CELL, String.valueOf(rowNumber), columnName);
		sendKeyToElement(driver, JQueryPageUI.INPUT_CELL, inputValue, String.valueOf(rowNumber), columnName);
	}

	// DataGrid
	public void inputToTextBoxByHeaderName(String headerName, String inputValue) {
		waitForElementVisible(driver, JQueryPageUI.HEADER_TEXTBOX, headerName);
		sendKeyToElement(driver, JQueryPageUI.HEADER_TEXTBOX, inputValue, headerName);
		pressKeyToElement(driver, JQueryPageUI.HEADER_TEXTBOX, Keys.ENTER, headerName);
	}

	public boolean isSearchResultIsDisplayed(String femaleValue, String countryValue, String maleValue, String totalValue) {
		return isElementDisplayed(driver, JQueryPageUI.ROW_VALUE, femaleValue, countryValue, maleValue, totalValue);
	}

	public void clickButtonByButtonName(String countryName, String buttonName) {
		waitForElementClickable(driver, JQueryPageUI.ACTION_ICON_BY_COUNTRY_NAME, countryName, buttonName);
		clickToElement(driver, JQueryPageUI.ACTION_ICON_BY_COUNTRY_NAME, countryName, buttonName);
	}

	public void openPagebyPageNumber(int pageNUmber) {
		waitForElementClickable(driver, JQueryPageUI.PAGE_NUMBER_LINK, String.valueOf(pageNUmber));
		clickToElement(driver, JQueryPageUI.PAGE_NUMBER_LINK, String.valueOf(pageNUmber));

	}

	public boolean isPageNumberActive(int pageNumber) {
		return isElementDisplayed(driver, JQueryPageUI.ACTIVE_PAGE_NUMBER_LINK, String.valueOf(pageNumber));
	}

	// Upload files
	public void clickStartButton() {
		waitForElementClickable(driver, JQueryPageUI.START_BUTTON);
		List<WebElement> startBtnElements = getListElement(driver, JQueryPageUI.START_BUTTON);
		for (WebElement startBtn : startBtnElements) {
			waitForElementClickable(driver, startBtn);
			startBtn.click();
		}
	}

	public boolean isFileUploaded(String...fileNames) {
		return isElementDisplayed(driver, JQueryPageUI.FILE_NAME_UPLOADED, fileNames);
		
	}
}
