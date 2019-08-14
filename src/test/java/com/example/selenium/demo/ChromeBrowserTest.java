package com.example.selenium.demo;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChromeBrowserTest {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@Test
	public void testHtml() {
		String site = "http://localhost:8085/mygarageappdemo/";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuanPaoloAndrada\\Desktop\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();  
        options.addArguments("test-type");
        options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 50);

		driver.get(site);
		
		
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date")));
			
			String type = element.getAttribute("type");
			assertEquals("date", type);
			
			element = driver.findElement(By.id("time"));
			type = element.getAttribute("type");
			assertEquals("time", type);
		} catch (NoSuchElementException nse) {
			fail("element type does not exist!");

			
		} finally {
			driver.quit();
		}
		
	}
}
