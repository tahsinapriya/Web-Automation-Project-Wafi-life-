package com.tahsina.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tahsina.pages.DashBoardPage;
import com.tahsina.utilities.ExtentFactory;


public class DashBoardTest {
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {
		//PageDriver.getCurrentDriver().get(url);
		//Thread.sleep(5000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#E40046; font-size:20px\"><b>WAFILIFE_WRITER</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test
	public void writerTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>WRITER</b></p>");
		DashBoardPage boardPage = new DashBoardPage(childTest);
		boardPage.writer();
		
	}
	//@Test
	/*public void ScrollandClickIntoFazlul () throws IOException  {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>WRITER</b></p>");
		DashBoardPage boardPage = new DashBoardPage(childTest);
		boardPage.ScrollandClickIntoFazlul();
		
		
	}	*/
	
	@AfterClass
	public void report() {
		report.flush();
	}


}
