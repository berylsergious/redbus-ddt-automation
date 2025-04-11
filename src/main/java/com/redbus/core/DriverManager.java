package com.redbus.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverManager {
	WebDriver driver;

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
		    System.out.println("Setting up ChromeDriver");
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();  // If this line fails, rest won't execute
		    System.out.println("ChromeDriver started");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup(); // ✅ Important
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup(); // ✅ Important
			driver = new EdgeDriver();

		} else {
			System.err.println("❌ Unsupported browser: " + browserName);
			return null;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
		driver.get("https://www.redbus.in/");

		return driver;
	}
}
