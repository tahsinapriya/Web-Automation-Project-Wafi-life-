package com.tahsina.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.tahsina.basedrivers.PageDriver;
import com.tahsina.utilities.GetScreenshot;


public class DashBoardPage {
	ExtentTest test;

	public DashBoardPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
		//this.driver = driver;
	}

	@FindBy(xpath = "//span[contains(text(),'লেখক')]")
	WebElement writer;
	
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	public void writer() throws IOException {
		try {
			test.info("Click on writer");
			if(writer.isDisplayed()) {
				writer.click();
				Thread.sleep(10000);
				passCaseWithSC("Clicked", "writerpass");
			}
		} catch (Exception e) {
			failCase("writer was not locateable.", "writerfail");
		}
	}
	//@FindBy(xpath= "//h3[contains(text(),'Md. Fazlul Haque')]")
	//WebElement fazlul;
	//public void ScrollandClickIntoFazlul() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
	    //js.executeScript("arguments[0].scrollIntoView(true);", fazlul);
	    //fazlul.click();
	    //System.out.println("hello");

	public void author() {
		// TODO Auto-generated method stub
		
	}
		
	//}
}	
	



