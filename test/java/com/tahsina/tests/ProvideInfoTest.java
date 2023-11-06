package com.tahsina.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tahsina.pages.ProvideInfoPage;
import com.tahsina.utilities.ExtentFactory;

public class ProvideInfoTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {
		//PageDriver.getCurrentDriver().get(url);
		//Thread.sleep(5000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#E40046; font-size:20px\"><b>WAFILIFE_PROVIDEINFO</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test
	public void provideinfopage() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>PROVIDEINFO</b></p>");
		ProvideInfoPage provideinfo = new ProvideInfoPage(childTest);
		provideinfo.provideinfopage();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
	

}
