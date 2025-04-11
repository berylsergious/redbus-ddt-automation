package com.redbus.page;




import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait ;

//Elements
    @FindBy(xpath="//input[@id='src']")
    private WebElement FromInput;
    
    @FindBy(xpath="//input[@id='dest']")
    private WebElement ToInput;
    
    @FindBy(id="search_button")
    private WebElement SearchButton;
    
    
    
    @FindBy(xpath="//div[@id='onwardCal']")
    private WebElement DateSection;
    
    @FindBy(xpath="//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][1]")
    private WebElement PreviousArrow;
    
    @FindBy(xpath="//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]")
    private WebElement CurrentDate;
    
    @FindBy(xpath="//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]")
    private WebElement NextArrow;

    
//POM driver    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait (driver, Duration.ofSeconds(10));
    }

    
//Actions
    public String getPageTitle() {
        return driver.getTitle();
    }


    public void enterFromToCity (String FromCity, String ToCity) {
    	
    	FromInput.sendKeys(FromCity + Keys.ENTER);
    	WebElement desiredFromCity = wait.until(ExpectedConditions
    	        .visibilityOfElementLocated(By.xpath("//text[@class='placeHolderMainText' and normalize-space(text())='" + FromCity + "']")));
    	    
    	desiredFromCity.click();
    	
    	ToInput.sendKeys(ToCity + Keys.ENTER);
    	WebElement desiredToCity = wait.until(ExpectedConditions
    	        .visibilityOfElementLocated(By.xpath("//text[@class='placeHolderMainText' and normalize-space(text())='" + ToCity + "']")));
    	    
    	desiredToCity.click();
    	
    	SearchButton.click();
    	
    	
    }
    
    public void selectDate(String inputDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate targetDate = LocalDate.parse(inputDate, formatter);

        int targetDay = targetDate.getDayOfMonth();
        String targetDayStr = String.valueOf(targetDay);
        int targetMonth = targetDate.getMonthValue();
        int targetYear = targetDate.getYear();

        DateSection.click();

        while (true) {
        	
        	String displayedMonthYear = CurrentDate.getText().split("\\R")[0].trim();
            System.out.println(displayedMonthYear);
            YearMonth displayed = YearMonth.parse(displayedMonthYear, DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH));
            YearMonth target = YearMonth.of(targetYear, targetMonth);

            if (displayed.equals(target)) break;

            NextArrow.click();
        }

        WebElement DateToBeSelected = driver.findElement(By.xpath("//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']//span[contains(text(), '"+ targetDayStr +"')]"));
        
        DateToBeSelected =  wait.until(ExpectedConditions.elementToBeClickable(DateToBeSelected));
        DateToBeSelected.click();
        
    }

    

    
    
    
}

