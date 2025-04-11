package com.redbus.base;

import com.redbus.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        driverManager = new DriverManager();
        driver = driverManager.initializeBrowserAndOpenApplicationURL("chrome");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
