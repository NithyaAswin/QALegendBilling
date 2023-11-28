package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;


public class ResetPage1 extends TestHelperUtility {

	public WebDriver driver;

	public ResetPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private final String _emailField = "Email";
	@FindBy(id = _emailField)
	private WebElement emailField;
	//find element input emailfield
			private final String _subEmailField = "//input[@id='email']"; //Inspect id and is pasted
			@FindBy(xpath = _subEmailField ) //if given xpath instead of id then give here as xpath=_subEmailField
			private WebElement subEmailField;
			

			private final String _sendPasswordReset = "//button[@class='btn btn-primary']";
			@FindBy(xpath = _sendPasswordReset ) //if given xpath instead of id then give here as xpath=_subEmailField
			private WebElement sendPasswordReset;
			
	
	
	private final String _actEmailError = "//span[@class='help-block']/strong";
	@FindBy(xpath = _actEmailError)
	private WebElement actEmailError;
	
	
	
	public void clickonPasswordReset() {
		page.clickOnElement(sendPasswordReset);
	}
	
	public void enterSubEmailID() //method of tc_002
	{
		String emailID = random.getRandomEmail();
		page.enterText(subEmailField, emailID);
	}
	
	public String getInvalidEmailError()
	{
		wait.setHardWait();//to stop exec and wait for message
		String actEmailErrorMessage = page.getElementText(actEmailError);
		return actEmailErrorMessage;
	}
}