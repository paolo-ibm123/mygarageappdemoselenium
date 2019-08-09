package com.example.selenium.demo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo1 {
	
	private static WebDriver driver;
	private static WebDriverWait wait;

	public Demo1() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//File file = new File(classLoader.getResource("test.html").getFile());
		//String site = file.getAbsolutePath();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuanPaoloAndrada\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		
		//driver.get(site);
				driver.navigate().to("localhost:8085/mygarageappdemo/");
				driver.manage().window().maximize();
		
		try {
			WebElement element = driver.findElement(By.id("date"));
			String type = element.getAttribute("type");
			System.out.println("[type]" + type);
		} catch (NoSuchElementException nse) {
			System.out.println("Error: type not found!");
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		driver.close();
		driver.quit();
	}

}
