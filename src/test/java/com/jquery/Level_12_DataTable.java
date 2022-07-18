package com.jquery;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerOthers;
import pageObjects.jquery.JQueryHomePageObject;


public class Level_12_DataTable extends BaseTest {
	WebDriver driver;
	JQueryHomePageObject jQueryHomePage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {	
		driver = getBrowserName(browerName, GlobalConstants.JQUERY_DATAGRID_URL);
	}

	@Test
	public void TC_1_DataTable() {
		jQueryHomePage = PageGeneratorManagerOthers.getJqueryHomePage(driver);
		jQueryHomePage.inputToTextBoxByHeaderName("Country", "Angola");
		jQueryHomePage.sleepInSecond(3);
		
		//Verify giá trị tìm kiếm
		//khi làm thực tế có thể verify thêm getSizeOfListElement = 1 để đảm bảo chỉ tìm ra 1 bản ghi
		assertTrue(jQueryHomePage.isSearchResultIsDisplayed("26943", "Ireland", "28292", "55235"));
		jQueryHomePage.refreshCurrentPage(driver);
		
		//Click Edit và Delete button
		jQueryHomePage.clickButtonByButtonName("Afghanistan", "remove");
		jQueryHomePage.sleepInSecond(3);
		jQueryHomePage.refreshCurrentPage(driver);
		jQueryHomePage.sleepInSecond(3);
		
		jQueryHomePage.clickButtonByButtonName("Afghanistan", "edit");
		jQueryHomePage.sleepInSecond(3);
		jQueryHomePage.refreshCurrentPage(driver);
		jQueryHomePage.sleepInSecond(3);
		
		//Pagination - to to page number 8
		jQueryHomePage.openPagebyPageNumber(8);
		jQueryHomePage.sleepInSecond(3);
		assertTrue(jQueryHomePage.isPageNumberActive(8));
		jQueryHomePage.openPageUrl(driver, GlobalConstants.JQUERY_APPENDGRID_URL);
		jQueryHomePage.inputCellByColumnNameandRowNumber("Artist",2, "test");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
