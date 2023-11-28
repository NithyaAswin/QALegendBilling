package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class LoginPage1 extends TestHelperUtility {
	public WebDriver driver;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _usernameField = "username";
	@FindBy(id = _usernameField)
	private WebElement usernameField;

	private final String _passwordField = "password";
	@FindBy(id = _passwordField)
	private WebElement passwordField;

	private final String _loginButton = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _loginButton)
	private WebElement loginButton;

	private final String _endTourButton = "//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _endTourButton)
	private WebElement endTourButton;
	
	// find element input emailfield
	private final String _subEmailField = "newsletter-email"; // Inspect id and is pasted
	@FindBy(id = _subEmailField) // if given xpath instead of id then give here as xpath=_subEmailField
	private WebElement subEmailField;

	private final String _forgotPassword = "//a[@class='btn btn-link']";
	@FindBy(xpath = _forgotPassword)
	private WebElement forgotPassword;
	
	public void enterUsername(String username) {
		wait.waitForElementToBeVisible(driver, usernameField);
		page.enterText(usernameField, username);// second parameter read data from excel sheet which in Login test
	}
	public void enterUserPassword(String password) {
		page.enterText(passwordField, password);
	}
	public HomePage1 clickonLoginButton() {
		page.clickOnElement(loginButton);
		page.clickOnElement(endTourButton);
		return new HomePage1(driver);
	}
	public HomePage1 clickonLoginwithoutEndTourButton() {
		page.clickOnElement(loginButton);
		return new HomePage1(driver);
	}
	
	public ResetPage1 clickonForgotPassword() {
		page.clickOnElement(forgotPassword);
		return new ResetPage1(driver);
	}
	
	public void enterSubEmailID() // method of tc_002
	{
		String emailID = random.getRandomEmail();
		page.enterText(subEmailField, emailID);
	}

	public String getLoginPageTitle()
	{
		String title = page.getPageTitle(driver);
		return title;
	}

	

	public void clickonLoginButton1() {
		page.clickOnElement(loginButton);
	}

}
