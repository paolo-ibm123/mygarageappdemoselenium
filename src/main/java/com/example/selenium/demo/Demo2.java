package com.example.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo2 {
	
	private static WebDriver driver;
	private static WebDriverWait wait;

	public Demo2() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//String site = "file:///C:/tools/test.html";
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\JuanPaoloAndrada\\Documents\\My Received Files\\IEDriverServer_x64_3.14.0\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		wait = new WebDriverWait(driver, 20);
		
		//driver.get(site);
			driver.navigate().to("http://localhost:8085/mygarageappdemo/");
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
