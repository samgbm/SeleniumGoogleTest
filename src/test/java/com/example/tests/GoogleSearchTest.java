package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup(); // Automatically download and set up ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testGoogleSearch() {
		driver.get("https://www.google.com");
		sleep(5);
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
		sleep(5);

		driver.findElement(By.name("btnK")).click();
		sleep(5);

		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Selenium WebDriver"), "Title does not contain search term");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}