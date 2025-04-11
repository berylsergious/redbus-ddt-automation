package com.redbus.testcase;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.redbus.base.Base;
import com.redbus.page.HomePage;
import com.redbus.page.SearchResultPage;
import com.redbus.utilities.Utils;



public class SearchResultTest extends Base {

	@DataProvider(name = "inputDataSupplier")
	public Object[][] supplyTestData(Method method) {
		Object[][] allData = Utils.getTestDataFromCSV();

		switch (method.getName()) {
		case "searchRoute1Day1":
			return new Object[][] { allData[0] }; // 1st row
		case "searchRoute2Day2":
			return new Object[][] { allData[1] }; // 2nd row
		case "searchRoute3Day3":
			return new Object[][] { allData[2] }; // 3rd row
		default:
			return new Object[0][];
		}
	}




	@Test(priority = 1, dataProvider = "inputDataSupplier")
	public void searchRoute1Day1(String from, String to, String date) {
		HomePage homePage = new HomePage(driver);


		homePage.selectDate(date);
		homePage.enterFromToCity(from, to);
		
		SearchResultPage searchPageResult = new SearchResultPage(driver);
		int  busCount = searchPageResult.getBusCount();
		Utils.writeHeaderIfNotExists(); // write headers once
		Utils.writeResultRow(from, to, date, busCount);

		System.out.println("Day 1: " + from + " -> " + to + " on " + date);
	}

	@Test(priority = 2, dataProvider = "inputDataSupplier")
	public void searchRoute2Day2(String from, String to, String date) {
		HomePage homePage = new HomePage(driver);

		homePage.selectDate(date);
		homePage.enterFromToCity(from, to);
		SearchResultPage searchPageResult = new SearchResultPage(driver);
		int  busCount = searchPageResult.getBusCount();
		Utils.writeResultRow(from, to, date, busCount);
		
		
		
		System.out.println("Day 2: " + from + " -> " + to + " on " + date);
		
		
		

		
	}	

	@Test(priority = 3, dataProvider = "inputDataSupplier")
	public void searchRoute3Day3(String from, String to, String date) {
		HomePage homePage = new HomePage(driver);
		homePage.selectDate(date);
		homePage.enterFromToCity(from, to);
		
		SearchResultPage searchPageResult = new SearchResultPage(driver);
		int  busCount = searchPageResult.getBusCount();
		Utils.writeResultRow(from, to, date, busCount);

		System.out.println("Day 3: " + from + " -> " + to + " on " + date);
	}





}
