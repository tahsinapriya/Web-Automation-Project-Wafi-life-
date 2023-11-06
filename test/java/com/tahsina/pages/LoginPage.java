package com.tahsina.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//         import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.tahsina.utilities.GetScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.tahsina.basedrivers.PageDriver;



public class LoginPage {
	ExtentTest test;

	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	
	@FindBy(xpath = "//input[@id='username']") 
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;
	
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

	public void login() throws InterruptedException, IOException {

		try {
			test.info("Please enter username");
			if (username.isDisplayed()) {
				username.sendKeys("tahsinapriya@gmail.com");
				passCase("Username entered");

				try {
					test.info("Enter password");
					if (password.isDisplayed()) {
						password.sendKeys("1#Tanzina");
						passCase("Password send");

						try {
							test.info("Click on the login");
							if (loginButton.isDisplayed()) {
								loginButton.click();
								Thread.sleep(10000);
								passCaseWithSC("Login successfull", "loginPass");
							}
						} catch (Exception e) {
							failCase("Login button was not locateable. Please check the error message",
									"loginbuttonfail");
						}

					}
				} catch (Exception e) {
					failCase("Password was not locateable. Please check the error message", "passwordfail");
				}

			}
		} catch (Exception e) {
			failCase("Username was not locateable. Please check the error message", "usernamefail");
		}

	}

	

}
