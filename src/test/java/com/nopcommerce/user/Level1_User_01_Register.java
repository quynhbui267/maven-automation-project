package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.user.user.UserHomePageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class Level1_User_01_Register {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		emailAddress = "quynhbui123" +generateRandomNumber() + "@yopmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");		
	}

	@Test
	public void TC_01_Register_Emmpty_Data() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Quynh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Bui");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("quynhbui123");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("abc13578");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("abc13578");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}
	@Test
	public void TC_03_Register_Success() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Quynh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Bui");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		sleepInSecond(4);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("abc13578");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("abc13578");

		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		driver.findElement(By.cssSelector("a.ico-logout")).click();
	}
	@Test
	public void TC_04_Register_Existing_Email() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Quynh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Bui");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		sleepInSecond(4);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("abc13578");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("abc13578");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
		
	}
	@Test
	public void TC_05_Register_Password_Less_Than_6Chars() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Quynh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Bui");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		sleepInSecond(4);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	}
	
	@Test
	public void TC_05_Register_Invalid_Confirm_Password() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Quynh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Bui");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1234567");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
	}
	@AfterClass
	public void afterClass() {
	}
	 public int generateRandomNumber() {
		 Random rand = new Random();
		 return rand.nextInt(9999);
		  
	 }
	 
		public void sleepInSecond(long second) {
			try {
				Thread.sleep(second * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
