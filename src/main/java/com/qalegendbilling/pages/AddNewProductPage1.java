package com.qalegendbilling.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddNewProductPage1 extends TestHelperUtility {
	public WebDriver driver;

	public AddNewProductPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _browseButton = "//span[text()='Browse..']";
	@FindBy(xpath = _browseButton)
	private WebElement browseButton;
	
	public void ClickonBrowse() throws AWTException, InterruptedException
	{
		wait.waitForElementToBeVisible(driver, browseButton);
		String path="Downloads/Capture";
		//browseButton.sendKeys(path);
		page.clickOnElement(browseButton);
		upload.FileUploadUsingRobotClass(driver, path);
		
	}
}