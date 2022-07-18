package com.jquery;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagerOthers;
import pageObjects.jquery.JQueryHomePageObject;

public class Level_13_UploadFilesWithVarargs extends BaseTest {
	WebDriver driver;
	JQueryHomePageObject jQueryHomePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = getBrowserName(browerName, GlobalConstants.JQUERY_UPLOAD_URL);
		jQueryHomePage = PageGeneratorManagerOthers.getJqueryHomePage(driver);
	}

	@Test
	public void TC_1_Upload_Multiple_Files() {
		// Upload 3 files
		jQueryHomePage.uploadMultipleFiles(driver, "Rose.png", "Cedre.jpg", "Orange.jpg");
		jQueryHomePage.sleepInSecond(2);
		// Click Start button
		jQueryHomePage.clickStartButton();
		Assert.assertTrue(jQueryHomePage.isFileUploaded("Rose.png", "Cedre.jpg", "Orange.jpg"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
