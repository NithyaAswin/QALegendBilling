package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class AddUserPage1 extends TestHelperUtility {
	public WebDriver driver;

	public AddUserPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _prefixfield = "//input[@id='surname']";
	@FindBy(xpath = _prefixfield)
	private WebElement prefixfield;
	
	private final String _firstnamefield = "//input[@id='first_name']";
	@FindBy(xpath = _firstnamefield)
	private WebElement firstnamefield;
	
	private final String _lastnamefield = "//input[@id='last_name']";
	@FindBy(xpath = _lastnamefield)
	private WebElement lastnamefield;
	
	private final String _eMailfield = "//input[@id='email']";
	@FindBy(xpath = _eMailfield)
	private WebElement eMailfield;
	
	private final String _userNamefield = "//input[@id='username']";
	@FindBy(xpath = _userNamefield)
	private WebElement userNamefield;
	
	private final String _passwordfield = "//input[@id='password']";
	@FindBy(xpath = _passwordfield)
	private WebElement passwordfield;
	
	private final String _confirmpasswordfield = "//input[@id='confirm_password']";
	@FindBy(xpath = _confirmpasswordfield)
	private WebElement confirmpasswordfield;
	
	private final String _SCPercentfield = "//input[@id='cmmsn_percent']";
	@FindBy(xpath = _SCPercentfield)
	private WebElement scPercentfield;
	
	private final String _savebutton = "//button[@id='submit_user_button']";
	@FindBy(xpath = _savebutton)
	private WebElement savebutton;
	
	private final String _FNameError = "//label[@id='first_name-error']";
	@FindBy(xpath = _FNameError)
	private WebElement FNameError;
	
	private final String _eMailError = "//label[@id='email-error']";
	@FindBy(xpath = _eMailError)
	private WebElement eMailError;
	
	private final String _UsernameError = "//label[@id='username-error']";
	@FindBy(xpath = _UsernameError)
	private WebElement UsernameError;
	
	private final String _confirmPasswordError = "//label[@id='confirm_password-error']";
	@FindBy(xpath = _confirmPasswordError)
	private WebElement confirmPasswordError;
	
	
	
	public void enterPrefix(String prefix) {
		wait.waitForElementToBeVisible(driver, prefixfield);
		page.enterText(prefixfield, prefix);
	}
	
	public void enterFirstName(String fName) 
	{
		//String firstName = random.getfName();
		wait.waitForElementToBeVisible(driver, firstnamefield);
		page.enterText(firstnamefield, fName);
	}
	public void enterLastName(String lName) 
	{
		//String lastName = random.getlName();
		page.enterText(lastnamefield, lName);
	}
	public void enterEmail(String eMail) 
	{
		//String eMail = random.getRandomEmail();
		page.enterText(eMailfield, eMail);
	}
	public void enterUsername(String uName) 
	{	
		//String firstName = random.getfName();
		//String lastName = random.getlName();
		//String userName = firstName.concat(lastName);
		page.enterText(userNamefield, uName);
	}
	public void enterPassword(String password) 
	{
		//String firstName = random.getfName();
		//String password = firstName + "@123";
		page.enterText(passwordfield, password);
	}
	public void enterConfirmPassword(String password) 
	{
		//String firstName = random.getfName();
		//String password = firstName + "@123";
		page.enterText(confirmpasswordfield, password);
	}
	public void enterSCPercent(String SCPercent)
	{
		page.enterText(scPercentfield, SCPercent);
	}
	public UserPage1 clickonSaveButton()
	{
		page.clickOnElement(savebutton);
		return new UserPage1(driver);
	}
	public String getFNameFieldError()
	{
		wait.setHardWait();//to stop exec and wait for message
		String actFNameFieldErrorMessage = page.getElementText(FNameError);
		return actFNameFieldErrorMessage;
	}
	public String geteMailFieldError()
	{
		wait.setHardWait();//to stop exec and wait for message
		String acteMailFieldErrorMessage = page.getElementText(eMailError);
		return acteMailFieldErrorMessage;
	}
	public String getUserNameFieldError()
	{
		wait.setHardWait();//to stop exec and wait for message
		String actUserNameFieldErrorMessage = page.getElementText(UsernameError);
		return actUserNameFieldErrorMessage;
	}
	public String getConfirmPasswordFieldError()
	{
		wait.setHardWait();//to stop exec and wait for message
		String actConfirmPasswordFieldErrorMessage = page.getElementText(confirmPasswordError);
		return actConfirmPasswordFieldErrorMessage;
	}
	
}