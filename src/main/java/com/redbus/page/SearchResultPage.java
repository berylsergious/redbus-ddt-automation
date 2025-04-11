package com.redbus.page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {


	private WebDriver driver;
	private WebDriverWait wait ;

	//Elements
	
	@FindBy(xpath="//div[@class='button']")
	private WebElement ViewGovBuses;
	
	
	
	@FindBy(xpath="//div[@class='clearfix bus-item  ']")
	private List<WebElement> results; // change selector based on the result cards
	
	
	private boolean isElementVisible(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	




	//POM driver    
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	}


	//Actions
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void scrollToLoadAllResults() {
	    if (results.isEmpty()) {
	        System.out.println("No results to scroll.");
	        return;
	    }

	    try {
	        wait.until(ExpectedConditions.visibilityOf(results.get(0)));
	    } catch (Exception e) {
	        System.out.println("First result is not visible. Skipping scroll.");
	        return;
	    }

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    int previousSize = 0;

	    while (true) {
	        int currentSize = results.size();
	        if (currentSize == previousSize) {
	            System.out.println("No more new items loaded. Total items: " + currentSize);
	            break;
	        }

	        previousSize = currentSize;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}



	
	public int getBusCount() {
	    if (isElementVisible(ViewGovBuses)) {
	        ViewGovBuses.click();
	    }

	    // If no results, exit immediately
	    if (results.isEmpty()) {
	        System.out.println("No bus results found.");
	        return 0;
	    }

	    scrollToLoadAllResults();
	    return results.size();
	}

	

	



}
