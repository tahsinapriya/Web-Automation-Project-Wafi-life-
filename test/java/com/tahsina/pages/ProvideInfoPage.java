package com.tahsina.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.tahsina.basedrivers.PageDriver;
import com.tahsina.utilities.GetScreenshot;

public class ProvideInfoPage {
	ExtentTest test;

	public ProvideInfoPage (ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	
	@FindBy(xpath = "//input[@id='billing_first_name']") 
	WebElement username;

	@FindBy(xpath = "//input[@id='billing_phone']")
	WebElement phone;

	@FindBy(xpath = "//input[@id='billing_email']")
	WebElement email;
	
	@FindBy(xpath = "//select[@id='billing_state']")
	WebElement state;
	
	@FindBy(xpath = "//select[@id='billing_area']") 
	WebElement area;

	@FindBy(xpath = "//textarea[@id='billing_address_1']") 
	WebElement address;
	
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
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
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	public void provideinfopage() throws InterruptedException, IOException {

		try {
			test.info("Please enter username");
			if (username.isDisplayed()) {
				username.sendKeys("tahsina priya");
				passCase("Username entered");

				try {
					test.info("Enter phone");
					if (phone.isDisplayed()) {
						phone.sendKeys("01715315378");
						passCase("phone entered");
						
						try {
							test.info("Enter email");
							if (email.isDisplayed()) {
								email.sendKeys("tahsinapriya@gmail.com");
								passCase("email entered");
								

								try {
									test.info("Enter state");
									if (state.isDisplayed()) {
										Select select = new Select(state);
										select.selectByVisibleText("Barishal");
										Thread.sleep(3000);
										passCase("state entered");

									 
										try {
											test.info("Enter state");
											if (area.isDisplayed()) {
												Select select1 = new Select(area);
												select1.selectByVisibleText("আগৈলঝাড়া");
												Thread.sleep(3000);
												passCase("area entered");

											try {
												test.info("Enter address");
												if (address.isDisplayed()) {
													address.sendKeys("uttara , sector 11");
													passCase("address entered");
											}
									
								} catch (Exception e) {
									failCase("address  was not locateable. Please check the error message",
									"addressfail");
								}

							}
						} catch (Exception e) {
							failCase("area was not locateable. Please check the error message", "areafail");
						}
					}
				} catch (Exception e) {
					failCase("state was not locateable. Please check the error message", "statefail");
				}
			}
							
		}catch (Exception e) {
			failCase("email was not locateable. Please check the error message", "emailfail");
		}
	}
}catch (Exception e) {
	failCase("phone was not locateable. Please check the error message", "phonefail");
    }
  }
}catch (Exception e) {
	failCase("Username was not locateable. Please check the error message", "usernamefail");	
    }
   }
}

	

		
			
