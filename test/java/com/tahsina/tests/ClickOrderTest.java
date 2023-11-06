package com.tahsina.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tahsina.pages.ClickOrderPage;
import com.tahsina.utilities.ExtentFactory;

public class ClickOrderTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {
		//PageDriver.getCurrentDriver().get(url);
		//Thread.sleep(5000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#E40046; font-size:20px\"><b>WAFILIFE_CLICKORDER</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test
	public void clickorderTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CLICKORDER</b></p>");
		ClickOrderPage clickorderPage= new ClickOrderPage(childTest);
		clickorderPage.clickorder();
		
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}



}
